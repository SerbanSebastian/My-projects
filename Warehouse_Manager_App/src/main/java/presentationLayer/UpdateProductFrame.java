package presentationLayer;

import businessLogic.ProductBLL;

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
public class UpdateProductFrame extends MainFrame{
    private JComboBox<String> productBox;
    private ProductBLL product;
    private JTextField[] currentFields;
    private JTextField[] newFields;
    private JButton backButton;
    private JButton updateButton;
    private JLabel[] labels;

    private String[] fieldLabels = {
            "name", "price", "quantity"
    };

    public UpdateProductFrame() {
        super();
        this.setLayout(new GridBagLayout());

        JPanel productPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel productLabel = new JLabel("Product:");

        product = new ProductBLL();
        try{
            List<String> aux = new ArrayList<String>();
            aux = product.productsToString(product.listAllProducts());
            productBox = new JComboBox<String>(aux.toArray(new String[aux.size()]));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        productPanel.add(productLabel);
        productPanel.add(productBox);

        JPanel fieldsPanel = new JPanel(new GridLayout(fieldLabels.length * 4, 2));
        fieldsPanel.setPreferredSize(new Dimension(400, 300));

        currentFields = new JTextField[fieldLabels.length];
        newFields = new JTextField[fieldLabels.length];
        labels = new JLabel[fieldLabels.length];

        for (int i = 0; i < fieldLabels.length; i++) {
            JLabel currentLabel = new JLabel("Current " + fieldLabels[i] + ":");
            currentFields[i] = new JTextField();
            currentFields[i].setEditable(false);
            JLabel newLabel = new JLabel("New " + fieldLabels[i] + ":");
            newFields[i] = new JTextField();
            labels[i] = new JLabel();
            labels[i].setFont(new Font("Helvetica", Font.PLAIN, 12));
            labels[i].setForeground(Color.RED);

            fieldsPanel.add(currentLabel);
            fieldsPanel.add(newLabel);
            fieldsPanel.add(currentFields[i]);
            fieldsPanel.add(newFields[i]);
            fieldsPanel.add(new JLabel());
            fieldsPanel.add(labels[i]);
        }

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updateButton = new JButton("Update");
        backButton = new JButton("Back");
        buttonPanel.add(updateButton);
        buttonPanel.add(backButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(productPanel, gbc);

        gbc.gridy = 1;
        this.add(fieldsPanel, gbc);

        gbc.gridy = 2;
        this.add(buttonPanel, gbc);
        this.setVisible(false);
    }

    @Override
    public void init() {
        for(int i = 0; i < fieldLabels.length; i++){
            currentFields[i].setText("");
            newFields[i].setText("");
            labels[i].setText("");
        }

        try{
            List<String> aux = new ArrayList<String>();
            aux = product.productsToString(product.listAllProducts());
            productBox.setModel(new DefaultComboBoxModel(aux.toArray()));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void initLabels(){
        for(int i = 0; i < fieldLabels.length; i++){
            labels[i].setText("");
        }
    }

    public void addBackListener(ActionListener e){
        this.backButton.addActionListener(e);
    }

    public void addUpdateListener(ActionListener e){
        this.updateButton.addActionListener(e);
    }
    public void addComboListener(ActionListener e){
        this.productBox.addActionListener(e);
    }
    public String getInfo(int position){
        return newFields[position].getText();
    }

    public void setInfo(int position, String message){
        labels[position].setText(message);
    }

    public void setOldInfo(int position, String message){
        currentFields[position].setText(message);
    }

    public JComboBox getProductBox(){
        return productBox;
    }
}
