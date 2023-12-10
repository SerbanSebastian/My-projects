package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import presentationLayer.MainFrame;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the SwapFrame Button</p>
 */
public class SwapFrameButton implements ActionListener {
    private MainFrame prevFrame;
    private MainFrame nextFrame;

    public SwapFrameButton(MainFrame prevFrame, MainFrame nextFrame){
        this.prevFrame = prevFrame;
        this.nextFrame = nextFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            nextFrame.init();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        prevFrame.setVisible(false);
        nextFrame.setVisible(true);
    }
}
