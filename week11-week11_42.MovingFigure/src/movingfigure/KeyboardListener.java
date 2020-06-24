/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author fernando
 */
public class KeyboardListener implements KeyListener{
    
    private Component component;
    private Figure figure;
    
    public KeyboardListener(Component component, Figure figure){
        this.component = component;
        this.figure = figure;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            figure.move(-1, 0);
        } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            figure.move(1, 0);
        }else if (ke.getKeyCode() == KeyEvent.VK_UP) {
            figure.move(0, -1);
        } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            figure.move(0, 1);
        }
        
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
