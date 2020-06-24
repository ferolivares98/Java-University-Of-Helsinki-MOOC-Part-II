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
public class Both implements Criterion{
    
    private Criterion firstOp;
    private Criterion secondOp;
    
    public Both(Criterion one, Criterion two){
        this.firstOp = one;
        this.secondOp = two;
    }

    @Override
    public boolean complies(String line) {
        if(firstOp.complies(line) && secondOp.complies(line)){
            return true;
        }
        return false;
    }
    
}
