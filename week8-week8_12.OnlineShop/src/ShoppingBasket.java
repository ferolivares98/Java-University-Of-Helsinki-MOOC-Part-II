
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class ShoppingBasket {
    private Map<String, Purchase> shoppingBasket;
    
    public ShoppingBasket(){
        this.shoppingBasket = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price){
        if(this.shoppingBasket.containsKey(product)){
            this.shoppingBasket.get(product).increaseAmount();
        }else{
            this.shoppingBasket.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price(){
        int aDev = 0;
        
        for(Purchase p : this.shoppingBasket.values()){
            aDev += p.price();
        }
        
        return aDev;
    }
    
    public void print(){
        for(Purchase p : this.shoppingBasket.values()){
            System.out.println(p.toString());
        }
    }
}
