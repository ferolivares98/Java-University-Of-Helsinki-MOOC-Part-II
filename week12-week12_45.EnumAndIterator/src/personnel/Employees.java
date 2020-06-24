/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author fernando
 */
public class Employees {
    ArrayList<Person> emp;
    
    public Employees(){
        this.emp = new ArrayList<Person>();
    }
    
    public void add(Person person){
        this.emp.add(person);
    }
    
    public void add(List<Person> persons){
        for(Person p : persons){
            this.emp.add(p);
        }
    }
    
    public void print(){
        Iterator<Person> iterator = this.emp.iterator();
        
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education){
        Iterator<Person> iterator = this.emp.iterator();
        
        while(iterator.hasNext()){
            Person aux = iterator.next();
            if(aux.getEducation() == education){
                System.out.println(aux);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iterator = this.emp.iterator();
        
        while(iterator.hasNext()){
            if(iterator.next().getEducation().equals(education)){
                iterator.remove();
            }
        }
    }
    
}
