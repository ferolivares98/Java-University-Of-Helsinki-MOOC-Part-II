/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author fernando
 */
public class PersonComparator implements Comparator<Person>{
    
    private Map<Person, Integer> listMap;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities){
        this.listMap = peopleIdentities;
    }

    @Override
    public int compare(Person t, Person t1) {
        if(listMap.get(t) == listMap.get(t1)){
            return 0;
        }else if(listMap.get(t) < listMap.get(t1)){
            return 1;
        }
        return -1;
    }


    
}
