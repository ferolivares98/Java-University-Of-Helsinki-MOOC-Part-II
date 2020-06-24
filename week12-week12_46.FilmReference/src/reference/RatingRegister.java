/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author fernando
 */
public class RatingRegister {
    
    private Map<Film, List<Rating>> listFilm;
    private Map<Person, Map<Film, Rating>> listReviewer;
    
    public RatingRegister(){
        this.listFilm = new HashMap<Film, List<Rating>>();
        this.listReviewer = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating){
        if(!listFilm.containsKey(film)){
            listFilm.put(film, new ArrayList<Rating>());
        }
        listFilm.get(film).add(rating);
    }
    
    public List<Rating> getRatings(Film film){
        return listFilm.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings(){
        return listFilm;
    }
    
    public void addRating(Person person, Film film, Rating rating){
        if (!listReviewer.containsKey(person)) {
            listReviewer.put(person, new HashMap<Film, Rating>());
            listReviewer.get(person).put(film, rating);
            addRating(film, rating);
        } else if (!listReviewer.get(person).containsKey(film)) { //Solo una nota por peli.
            listReviewer.get(person).put(film, rating);
            addRating(film, rating);
        }
    }
    
    public Rating getRating(Person person, Film film){
        if(!listReviewer.containsKey(person)){
            return Rating.NOT_WATCHED;
        }else if(!listReviewer.get(person).containsKey(film)){
            return Rating.NOT_WATCHED;
        }
        return listReviewer.get(person).get(film);
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person){
        if (!listReviewer.containsKey(person)) {
            return new HashMap();
        }
        
        return listReviewer.get(person);
    }
    
    public List<Person> reviewers(){
        return new ArrayList<Person>(listReviewer.keySet());
    }
}
