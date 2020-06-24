/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonesearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author fernando
 */
public class UserInterface {
    
    private Set<Person> phonebook;
    private Scanner reader;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.phonebook = new HashSet<Person>();
    }

    public void start() {
        System.out.print("\nphone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n\n");
        this.leerEntrada();
    }

    private void leerEntrada() {
        while (true) {
            System.out.println("command: ");
            String command = reader.nextLine();
            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                this.addNumber();
            } else if (command.equals("2")) {
                this.searchNumberByName();
            } else if (command.equals("3")) {
                this.searchNameByNumber();
            } else if (command.equals("4")) {
                this.addAddress();
            } else if (command.equals("5")) {
                this.searchPersonalInfo();
            } else if (command.equals("6")) {
                this.deletePersonalInfo();
            } else if (command.equals("7")) {
                this.printByKeyword();
            }
        }
    }

    private void addNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        System.out.println("number: ");
        String number = reader.nextLine();
        
        for(Person p : phonebook){
            if(p.getName().equals(name)){
                p.addNewNumber(number);
                return;
            }
        }
        phonebook.add(new Person(name, number));
    }

    private void searchNumberByName() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        
        for(Person p : phonebook){
            if(p.getName().equals(name)){
                System.out.println("  " + p.getNumber());
                return;
            }
        }
        System.out.println("  not found");
    }

    private void searchNameByNumber() {
        System.out.println("number: ");
        String number = reader.nextLine();
        
        for(Person p : phonebook){
            if(p.getNumber().contains(number)){
                System.out.println("  " + p.getName());
                return;
            }
        }
        System.out.println("  not found");
    }

    private void addAddress() {
        System.out.println("whose address: ");
        String name = reader.nextLine();
        System.out.println("street: ");
        String street = reader.nextLine();
        System.out.println("city: ");
        String city = reader.nextLine();
        
        for(Person p : phonebook){
            if(p.getName().equals(name)){
                p.setStreet(street);
                p.setCity(city);
                return;
            }
        }
        
        phonebook.add(new Person(name, street, city));
    }

    private void searchPersonalInfo() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
        
        for(Person p : phonebook){
            if(p.getName().equals(name)){
                if(!p.getStreet().isEmpty() || !p.getCity().isEmpty()){
                    System.out.println("  address: " + p.getStreet() + " " + p.getCity());
                }else{
                    System.out.println("  address unknown");
                }
                if(!p.getNumber().isEmpty()){
                    System.out.println("  phone numbers: " + p.getNumber());
                }else{
                    System.out.println("  phone number not found");
                }
                return;
            }
        }
        System.out.println("  not found");
    }

    private void deletePersonalInfo() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
        
        for(Person p : phonebook){
            if(p.getName().equals(name)){
                phonebook.remove(p);
                return;
            }
        }
        System.out.println("  not found");
    }

    private void printByKeyword() {
        System.out.println("keyword (if empty, all listed: ");
        String key = reader.nextLine();
        
        List<Person> alphOrder = new ArrayList<Person>();
        
        for(Person p : phonebook){
            if(key.isEmpty() || p.getName().contains(key) || p.getCity().contains(key) || p.getStreet().contains(key)){
                alphOrder.add(p);
            }
        }
        
        Collections.sort(alphOrder);
        
        if(alphOrder.isEmpty()){
            System.out.println("  keyword not found");
        }else{
            for(Person p : alphOrder){
                System.out.println("  " + p.getName());
                if(!p.getStreet().isEmpty() || !p.getCity().isEmpty()){
                    System.out.println("   address: " + p.getStreet() + " " + p.getCity());
                }else{
                    System.out.println("   address unknown");
                }
                if(!p.getNumber().isEmpty()){
                    System.out.println("   phone numbers: " + p.getNumber());
                }else{
                    System.out.println("   phone number not found");
                }
            }
        }
    }
}
