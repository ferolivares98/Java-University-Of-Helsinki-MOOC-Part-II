
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JTextField showResult = new JTextField("0");
        showResult.setEnabled(false);
        JTextField writer = new JTextField();
        
        container.add(showResult);
        container.add(writer);
        container.add(CreatePanel(showResult, writer), BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel CreatePanel(JTextField showResult, JTextField writer) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton reset = new JButton("Z");
        reset.setEnabled(false);
        JButton add = new JButton("+");
        JButton substract = new JButton("-");
        reset.addActionListener(new ResetClickListener(showResult, writer, reset));
        add.addActionListener(new AddClickListener(showResult, writer, add, reset));
        substract.addActionListener(new SubstractClickListener(showResult, writer, substract, reset));

        panel.add(add);
        panel.add(substract);
        panel.add(reset);
        
        return panel;
    }
}
