package presentationLayer;

import javax.swing.*;
import java.awt.*;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public abstract class MainFrame extends JFrame {
    public MainFrame() {
        super("WareHouse management");
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    abstract public void init() throws Exception;
}