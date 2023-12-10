package GUI;

import javax.swing.*;
import java.awt.*;


public class SimulationFrame extends JFrame{
    JTextField numOfClientsField;
    JTextField numOfQueuesField;
    JTextField simulationTimeField;
    JTextField minArrivalTimeField;
    JTextField maxArrivalTimeField;
    JTextField minServiceTimeField;
    JTextField maxServiceTimeField;
    JButton startSimulationButton;
    JTextArea outputTextArea;

    public SimulationFrame() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        this.setSize(new Dimension(640, 480));

        JPanel textFieldPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        textFieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        numOfClientsField = new JTextField();
        numOfQueuesField = new JTextField();
        simulationTimeField = new JTextField();
        minArrivalTimeField = new JTextField();
        maxArrivalTimeField = new JTextField();
        minServiceTimeField = new JTextField();
        maxServiceTimeField = new JTextField();

        textFieldPanel.add(new JLabel("Number of Clients:"));
        textFieldPanel.add(numOfClientsField);
        textFieldPanel.add(new JLabel("Number of Queues:"));
        textFieldPanel.add(numOfQueuesField);
        textFieldPanel.add(new JLabel("Simulation Time:"));
        textFieldPanel.add(simulationTimeField);
        textFieldPanel.add(new JLabel("Minimum Arrival Time:"));
        textFieldPanel.add(minArrivalTimeField);
        textFieldPanel.add(new JLabel("Maximum Arrival Time:"));
        textFieldPanel.add(maxArrivalTimeField);
        textFieldPanel.add(new JLabel("Minimum Service Time:"));
        textFieldPanel.add(minServiceTimeField);
        textFieldPanel.add(new JLabel("Maximum Service Time:"));
        textFieldPanel.add(maxServiceTimeField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        startSimulationButton = new JButton("Start Simulation");
        buttonPanel.add(startSimulationButton);

        outputTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(5, 5, 100, 100);

        mainPanel.add(textFieldPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        this.getContentPane().add(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addText(String s){
        this.outputTextArea.append(s);
    }

    public String getText(){
        return this.outputTextArea.getText();
    }

    public void setText(String s){
        this.outputTextArea.setText(s);
    }

    public Integer getNumOfClients(){
        return Integer.valueOf(numOfClientsField.getText());
    }

    public Integer getNumOfQueues(){
        return Integer.valueOf(numOfQueuesField.getText());
    }

    public Integer getSimulationTime(){
        return Integer.valueOf(simulationTimeField.getText());
    }

    public Integer getMinArrivalTime(){
        return Integer.valueOf(minArrivalTimeField.getText());
    }

    public Integer getMaxArrivalTime(){
        return Integer.valueOf(maxArrivalTimeField.getText());
    }

    public Integer getMinServiceTime(){
        return Integer.valueOf(minServiceTimeField.getText());
    }

    public Integer getMaxServiceTime(){
        return Integer.valueOf(maxServiceTimeField.getText());
    }

    public JButton getStartSimulationButton(){
        return this.startSimulationButton;
    }
}
