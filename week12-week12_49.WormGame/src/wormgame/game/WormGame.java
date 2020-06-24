package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        
        while(apple.getX() == 3 && apple.getY() == 3){
            this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        }

        addActionListener(this);
        setInitialDelay(2000);      
    }
    
    public Worm getWorm(){
        return this.worm;
    }
    
    public void setWorm(Worm worm){
        this.worm = worm;
    }

    public Apple getApple(){
        return this.apple;
    }
    
    public void setApple(Apple apple){
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        worm.move();

        if(worm.runsInto(apple)){
            worm.grow();
            while(worm.runsInto(apple)){ //Por si aparece en un sitio en el que ya está el gusano.
                apple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
            }
        }else if(worm.runsIntoItself()){
            this.continues = false;
        }else if(worm.head().getX() == this.width || worm.head().getX() < 0){
            this.continues = false;
        }else if(worm.head().getY() == this.height || worm.head().getY() < 0){
            this.continues = false;
        }

        this.updatable.update();
        setDelay(1000 / worm.getLength());
    }

}
