package BLL;

import GUI.SimulationFrame;
import Model.Client;
import Model.Server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimManager implements Runnable{
    private static Integer clientId = 1;
    private SimulationFrame frame;
    private Scheduler scheduler;
    private List<Client> clients;
    private double averageWaitingTime;
    public SimManager(SimulationFrame frame){
        this.frame = frame;

        if(frame.getNumOfClients().equals("") || frame.getNumOfQueues().equals("") || frame.getSimulationTime().equals("") || frame.getMinArrivalTime().equals("") || frame.getMaxArrivalTime().equals("") || frame.getMinServiceTime().equals("") || frame.getMaxServiceTime().equals("")){
            frame.addText("Invalid input");
        }else {
            this.scheduler = new Scheduler(frame.getNumOfClients(), frame.getNumOfQueues());
            generate();
            computeAverageWaitingTime();
        }
    }

    public void run(){
        int currentTime = 0;
        int peakHour = 0;
        int peakClients = 0;
        int auxClients;
        List<Client> aux = new ArrayList<>();
        while(currentTime < frame.getSimulationTime()){
            for(Client client : clients){
                if(client.getArrivalTime() == currentTime){
                    scheduler.addNextClient(client);
                    aux.add(client);
                }
            }
            for(Client client : aux){
                clients.remove(client);
            }
            auxClients = 0;
            for(Server server : scheduler.getServers()){
                auxClients += server.getActualSize();
            }
            if(auxClients > peakClients) {
                peakHour = currentTime;
                peakClients = auxClients;
            }
            aux.clear();
            frame.addText("Time " + currentTime + "\n");
            frame.addText("Waiting Clients: ");
            for(Client client : clients){
                frame.addText(client.toString() + "; ");
            }
            frame.addText("\n");
            for(Server server : scheduler.getServers()){
                frame.addText("Queue " + server.getServerNumber() + ": ");
                for(Client client : server.getClients()){
                    frame.addText(client.toString() + "; ");
                }
                if(server.getClients().isEmpty()){
                    frame.addText("closed");
                }
                frame.addText("\n");
            }
            currentTime++;
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        frame.addText("Average waiting time: " + averageWaitingTime + "\n");
        frame.addText("Average service time: " + averageWaitingTime + "\n");
        frame.addText("Peak hour: " + peakHour);
        try {
            FileWriter file = new FileWriter("F:\\Facultate\\TP\\PT2023_30223_Serban_Sebastian_Assignment_2\\log.txt");
            file.write(frame.getText());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generate(){
        Random random = new Random();
        Client client;
        clients = Collections.synchronizedList(new ArrayList<>());
        Integer ta, ts;

        for(Integer i = 0; frame.getNumOfClients().compareTo(i) > 0; i++){
            while(true){
                ta = random.nextInt(frame.getMaxArrivalTime() + 1);
                if(ta >= frame.getMinArrivalTime())
                    break;
            }
            while(true){
                ts = random.nextInt(frame.getMaxServiceTime() + 1);
                if(ts >= frame.getMinServiceTime())
                    break;
            }
            client = new Client(clientId, ta, ts);
            clients.add(client);
            clientId++;
        }
    }

    private void computeAverageWaitingTime(){
        int summ = 0;
        for(Client client: clients){
            summ += client.getSimulationTime();
        }

        this.averageWaitingTime = (double) summ / frame.getNumOfClients();
    }


    public static void main(String[] Args){
        SimulationFrame frame = new SimulationFrame();
        frame.getStartSimulationButton().addActionListener(new ActionListener() {
            SimManager sim;
            Thread t;
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setText("");
                sim = new SimManager(frame);
                t = new Thread(sim);
                t.start();
            }
        });
    }
}
