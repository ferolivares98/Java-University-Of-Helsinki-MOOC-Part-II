
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class UserInterface {
    
    private Scanner reader;
    private List<Jumper> jumpersList;
    
    public UserInterface(){
        this.reader = new Scanner(System.in);
        this.jumpersList = new ArrayList<Jumper>();
    }

    void comienzo() {
        nombres();
        torneo();
        resultadosFinales();
    }
    
    public void nombres(){
        System.out.printf("Kumpula ski jumping week\n\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        for(;;) {
            System.out.println("  Participant name: ");
            String name = reader.nextLine();
            if (name.equals("")) {
                break;
            }
            this.jumpersList.add(new Jumper(name));
        }
        System.out.println("");
    }

    private void torneo() {
        int ronda = 1; //Para imprimir y llevar cuenta de la ronda.
        
        for(;;){
            System.out.println("The tournament begins!\n"
                    + "\n"
                    + "Write \"jump\" to jump; otherwise you quit: ");
            String lectura = reader.nextLine();

            if (!lectura.equals("jump")) {
                break;
            }

            System.out.println("\nRound " + ronda + "\n");

            ordenDeSalto(ronda);
            resultadosDeRonda(ronda);
            ronda++;
        }
        System.out.println("\nThanks!\n");
    }

    private void resultadosFinales() {
        System.out.println("Tournament results:\n"
                + "Position    Name");
        int orden = 1;
        Collections.reverse(this.jumpersList);
        for (Jumper j : this.jumpersList) {
            System.out.println(orden + "" + j); //Que es como poner j.toString() pero no es necesario por el Override.
            orden++;
        }
    }

    private void ordenDeSalto(int ronda) {
        System.out.println("Jumping order:");
        int orden = 1;
        
        for(Jumper jumper : this.jumpersList){
            System.out.println("  " + orden + ". " + jumper.printJumperResultsOfEachRound());
            jumper.jump(ronda);
            orden++;
        }
        System.out.println("");
    }

    private void resultadosDeRonda(int ronda) {
        System.out.println("Results of round " + ronda);
        for (Jumper jumper : this.jumpersList) {
            System.out.println("  " + jumper.getName());
            System.out.println(jumper.getPoints(ronda)); //Override de Points aquí.
        }
        System.out.println("");
        Collections.sort(this.jumpersList);
    }
    
}
