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
public class AtLeastOne implements Criterion{
    
    private Criterion[] op;
    
    public AtLeastOne(Criterion... num){
        this.op = num;
    }

    @Override
    public boolean complies(String line) {
        for(Criterion c : op){
            if(c.complies(line)){
                return true;
            }
        }
        return false;
    }
    
}
