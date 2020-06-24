/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticeboard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author fernando
 */
public class ActionEventListener implements ActionListener{
    
    private JTextField text;
    private JLabel copied;

    ActionEventListener(JTextField text, JLabel copied) {
        this.text = text;
        this.copied = copied;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        copied.setText(text.getText());
        text.setText("");
    }
    
}
