package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame{

    private JTextField polynomial1TextField;
    private JTextField polynomial2TextField;
    private JTextField resultTextField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton differentiationButton;
    private JButton integrationButton;
    private JLabel poly1;
    private JLabel poly2;

    public CalcView() {

        super("Polynomial Calculator");

        polynomial1TextField = new JTextField();
        polynomial2TextField = new JTextField();
        resultTextField = new JTextField();
        resultTextField.setEditable(false);

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        differentiationButton = new JButton("d/dx");
        integrationButton = new JButton("dx");

        poly1 = new JLabel();
        poly2 = new JLabel();

        JPanel insertPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        insertPanel.add(new JLabel("Polynomial 1:"));
        insertPanel.add(poly1);
        insertPanel.add(polynomial1TextField);
        insertPanel.add(new JLabel("Polynomial 2:"));
        insertPanel.add(poly2);
        insertPanel.add(polynomial2TextField);
        insertPanel.add(new JLabel("Result:"));
        insertPanel.add(resultTextField);

        JPanel operationPanel = new JPanel(new FlowLayout());
        operationPanel.add(addButton);
        operationPanel.add(subtractButton);
        operationPanel.add(multiplyButton);
        operationPanel.add(divideButton);
        operationPanel.add(differentiationButton);
        operationPanel.add(integrationButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(insertPanel, BorderLayout.NORTH);
        getContentPane().add(new JLabel("Operations:"), BorderLayout.CENTER);
        getContentPane().add(operationPanel, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(400, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public void init(){
        poly1.setText("");
        poly2.setText("");
    }
    public String getPolynomial1TextField(){
        return this.polynomial1TextField.getText();
    }

    public String getPolynomial2TextField(){
        return this.polynomial2TextField.getText();
    }
    public void setPolynomial1TextField(String s){
        this.polynomial1TextField.setText(s);
    }
    public void setPolynomial2TextField(String s){
        this.polynomial2TextField.setText(s);
    }

    public void addButtonListener(ActionListener e){
        addButton.addActionListener(e);
    }

    public void subButtonListener(ActionListener e){
        subtractButton.addActionListener(e);
    }

    public void mulButtonListener(ActionListener e){
        multiplyButton.addActionListener(e);
    }

    public void divButtonListener(ActionListener e){
        divideButton.addActionListener(e);
    }

    public void difButtonListener(ActionListener e){
        differentiationButton.addActionListener(e);
    }

    public void intButtonListener(ActionListener e){
        integrationButton.addActionListener(e);
    }

    public void setPoly1Text(String msg){
        poly1.setText(msg);
    }

    public void setPoly2Text(String msg){
        poly2.setText(msg);
    }

    public void setResultTextField(String result){
        resultTextField.setText(result);
    }
}
