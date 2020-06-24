
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Jumper implements Comparable<Jumper> {
    
    private String name;
    private Map<Integer, Points> points;

    Jumper(String name) {
        this.name = name;
        this.points = new HashMap<Integer, Points>();
    }
    
    public void jump(int ronda){
        this.points.put(ronda, new Points());
    }
    
    public String getName(){
        return this.name;
    }
    
    public Points getPoints(int ronda){
        return this.points.get(ronda);
    }
    
    public int getTotalPoints(){
        int total = 0;
        for(Points p : this.points.values()){
            total += p.getPoints();
        }
        return total;
    }

    public String printJumperResultsOfEachRound() {
        return this.name + " (" + this.getTotalPoints() + " points)";
    }
    
    public String imprimirDistancias(){
        String pDist = "";
        for (Points points : this.points.values()) {
            pDist += " " + points.getLength() + " m,";
        }
        pDist = pDist.substring(0, pDist.length() - 1); //Quitamos la cama después de la última m.
        return pDist;
    }

    @Override
    public int compareTo(Jumper t) {
        return this.getTotalPoints() - t.getTotalPoints();
    }
    
    @Override
    public String toString() {
        String results = "           " + this.printJumperResultsOfEachRound()+ "\n            jump lengths:" + this.imprimirDistancias();
        return results;
    }
    
}
