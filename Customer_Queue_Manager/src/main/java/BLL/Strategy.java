package BLL;

import Model.Client;
import Model.Server;

import java.util.List;

public class Strategy {

    public void addClient(List<Server> servers, Client client){
        Integer min = 0, tmin = 2000;
        for(Server server : servers){
            if(tmin.compareTo(server.getWaitingPeriod().get()) > 0 && server.getClients().size() < server.getSize() - 1) {
                min = server.getServerNumber() - 1;
                tmin = server.getWaitingPeriod().get();
            }
        }

        servers.get(min).addClient(client);
    }
}
