import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class aplicatie {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(480, 640);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("0");

        panel.add(label);
        frame.add(panel);
        frame.addKeyListener(new BtnListener(label));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
