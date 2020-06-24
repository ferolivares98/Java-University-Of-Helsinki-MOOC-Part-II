/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author fernando
 */
public class PersonalDuplicateRemover implements DuplicateRemover{
    
    private Set<String> duplicateRemover;
    private int duplicateAmount;
    
    public PersonalDuplicateRemover() {
        this.duplicateRemover = new HashSet<String>();
        this.duplicateAmount = 0;
    }

    @Override
    public void add(String characterString) {
        if(duplicateRemover.contains(characterString)){
            duplicateAmount++;
        }else{
            duplicateRemover.add(characterString);
        }
        
        /*boolean added = strings.add(characterString);
        if (!added) {
            numberOfDuplicates++;
        }*/
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return duplicateAmount;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return duplicateRemover;
    }

    @Override
    public void empty() {
        duplicateRemover = new HashSet<String>(); //duplicateremover.clear();
        duplicateAmount = 0;
    }
    
}
