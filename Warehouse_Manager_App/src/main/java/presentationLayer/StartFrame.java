package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public class StartFrame extends MainFrame{
    private JTextField message;
    private JTextField operations;
    private JButton client;
    private JButton product;
    private JButton order;

    public StartFrame() {
        super();

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel welcomeLabel = new JLabel("Welcome to our WareHouse");
        welcomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        contentPanel.add(welcomeLabel, gbc);

        JLabel operationLabel = new JLabel("Choose your operation");
        operationLabel.setFont(new Font("Helvetica", Font.PLAIN, 14));
        gbc.gridy = 1;
        contentPanel.add(operationLabel, gbc);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());

        client = new JButton("Client");
        client.setFont(new Font("Helvetica", Font.PLAIN, 12));
        client.setPreferredSize(new Dimension(100, 30));
        gbc.gridy = 0;
        gbc.gridx = 0;
        buttonsPanel.add(client, gbc);

        product = new JButton("Product");
        product.setFont(new Font("Helvetica", Font.PLAIN, 12));
        product.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 1;
        buttonsPanel.add(product, gbc);

        order = new JButton("Order");
        order.setFont(new Font("Helvetica", Font.PLAIN, 12));
        order.setPreferredSize(new Dimension(100, 30));
        gbc.gridx = 2;
        buttonsPanel.add(order, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        contentPanel.add(buttonsPanel, gbc);

        this.getContentPane().add(contentPanel);
        this.setVisible(true);
    }

    @Override
    public void init() {

    }

    public void addClientListener(ActionListener e){
        this.client.addActionListener(e);
    }

    public void addProductListener(ActionListener e){
        this.product.addActionListener(e);
    }

    public void addOrderListener(ActionListener e){
        this.order.addActionListener(e);
    }
}
