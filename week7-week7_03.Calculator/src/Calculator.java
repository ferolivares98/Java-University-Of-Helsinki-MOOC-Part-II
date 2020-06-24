
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
public class Calculator {
    private Reader reader;
    private int stat;
    
    public Calculator(){
        this.reader = new Reader();
        this.stat = 0;
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                stat++;
            } else if (command.equals("difference")) {
                difference();
                stat++;
            } else if (command.equals("product")) {
                product();
                stat++;
            }
        }

        statistics();
    }
    
    private void sum(){
        int[] v = readUsu();
        System.out.println("sum of the values" + (v[0] + v[1]));
    }
    
    private void difference(){
        int[] v = readUsu();
        System.out.println("difference of the values" + (v[0] - v[1]));
    }
    
    private void product(){
        int[] v = readUsu();
        System.out.println("product of the values" + (v[0] * v[1]));
    }
    
    private void statistics(){
        System.out.println("Calculations done " + stat);
    }
    
    private int[] readUsu(){
        int[] array = new int[2];
        
        System.out.print("value1: ");
        array[0] = reader.readInteger();
        System.out.println("value2: ");
        array[1] = reader.readInteger();
        
        return array;
    }
}
