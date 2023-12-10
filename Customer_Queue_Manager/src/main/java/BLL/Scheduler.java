package BLL;

import Model.Client;
import Model.Server;

import java.util.ArrayList;
import java.util.List;

public class Scheduler{
    private Integer noOfClients;
    private static Integer threadNumber = 1;
    private Integer noOfQueues;
    private List<Server> servers;
    private Strategy strategy;

    public Scheduler(Integer noOfClients, Integer noOfQueues){
        this.noOfClients = noOfClients;
        this.noOfQueues = noOfQueues;
        strategy = new Strategy();
        servers = new ArrayList<>();
        Server server;

        for(int i = 0; i < noOfQueues; i++){
            server = new Server(noOfClients, threadNumber);
            threadNumber++;
            servers.add(server);
            Thread t = new Thread(server);
            t.start();
        }
    }

    public List<Server> getServers(){
        return this.servers;
    }

    public void addNextClient(Client client){
        strategy.addClient(servers, client);
    }
}
