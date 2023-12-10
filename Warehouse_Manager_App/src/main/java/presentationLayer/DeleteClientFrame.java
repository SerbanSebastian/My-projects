package presentationLayer;

import businessLogic.ClientBLL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public class DeleteClientFrame extends MainFrame {
    private JComboBox<String> comboBox;
    private ClientBLL client;
    private JButton deleteButton;
    private JButton backButton;

    public DeleteClientFrame() {
        super();
        this.setLayout(new FlowLayout());

        JPanel comboPanel = new JPanel(new GridLayout(2, 1));
        JLabel label = new JLabel("Choose the client you want to delete");

        client = new ClientBLL();
        try{
            List<String> aux = new ArrayList<String>();
            aux = client.clientsToString(client.listAllClients());
            comboBox = new JComboBox<String>(aux.toArray(new String[aux.size()]));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        comboPanel.add(label);
        comboPanel.add(comboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(comboPanel);
        mainPanel.add(Box.createVerticalGlue());
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalGlue());

        JPanel containerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        containerPanel.add(mainPanel);
        this.add(containerPanel);

        this.add(mainPanel);
        this.setVisible(false);
    }

    @Override
    public void init() {
        try{
            List<String> aux = new ArrayList<String>();
            aux = client.clientsToString(client.listAllClients());
            comboBox.setModel(new DefaultComboBoxModel(aux.toArray()));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addBackListener(ActionListener e){
        this.backButton.addActionListener(e);
    }

    public JComboBox getComboBox(){
        return this.comboBox;
    }

    public void addDeleteListener(ActionListener e){
        this.deleteButton.addActionListener(e);
    }
}
