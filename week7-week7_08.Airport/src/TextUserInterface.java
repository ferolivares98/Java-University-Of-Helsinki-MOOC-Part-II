
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
class TextUserInterface {
    private Scanner reader;
    private HashMap<String, Airplane> airplanes;
    private ArrayList<Flight> flights;
    
    public TextUserInterface(Scanner reader){
        this.reader = reader;
        this.airplanes = new HashMap<String, Airplane>();
        this.flights = new ArrayList<Flight>();
    }

    public void startAirportPanel() {
        
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        while(true){
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            String op = reader.nextLine();
            
            if(op.equals("1")){
                addAirplane();
            }else if(op.equals("2")){
                addFlight();
            }else if(op.equals("x")){
                break;
            }
        }
        
        System.out.println("");
    }
    
    public void addAirplane(){
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int cap = Integer.parseInt(reader.nextLine());
        
        this.airplanes.put(id, new Airplane(id, cap));
    }
    
    public void addFlight(){
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String dep = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String arr = reader.nextLine();
        
        Airplane a = airplanes.get(id);
        this.flights.add(new Flight(a, dep, arr));
    }
    
    
    public void startFlightService(){
        
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        
        while(true){
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            String op = reader.nextLine();
            
            if(op.equals("1")){
                printPlanes();
            }else if(op.equals("2")){
                printFlights();
            }else if(op.equals("3")){
                planeInfo();
            }else if(op.equals("x")){
                break;
            }
        }
        
        System.out.println("");
    }
    
    public void printPlanes(){
        for(Airplane a : airplanes.values()){
            System.out.println(a.toString());
        }
    }
    
    public void printFlights(){
        for(Flight f : flights){
            System.out.println(f.toString());
        }
    }
    
    public void planeInfo(){
        System.out.print("Give plane ID: ");
        String p = reader.nextLine();
        if(airplanes.containsKey(p)){
            System.out.println(airplanes.get(p).toString());
        }
    }
    
}
