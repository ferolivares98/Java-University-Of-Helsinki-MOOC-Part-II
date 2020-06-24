/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class ContainerHistory {
    
    private List<Double> hist;
    
    
    public ContainerHistory(){
        this.hist = new ArrayList<Double>();
    }
    
    public void add(double situation){
        hist.add(situation);
    }
    
    public void reset(){
        hist.clear();
    }
    
    @Override
    public String toString(){
        return hist.toString();
    }
    
    public double maxValue(){
        double maxi = 0;
        
        if(hist.isEmpty()){
            return maxi;
        }
        maxi = hist.get(0); //También se puede mirar size mayor que 0.
        for(double d : hist){
            maxi = Math.max(maxi, d);
        }
        return maxi;
    }
    
    public double minValue(){
        double mini = 0;
        
        if(hist.isEmpty()){
            return mini;
        }
        
        mini = hist.get(0);
        for(double d : hist){
            mini = Math.min(mini, d);
        }
        return mini;
    }
    
    public double average(){
        double av = 0;
        
        if(hist.isEmpty()){
            return av;
        }else{
            for(double d : hist){
                av += d;
            }
        }
        av = av/hist.size();
        return av;
    }
    
    public double greatestFluctuation(){
        double fl = 0, aux = 0;
        
        if(hist.size() > 1){
            fl = Math.abs(hist.get(0) - hist.get(1));
            for(int i = 0; i < hist.size()-1; i++){
                aux = Math.abs(hist.get(i) - hist.get(i + 1));
                if(fl < aux){
                    fl = aux;
                }
            }
        }
        return fl;
    }
    
    public double variance(){
        double var = 0;
        
        if(hist.size() > 1){
            double average = this.average();
            
            for(double d : hist){
                var += Math.pow((d - average), 2);
            }
            var = var/(hist.size() - 1);
        }
        
        return var;
    }
}
