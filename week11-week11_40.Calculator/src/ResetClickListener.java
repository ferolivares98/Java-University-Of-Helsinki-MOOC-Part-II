
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class ResetClickListener implements ActionListener {
    
    private JTextField output;
    private JTextField input;
    private JButton reset;

    public ResetClickListener(JTextField showResult, JTextField writer, JButton reset) {
        this.output = showResult;
        this.input = writer;
        this.reset = reset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        output.setText("0");
        input.setText("");
        reset.setEnabled(false);
    }
    
}
