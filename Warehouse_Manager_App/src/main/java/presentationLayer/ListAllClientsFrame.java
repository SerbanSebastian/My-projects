package presentationLayer;

import businessLogic.ClientBLL;
import businessLogic.CreateTable;
import model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public class ListAllClientsFrame extends MainFrame{

    private JTable table;
    private JButton backButton;
    private CreateTable<Client> tbl;
    private ClientBLL bll;

    public ListAllClientsFrame() throws Exception {
        super();

        tbl = new CreateTable<Client>();
        bll = new ClientBLL();
        String[] columnNames = tbl.getFields(new Client()).toArray(new String[tbl.getFields(new Client()).size()]);
        Object[][] data = tbl.populateTable(bll.listAllClients());
        table = new JTable(data, columnNames);

        backButton = new JButton("Back");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(new JScrollPane(table));
        panel.add(backButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(new JLabel(), gbc);
        gbc.gridy++;
        panel.add(new JLabel(), gbc);
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel(), gbc);

        this.add(panel);
        this.setVisible(false);
    }
    @Override
    public void init() throws Exception {
        String[] columnNames = tbl.getFields(new Client()).toArray(new String[tbl.getFields(new Client()).size()]);
        Object[][] data = tbl.populateTable(bll.listAllClients());
        table.setModel(new DefaultTableModel(data, columnNames));
    }

    public void addBackListener(ActionListener e){
        this.backButton.addActionListener(e);
    }
}
