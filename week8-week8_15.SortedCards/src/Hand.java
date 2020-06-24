
import java.util.ArrayList;
import java.util.Collections;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;
    
    public Hand(){
        this.hand = new ArrayList<Card>();
    }
    
    public void add(Card card){
        hand.add(card);
    }
    
    public void print(){
        for(Card c : this.hand){
            System.out.println(c.toString());
        }
    }
    
    public void sort(){
        Collections.sort(this.hand);
        this.print();
    }

    @Override
    public int compareTo(Hand t) {
        int value = 0, otherValue = 0;
        
        for (Card c : this.hand){
            value += c.getValue();
        }
        
        for(Card c : t.hand){
            otherValue += c.getValue();
        }
        
        return value - otherValue;
    }
    
    public void sortAgainstSuit(){
        Collections.sort(hand, new SortAgainstSuitAndValue());
    }
}
