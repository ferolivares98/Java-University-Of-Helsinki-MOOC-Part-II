/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesearch;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class Person implements Comparable<Person>{
    
    private String name = "";
    private List<String> numberList;
    private String street = "";
    private String city = "";
    
    public Person(String name, String number){
        setName(name);
        this.numberList = new ArrayList<String>();
        numberList.add(number);
    }
    
    public Person(String name, String street, String city){
        setName(name);
        this.numberList = new ArrayList<String>();
        setStreet(street);
        setCity(city);
    }

    public String getName() {
        return name;
    }

    public List<String> getNumber() {
        return numberList;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }
    

    void addNewNumber(String number) {
        numberList.add(number);
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int compareTo(Person t) {
        return this.name.compareTo(t.getName());
    }
    
    
}
