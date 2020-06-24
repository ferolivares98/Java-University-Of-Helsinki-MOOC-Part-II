/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author fernando
 */
public class Worm {
    
    private int x;
    private int y;
    private Direction dir;
    private ArrayList<Piece> worm;
    private boolean growFlag;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.dir = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(this.x, this.y));
        this.growFlag = true;
    }
    
    public Direction getDirection(){
        return this.dir;
    }
    
    public void setDirection(Direction dir){
        this.dir = dir;
    }
    
    public int getLength(){
        return this.worm.size();
    }
    
    public List<Piece> getPieces(){
        return this.worm;
    }
    
    public void move(){
        if(this.worm.size() < 3){
            this.grow();
        }
        int newX = worm.get(worm.size() - 1).getX();
        int newY = worm.get(worm.size() - 1).getY();
        
        if(dir == Direction.UP){
            newY--;
        }else if(dir == Direction.DOWN){
            newY++;
        }else if(dir == Direction.LEFT){
            newX--;
        }else if(dir == Direction.RIGHT){
            newX++;
        }
        
        if (getLength() > 2 && !growFlag) worm.remove(0);
        if (growFlag) growFlag = false;
        
        worm.add(new Piece(newX, newY));
    }
    
    public void grow(){
        this.growFlag = true;
    }
    
    public boolean runsInto(Piece piece){
        for(Piece p : worm){ //Con la cabeza.
            if(p.getX() == piece.getX() && p.getY() == piece.getY()){
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself(){
        for (int i = 0; i < getLength() - 1; i++) { //Sin la cabeza.
            if (head().getX() == worm.get(i).getX() && head().getY() == worm.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
    
    public Piece head() {
        return worm.get(getLength() - 1);
    }
}
