/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author fernando
 */
public class PersonalBoard extends GameOfLifeBoard{

    public PersonalBoard(int length, int height) {
        super(length, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        for(int i = 0; i < super.getWidth(); i++){
            for(int j = 0; j < super.getHeight(); j++){
                if(new Random().nextDouble() < d){
                    turnToLiving(i, j);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if(inBoard(i, i1)){
            return super.getBoard()[i][i1];
        }
        return false;
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if (inBoard(i, i1)) {
            super.getBoard()[i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1) {
        if (inBoard(i, i1)) {
            super.getBoard()[i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int nADev = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int j = i1 - 1; j <= i1 + 1; j++) {
                if (isAlive(k, j)) {
                    nADev++;
                }
            }
        }

        if (isAlive(i, i1)) {
            nADev--; //Nos quitamos a nostros mismos porque nos hemos sumado (tal vez).
        }

        return nADev;
    }

    @Override
    public void manageCell(int i, int i1, int livingNeighbours) { //Aparecía de variable i2 y no se entiende nada........
        if(livingNeighbours < 2 || livingNeighbours > 3){
            turnToDead(i, i1);
        }else if(livingNeighbours == 3){
            turnToLiving(i, i1);
        }
    } 
    
    public boolean inBoard(int x, int y) {
        if (x < 0 || y < 0 || x >= super.getWidth() || y >= super.getHeight()) { 
            return false;
        }
        return true;
    }
}
