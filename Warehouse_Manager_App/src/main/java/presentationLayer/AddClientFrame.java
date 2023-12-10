package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a GUI class</p>
 */
public class AddClientFrame extends MainFrame{

    private JTextField tfId;
    private JTextField tfName;
    private JTextField tfEmail;
    private JTextField tfPhoneNr;
    private JTextField tfAddress;
    private JLabel msgId;
    private JLabel msgName;
    private JLabel msgEmail;
    private JLabel msgPhoneNr;
    private JLabel msgAddress;

    private JButton add;
    private JButton back;

    public AddClientFrame() {
        super();

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        tfId = new JTextField(50);
        tfName = new JTextField(50);
        tfEmail = new JTextField(50);
        tfPhoneNr = new JTextField(50);
        tfAddress = new JTextField(50);

        msgId = new JLabel("");
        msgId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgId.setForeground(Color.RED);
        msgName = new JLabel("");
        msgName.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgName.setForeground(Color.RED);
        msgEmail = new JLabel("");
        msgEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgEmail.setForeground(Color.RED);
        msgPhoneNr = new JLabel("");
        msgPhoneNr.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgPhoneNr.setForeground(Color.RED);
        msgAddress = new JLabel("");
        msgAddress.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        msgAddress.setForeground(Color.RED);

        JLabel lbId = new JLabel("ID:");
        lbId.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbName = new JLabel("Name:");
        lbName.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbEmail = new JLabel("E-mail:");
        lbEmail.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbPhoneNr = new JLabel("Phone Number:");
        lbPhoneNr.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        JLabel lbAddress = new JLabel("Address:");
        lbAddress.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lbId, gbc);

        gbc.gridy = 1;
        panel.add(tfId, gbc);

        gbc.gridy = 2;
        panel.add(msgId, gbc);

        gbc.gridy = 3;
        panel.add(lbName, gbc);

        gbc.gridy = 4;
        panel.add(tfName, gbc);

        gbc.gridy = 5;
        panel.add(msgName, gbc);

        gbc.gridy = 6;
        panel.add(lbEmail, gbc);

        gbc.gridy = 7;
        panel.add(tfEmail, gbc);

        gbc.gridy = 8;
        panel.add(msgEmail, gbc);

        gbc.gridy = 9;
        panel.add(lbPhoneNr, gbc);

        gbc.gridy = 10;
        panel.add(tfPhoneNr, gbc);

        gbc.gridy = 11;
        panel.add(msgPhoneNr, gbc);

        gbc.gridy = 12;
        panel.add(lbAddress, gbc);

        gbc.gridy = 13;
        panel.add(tfAddress, gbc);

        gbc.gridy = 14;
        panel.add(msgAddress, gbc);

        gbc.gridy = 15;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(Box.createVerticalGlue(), gbc);

        this.add(panel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        add = new JButton("Enter");
        add.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        back = new JButton("Back");
        back.setFont(new Font("Bahnschrift", Font.PLAIN, 12));

        buttonPanel.add(add);
        buttonPanel.add(back);

        gbc.gridy = 16;
        gbc.insets = new Insets(10, 0, 10, 0);
        this.add(buttonPanel, gbc);

        this.setVisible(false);
    }

    @Override
    public void init() {
        msgId.setText("");
        msgName.setText("");
        msgEmail.setText("");
        msgPhoneNr.setText("");
        msgAddress.setText("");

        tfId.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfPhoneNr.setText("");
        tfAddress.setText("");
    }

    public void initLabels(){
        msgId.setText("");
        msgName.setText("");
        msgEmail.setText("");
        msgPhoneNr.setText("");
        msgAddress.setText("");
    }

    public void addEnterListener(ActionListener e){
        this.add.addActionListener(e);
    }

    public void addBackListener(ActionListener e){
        this.back.addActionListener(e);
    }

    public void setMsgId(String msg){
        this.msgId.setText(msg);
    }
    public String getMsgId(){
        return msgId.getText();
    }

    public String getTfId() {
        return tfId.getText();
    }

    public void setTfId(String tfId) {
        this.tfId.setText(tfId);
    }

    public String getTfName() {
        return tfName.getText();
    }

    public void setTfName(String tfName) {
        this.tfName.setText(tfName);
    }

    public String getTfEmail() {
        return tfEmail.getText();
    }

    public void setTfEmail(String tfEmail) {
        this.tfEmail.setText(tfEmail);
    }

    public String getTfPhoneNr() {
        return tfPhoneNr.getText();
    }

    public void setTfPhoneNr(String tfPhoneNr) {
        this.tfPhoneNr.setText(tfPhoneNr);
    }

    public String getTfAddress() {
        return tfAddress.getText();
    }

    public void setTfAddress(String tfAddress) {
        this.tfAddress.setText(tfAddress);
    }

    public String getMsgName() {
        return msgName.getText();
    }

    public void setMsgName(String msgName) {
        this.msgName.setText(msgName);
    }

    public String getMsgEmail() {
        return msgEmail.getText();
    }

    public void setMsgEmail(String msgEmail) {
        this.msgEmail.setText(msgEmail);
    }

    public String getMsgPhoneNr() {
        return msgPhoneNr.getText();
    }

    public void setMsgPhoneNr(String msgPhoneNr) {
        this.msgPhoneNr.setText(msgPhoneNr);
    }

    public String getMsgAddress() {
        return msgAddress.getText();
    }

    public void setMsgAddress(String msgAddress) {
        this.msgAddress.setText(msgAddress);
    }
}
