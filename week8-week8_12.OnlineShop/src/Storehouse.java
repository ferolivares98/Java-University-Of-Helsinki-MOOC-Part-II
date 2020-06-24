
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Storehouse {
    private Map<String, Integer> listPrices;
    private Map<String, Integer> listStocks;
    
    public Storehouse(){
        this.listPrices = new HashMap<String, Integer>();
        this.listStocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock){
        this.listPrices.put(product, price);
        this.listStocks.put(product, stock);
    }
    
    public int price(String product){
        if(this.listPrices.containsKey(product)){
            return this.listPrices.get(product);
        }
        
        return -99;
    }
    
    public int stock(String product){
        if(this.listStocks.containsKey(product)){
            return this.listStocks.get(product);
        }
        return 0;
    }
    
    public boolean take(String product){
        int aux = stock(product);
        
        if(aux > 0){
            this.listStocks.put(product, aux-1);
            return true;
        }
        
        return false;
    }
    
    public Set<String> products(){
        return this.listStocks.keySet();
    }
}
