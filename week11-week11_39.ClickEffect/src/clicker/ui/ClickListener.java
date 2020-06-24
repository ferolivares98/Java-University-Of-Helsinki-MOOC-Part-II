/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author fernando
 */
public class ClickListener implements ActionListener{
    
    private Calculator calc;
    private JLabel counter;
    
    public ClickListener(Calculator calc, JLabel counter){
        this.calc = calc;
        this.counter = counter;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        calc.increase();
        counter.setText("" + calc.giveValue());
    }
    
}
