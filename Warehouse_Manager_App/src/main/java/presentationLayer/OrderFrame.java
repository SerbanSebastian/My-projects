package presentationLayer;

import model.*;
import businessLogic.*;

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
public class OrderFrame extends MainFrame{
    private ClientBLL client;
    private ProductBLL product;
    private JComboBox<String> orderClientId;
    private JComboBox<String> orderProductId;
    private JTextField orderQuantity;
    private JTextField orderTotal;
    private JLabel lblQuantity;
    private JLabel lblTotal;
    private JLabel msgClientId;
    private JLabel msgProductId;
    private JLabel msgQuantity;
    private JLabel msgTotal;
    private JButton order;
    private JButton back;
    public OrderFrame() {
        super();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblClientId = new JLabel("Client ID:");
        JLabel lblProductId = new JLabel("Product ID:");
        lblQuantity = new JLabel("Quantity:");
        lblTotal = new JLabel("Total:");

        client = new ClientBLL();
        product = new ProductBLL();
        try {
            List<String> aux = new ArrayList<String>();
            aux = client.idsToString(client.listAllClients());
            orderClientId = new JComboBox(aux.toArray(new String[aux.size()]));
            aux = product.idsToString(product.listAllProducts());
            orderProductId = new JComboBox(aux.toArray(new String[aux.size()]));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        orderQuantity = new JTextField(50);
        orderQuantity.setSize(new Dimension(100, 20));
        orderTotal = new JTextField(50);
        orderTotal.setEditable(false);

        msgClientId = new JLabel("");
        msgProductId = new JLabel("");
        msgQuantity = new JLabel("");
        msgTotal = new JLabel("");

        order = new JButton("Finish order");
        order.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        back = new JButton("Back");
        back.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        lblClientId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        lblProductId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        lblQuantity.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        lblTotal.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        msgClientId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgProductId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgQuantity.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgQuantity.setForeground(Color.RED);
        msgTotal.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(lblClientId, gbc);
        gbc.gridy = 1;
        contentPanel.add(orderClientId, gbc);
        gbc.gridy = 2;
        contentPanel.add(msgClientId, gbc);
        gbc.gridy = 3;
        contentPanel.add(lblProductId, gbc);
        gbc.gridy = 4;
        contentPanel.add(orderProductId, gbc);
        gbc.gridy = 5;
        contentPanel.add(msgProductId, gbc);
        gbc.gridy = 6;
        contentPanel.add(lblQuantity, gbc);
        gbc.gridy = 7;
        contentPanel.add(orderQuantity, gbc);
        gbc.gridy = 8;
        contentPanel.add(msgQuantity, gbc);
        gbc.gridy = 9;
        contentPanel.add(lblTotal, gbc);
        gbc.gridy = 10;
        contentPanel.add(orderTotal, gbc);
        gbc.gridy = 11;
        contentPanel.add(msgTotal, gbc);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonsPanel.add(order);
        buttonsPanel.add(back);

        gbc.gridy = 12;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(buttonsPanel, gbc);

        this.add(contentPanel);
        this.setVisible(false);
    }

    @Override
    public void init() {
        orderQuantity.setText("");
        msgTotal.setText("");
        initLabel();

        try {
            List<String> aux = new ArrayList<String>();
            aux = client.idsToString(client.listAllClients());
            orderClientId.setModel(new DefaultComboBoxModel(aux.toArray()));
            aux = product.idsToString(product.listAllProducts());
            orderProductId.setModel(new DefaultComboBoxModel(aux.toArray()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void initLabel(){
        msgQuantity.setText("");
    }

    public void addBackListener(ActionListener e){
        this.back.addActionListener(e);
    }

    public void addEnterListener(ActionListener e){
        this.order.addActionListener(e);
    }

    public String getQuantity(){
        return this.orderQuantity.getText();
    }

    public void setQuantity(String message){
        this.msgQuantity.setText(message);
    }

    public JComboBox getProductId(){
        return orderProductId;
    }

    public JComboBox getClientId(){
        return orderClientId;
    }
}
