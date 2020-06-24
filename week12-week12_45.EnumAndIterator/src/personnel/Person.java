/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

/**
 *
 * @author fernando
 */
public class Person {
    private String name;
    private Education educationTitle;
    
    public Person(String name, Education educationTitle){
        this.name = name;
        this.educationTitle = educationTitle;
    }
    
    public Education getEducation(){
        return educationTitle;
    }
    
    @Override
    public String toString(){
        return this.name + ", " + this.educationTitle;
    }
}
