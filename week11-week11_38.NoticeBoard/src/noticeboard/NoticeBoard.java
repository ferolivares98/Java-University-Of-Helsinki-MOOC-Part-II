package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        
        JTextField text = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel copied = new JLabel();
        
        ActionEventListener copy = new ActionEventListener(text, copied);
        button.addActionListener(copy);
        
        container.add(text);
        container.add(button);
        container.add(copied);
    }
}
