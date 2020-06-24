/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author fernando
 */
public class EndsWithQuestionOrExclamationMark implements Criterion{

    @Override
    public boolean complies(String line) {
        if(line.isEmpty()){
            return false;
        }
        
        int lineLength = line.length();
        
        if(line.charAt(lineLength - 1) == '?' || line.charAt(lineLength - 1) == '!'){
            return true;
        }
        return false;
    }
    
}
