
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
public class SubstractClickListener implements ActionListener {

    private JTextField output;
    private JTextField input;
    private JButton add;
    private JButton reset;

    public SubstractClickListener(JTextField showResult, JTextField writer, JButton add, JButton reset) {
        this.output = showResult;
        this.input = writer;
        this.add = add;
        this.reset = reset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(isInteger()){
            int entrada = Integer.parseInt(input.getText());
            int salida = Integer.parseInt(output.getText());
            
            salida -= entrada;
            
            output.setText(""+salida);
            input.setText("");
            if(salida != 0){
                reset.setEnabled(true);
            }else{
                reset.setEnabled(false);
            }
        }else{
            input.setText("");
        }
    }
    
    public boolean isInteger(){
        try{
            Integer.parseInt(input.getText());
        }catch (NumberFormatException num){
            return false;
        }
        return true;
    }
    
}
