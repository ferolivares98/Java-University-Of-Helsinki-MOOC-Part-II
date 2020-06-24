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
public class Not implements Criterion{
    
    private Criterion op;
    
    public Not(Criterion one){
        this.op = one;
    }

    @Override
    public boolean complies(String line) {
        if(op.complies(line)){
            return false;
        }
        return true;
    }
    
}
