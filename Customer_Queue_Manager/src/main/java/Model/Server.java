package Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Client> clients;
    private AtomicInteger waitingPeriod;
    private Integer queueNumber;
    private Integer size;

    public Server(Integer size, Integer queueNumber){
        clients = new ArrayBlockingQueue<>(size);
        this.size = size;
        waitingPeriod = new AtomicInteger();
        this.queueNumber = queueNumber;
    }

    public synchronized void addClient(Client client){
        if(clients.size() < size - 1) {
            clients.add(client);
            waitingPeriod.getAndAdd(client.getSimulationTime());
        }
    }

    public void run() {
        while(true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!clients.isEmpty()){
                clients.element().setSimulationTime(clients.element().getSimulationTime() - 1);
                waitingPeriod.decrementAndGet();
                if(clients.element().getSimulationTime() == 0){
                    try {
                        clients.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public AtomicInteger getWaitingPeriod(){
        return this.waitingPeriod;
    }

    public Integer getServerNumber(){
        return this.queueNumber;
    }

    public Integer getSize(){
        return this.size;
    }
    public int getActualSize() {
        return this.clients.size();
    }

    public BlockingQueue<Client> getClients(){
        return this.clients;
    }
}
