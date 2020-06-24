
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Points {
    
    private int distancia;
    private List<Integer> votos;
    private Random random;

    public Points() {
        this.random = new Random();
        this.distancia = random.nextInt(61) + 60;
        this.votos = new ArrayList<Integer>();

        for (int i = 0; i < 5; i++) {
            this.votos.add(this.random.nextInt(11) + 10);
        }
    }

    public int getLength() {
        return this.distancia;
    }
    
    public int getPoints(){
        return this.distancia + this.getSoloVotosValidos();
    }

    private int getSoloVotosValidos() {
        Collections.sort(this.votos);
        int totalValidos = 0;
        for(int i = 1; i < 4; i++){
            totalValidos += this.votos.get(i);
        }
        return totalValidos;
    }
    
    public String printVotos() {
        String votosParaImp = "[";
        for (int i = 0; i < 4; i++) {
            votosParaImp += this.votos.get(i) + ", ";
        }
        votosParaImp += this.votos.get(4) + "]";
        return votosParaImp;
    }
    
    @Override
    public String toString() {
        String results = "    length: " + this.distancia + "\n" + "    judge votes: " + this.printVotos();
        return results;
    }
}
