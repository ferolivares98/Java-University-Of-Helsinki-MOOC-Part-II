/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fernando
 */
public class Dungeon {
    
    private Random random = new Random();
    private Scanner reader = new Scanner(System.in);
    private List<Vampire> vampireList;
    private Player player;
    
    private int length, height, numberOfVampires, numberOfMoves;
    private boolean vampiresMove;
    
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.length = length;
        this.height = height;
        this.numberOfVampires = vampires;
        this.numberOfMoves = moves;
        this.vampiresMove = vampiresMove;
        
        this.vampireList = new ArrayList<Vampire>();
        
        int coordX, coordY;
        for(int i = 0; i < numberOfVampires; i++){
            do{
                coordX = random.nextInt(this.length);
                coordY = random.nextInt(this.height);
            }while(!posicionValida(coordX, coordY));
            this.vampireList.add(new Vampire(coordX, coordY));
        }
        this.player = new Player();
    }
    
    public void run(){
        
        List<Vampire> toBeRemovedByRandomHit = new ArrayList<Vampire>();
        
        while(this.numberOfMoves > 0){
            System.out.println(this.numberOfMoves + "\n");
            
            System.out.println(player);
            for(Vampire v : vampireList){
                System.out.println(v);
            }
            
            printGrid();
            String sequence = reader.nextLine();
            movementPlayer(sequence);
            
            if(this.vampiresMove){
                toBeRemovedByRandomHit = movementRandomVampire(sequence.length());
            }
            vampireList.removeAll(toBeRemovedByRandomHit);
            
            if(vampireList.isEmpty()){
                System.out.println("YOU WIN");
                return;
            }
        }
        
        if(vampireList.size() > 0){
            System.out.println("YOU LOSE");
        }
    }
    
    
    
    public void printGrid(){
        boolean flag = true;
        
        System.out.println("");
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < height; j++){
                if(player.getX() == i && player.getY() == j){
                    System.out.print("@");
                }else{
                    for(Vampire v : vampireList){
                        if(v.getX() == i && v.getY() == j){
                            System.out.print("v");
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.print(".");
                    }
                    flag = true;
                }
            }
            System.out.println("");
        }
    }
    
    public void movementPlayer(String sequence){
        numberOfMoves--;
        for(int i = 0; i < sequence.length(); i++){
            char c = sequence.charAt(i);
            
            switch (c){
                case 'w':
                    if(player.getY() - 1 < 0){
                        break;
                    }
                    playerTryToKillVampire(player.getX(), player.getY() - 1);
                    player.setY(player.getY() - 1);
                    break;
                    
                case 'a':
                    if(player.getX() - 1 < 0){
                        break;
                    }
                    playerTryToKillVampire(player.getX() - 1, player.getY());
                    player.setX(player.getX() - 1);
                    break;
                    
                case 's':
                    if(player.getY() + 1 == this.height){
                        break;
                    }
                    playerTryToKillVampire(player.getX(), player.getY() + 1);
                    player.setY(player.getY() + 1);
                    break;
                    
                case 'd':
                    if(player.getX() + 1 == this.length){
                        break;
                    }
                    playerTryToKillVampire(player.getX() + 1, player.getY());
                    player.setX(player.getX() + 1);
                    break;
                    
                default: ;
            }
            
            if(numberOfMoves == 0){
                break;
            }                    
        }
    }
    
    public ArrayList<Vampire> movementRandomVampire(int numberOfMovesToMake){
        
        ArrayList<Vampire> TBR = new ArrayList<Vampire>();
        
        for(Vampire v : vampireList){
            for(int i = 0; i < numberOfMovesToMake; i++){
                int r = random.nextInt(4);

                switch(r){
                    case 0:
                        if(v.getX()-1 == player.getX() && v.getY() == player.getY()){
                            TBR.add(v);
                            break;
                        }
                        if(posicionValida(v.getX()-1, v.getY())){
                            v.setX(v.getX() - 1);
                        }
                        break;
                        
                    case 1:
                        if(v.getX()+1 == player.getX() && v.getY() == player.getY()){
                            TBR.add(v);
                            break;
                        }
                        if(posicionValida(v.getX()+1, v.getY())){
                            v.setX(v.getX() + 1);
                        }
                        break;
                        
                    case 2:
                        if(v.getX() == player.getX() && v.getY()-1 == player.getY()){
                            TBR.add(v);
                            break;
                        }
                        if(posicionValida(v.getX(), v.getY()-1)){
                            v.setY(v.getY() - 1);
                        }
                        break;
                        
                    case 3:
                        if(v.getX() == player.getX() && v.getY()+1 == player.getY()){
                            TBR.add(v);
                            break;
                        }
                        if(posicionValida(v.getX(), v.getY()+1)){
                            v.setY(v.getY() + 1);
                        }
                        break;
                        
                    default: ;
                }
            }
        }
        
        return TBR;
    }
    
    public boolean posicionValida(int coordX, int coordY){
        if(coordX <= 0 || coordX == this.length || coordY <= 0 || coordY == this.height){
            return false;
        }
        for(Vampire v : vampireList){
            if(v.getX() == coordX && v.getY() == coordY){
                return false;
            }
        }
        
        return true;
    }
    
    public void playerTryToKillVampire(int coordX, int coordY){
        
        List<Vampire> toBeRemoved = new ArrayList<Vampire>();
        
        for(Vampire v : vampireList){
            if(coordX == v.getX() && coordY == v.getY()){ //Solo para los vampiros.
                toBeRemoved.add(v);
                break;
            }
        }
        vampireList.removeAll(toBeRemoved);
    }


}
