package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public class ClientFrame extends MainFrame{
    private JButton add;
    private JButton edit;
    private JButton delete;
    private JButton view;
    private JButton back;
    public ClientFrame() {
        super();

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        add = new JButton("Add new client");
        add.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        add.setPreferredSize(new Dimension(150, 30));
        add.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        optionsPanel.add(add, gbc);

        edit = new JButton("Edit client");
        edit.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        edit.setPreferredSize(new Dimension(150, 30));
        edit.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        optionsPanel.add(edit, gbc);

        delete = new JButton("Delete client");
        delete.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        delete.setPreferredSize(new Dimension(150, 30));
        delete.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 2;
        optionsPanel.add(delete, gbc);

        view = new JButton("View all clients");
        view.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        view.setPreferredSize(new Dimension(150, 30));
        view.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 3;
        optionsPanel.add(view, gbc);

        back = new JButton("Back");
        back.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        back.setPreferredSize(new Dimension(150, 30));
        back.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 4;
        optionsPanel.add(back, gbc);

        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(optionsPanel);
        this.setVisible(false);
    }

    @Override
    public void init() {

    }

    public void addBackListener(ActionListener e){
        this.back.addActionListener(e);
    }

    public void addEditListener(ActionListener e){
        this.edit.addActionListener(e);
    }

    public void addDeleteListener(ActionListener e){
        this.delete.addActionListener(e);
    }

    public void addViewListener(ActionListener e){
        this.view.addActionListener(e);
    }

    public void addAddListener(ActionListener e){
        this.add.addActionListener(e);
    }
}
