/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class CompoundFigure extends Figure{
    
    private ArrayList<Figure> list;
    
    public CompoundFigure(){
        this.list = new ArrayList<Figure>();
    }
    
    public void add(Figure f){
        list.add(f);
    }

    @Override
    public void draw(Graphics graphics) {
        for(Figure f: list){
            f.draw(graphics);
        }
    }
    
    @Override
    public void move(int dx, int dy){
        for(Figure f : list){
            f.move(dx, dy);
        }
    }
    
}
