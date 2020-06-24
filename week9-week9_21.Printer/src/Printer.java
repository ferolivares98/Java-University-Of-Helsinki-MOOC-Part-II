
import java.io.File;
import java.io.FileNotFoundException;
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
public class Printer {
    private File f; //Se puede agregar directamente al scanner con Scanner tdst = new Scanner(new File(t));
    private Scanner reader;
    
    public Printer(String fileName) throws Exception{
        f = new File(fileName);
        reader = new Scanner(f, "UTF-8");
    }
    
    public void printLinesWhichContain(String word) throws FileNotFoundException{
        reader = new Scanner(f, "UTF-8"); //Para poner el puntero al principio en m'ultiples lecturas. También se puede cargar el archivo a un Array.
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            if(line.contains(word)){
                System.out.println(line);
            }
        }
        reader.close();
    }
}
