package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public class AddProductFrame extends MainFrame{
    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfPrice;
    private JTextField tfQuantity;
    private JLabel msgId;
    private JLabel msgName;
    private JLabel msgPrice;
    private JLabel msgQuantity;


    private JButton add;
    private JButton back;
    public AddProductFrame(){
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0);

        tfId = new JTextField(50);
        tfName = new JTextField(50);
        tfPrice = new JTextField(50);
        tfQuantity = new JTextField(50);

        msgId = new JLabel("");
        msgId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgId.setForeground(Color.RED);
        msgName = new JLabel("");
        msgName.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgName.setForeground(Color.RED);
        msgPrice = new JLabel("");
        msgPrice.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgPrice.setForeground(Color.RED);
        msgQuantity = new JLabel("");
        msgQuantity.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgQuantity.setForeground(Color.RED);

        JLabel lbId = new JLabel("ID:");
        lbId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbName = new JLabel("Name:");
        lbName.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbPrice = new JLabel("Price:");
        lbPrice.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbQuantity = new JLabel("Quantity:");
        lbQuantity.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(lbId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(tfId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(msgId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(lbName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(tfName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(msgName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(lbPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(tfPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(msgPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(lbQuantity, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(tfQuantity, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.anchor = GridBagConstraints.LINE_START;
        panel.add(msgQuantity, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        this.add(panel, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        add = new JButton("Enter");
        add.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        back = new JButton("Back");
        back.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        buttonPanel.add(add);
        buttonPanel.add(back);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(buttonPanel, gbc);

        this.setVisible(false);
    }

    @Override
    public void init() {
        msgId.setText("");
        msgName.setText("");
        msgPrice.setText("");
        msgQuantity.setText("");

        tfId.setText("");
        tfName.setText("");
        tfPrice.setText("");
        tfQuantity.setText("");
    }

    public void initLabels(){
        msgId.setText("");
        msgName.setText("");
        msgPrice.setText("");
        msgQuantity.setText("");
    }

    public void addEnterListener(ActionListener e){
        this.add.addActionListener(e);
    }

    public void addBackListener(ActionListener e){
        this.back.addActionListener(e);
    }

    public String getTfId() {
        return tfId.getText();
    }

    public String getTfName() {
        return tfName.getText();
    }

    public String getTfPrice() {
        return tfPrice.getText();
    }

    public String getTfQuantity() {
        return tfQuantity.getText();
    }

    public void setMsgId(String msgId) {
        this.msgId.setText(msgId);
    }

    public void setMsgName(String msgName) {
        this.msgName.setText(msgName);
    }

    public void setMsgPrice(String msgPrice) {
        this.msgPrice.setText(msgPrice);
    }

    public void setMsgQuantity(String msgQuantity) {
        this.msgQuantity.setText(msgQuantity);
    }
}
