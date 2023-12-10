import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BtnListener implements KeyListener {
    private JLabel label;
    public BtnListener(JLabel label){
        this.label = label;

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            label.setText(String.valueOf(Integer.parseInt(label.getText()) + 1));
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            label.setText(String.valueOf(Integer.parseInt(label.getText()) - 1));
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}