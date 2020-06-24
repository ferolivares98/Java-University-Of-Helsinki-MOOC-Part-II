/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author fernando
 */
public class DrawingBoard extends JPanel implements Updatable{
    
    private WormGame wormGame;
    private int pieceLength;
    
    public DrawingBoard(WormGame wormGame, int pieceLength){
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(Piece p : wormGame.getWorm().getPieces()){
            g.setColor(Color.BLACK);
            g.fill3DRect(pieceLength * p.getX(), pieceLength * p.getY(), pieceLength, pieceLength, true);
        }
        
        g.setColor(Color.RED);
        g.fillOval(pieceLength * wormGame.getApple().getX(), pieceLength * wormGame.getApple().getY(), pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
