/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author fernando
 */
public class Reference {
    
    private RatingRegister registro;
    
    public Reference(RatingRegister rr){
        this.registro = rr;
    }
    
    public Film recommendFilm(Person person){
        if(registro.getPersonalRatings(person).isEmpty()){
            Map<Film, List<Rating>> filmMap = registro.filmRatings();
            List<Film> filmList = new ArrayList<Film>(filmMap.keySet());

            Collections.sort(filmList, new FilmComparator(registro.filmRatings()));
            return filmList.get(0);
        }
        List<Person> personComparatorForSimilarity = personBySimilarity(person);
        
        return perfectFilm(person, personComparatorForSimilarity);
    }
    
    private List<Person> personBySimilarity(Person person){
        //Similar reviews.
        Map<Person, Integer> similar = new HashMap<Person, Integer>();
        Map<Film, Rating> filmList = registro.getPersonalRatings(person);
        
        //Para cada reviewer.
        for(Person p : registro.reviewers()){
            int sim = 0;
            
            for(Film f : filmList.keySet()){
                sim += filmList.get(f).getValue() * registro.getRating(p, f).getValue();
            }
            
            if(sim > 0){
                similar.put(p, sim);
            }
        }
        
        //Comparamos la lista final.
        List<Person> reviewersSimilares = new ArrayList<Person>(similar.keySet());
        Collections.sort(reviewersSimilares, new PersonComparator(similar));
        
        return reviewersSimilares;
    }

    private Film perfectFilm(Person person, List<Person> personComparatorForSimilarity) {
        Map<Film, Rating> filmViewd = registro.getPersonalRatings(person);
        
        for(Person p : personComparatorForSimilarity){
            if(p.equals(person)){
                continue;
            }
            
            for(Film f : registro.getPersonalRatings(p).keySet()){
                if(filmViewd.containsKey(f)){
                    continue;
                }
                if(registro.getPersonalRatings(p).get(f).getValue() > 1){
                    return f;
                    //Va a devolver la peli más acorde de la persona más coincidente. La primera de todo (lo que puede) porque ya está ordenado.
                }
            }
        }
        return null;
    }
    
    
}
