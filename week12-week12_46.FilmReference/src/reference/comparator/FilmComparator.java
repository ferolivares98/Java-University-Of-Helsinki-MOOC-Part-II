/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author fernando
 */
public class FilmComparator implements Comparator<Film>{
    
    private Map<Film, List<Rating>> listMap;
    
    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.listMap = ratings;
    }

    @Override
    public int compare(Film t, Film t1) {
        List<Rating> listForT = listMap.get(t);
        List<Rating> listForT1 = listMap.get(t1);
        
        double ratingT = 0, ratingT1 = 0;
        
        for(Rating r : listForT){
            ratingT += r.getValue();
        }
        for(Rating r1: listForT1){
            ratingT1 += r1.getValue();
        }
        
        ratingT /= listForT.size();
        ratingT1 /= listForT1.size();
        
        if(ratingT == ratingT1){
            return 0;
        }else if(ratingT < ratingT1){
            return 1;
        }
        return -1;
    }
    
}
