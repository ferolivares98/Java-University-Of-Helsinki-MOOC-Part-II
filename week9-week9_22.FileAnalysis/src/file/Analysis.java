/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author fernando
 */
public class Analysis {
    
    private Scanner tdst;
    private List<String> fileRead;
    
    public Analysis (File file) throws FileNotFoundException{
        tdst = new Scanner(file);
        fileRead = new ArrayList<String>();
        
        while(tdst.hasNextLine()){
            fileRead.add(tdst.nextLine() + "\n"); //Se necesita el \n para diferencial líneas (o el ejercicio fallará).
        }
    }
    
    public int lines(){
        return fileRead.size();
    }
    
    public int characters(){
        int totalCar = 0;
        
        for(String s : fileRead){
            totalCar += s.length();
        }
        return totalCar;
    }
}
