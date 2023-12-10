package businessLogic;

import businessLogic.validators.*;
import dataAccess.ClientDAO;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @authot Serban Sebastian Mihai
 */
public class ClientBLL {
    private ClientDAO clientDAO;
    private List<Validator<Client>> validators;

    public ClientBLL(){
        clientDAO = new ClientDAO();

        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientIdValidator());
        validators.add(new ClientNameValidator());
        validators.add(new ClientEmailValidator());
        validators.add(new ClientPhoneNrValidator());
        validators.add(new ClientAddressValidator());
    }

    /**
     *
     * @param id
     * @return Client
     */
    public Client findClientById(Integer id){
        Client client = (Client)clientDAO.findByID(id);
        if(client == null){
            throw new NoSuchElementException("The client id = " + id + "was not found");
        }
        return client;
    }

    /**
     *
     * @param client
     * @return Client
     * @throws Exception
     */
    public Client insertClient(Client client) throws Exception {
        Client clnt = (Client)clientDAO.insert(client);
        if(clnt == null){
            throw new Exception("The insertion of the client was not completed");
        }

        return clnt;
    }

    /**
     *
     * @param client
     * @return Client
     * @throws Exception
     */
    public Client updateClient(Client client)throws Exception{
        Client clnt = (Client)clientDAO.update(client);
        if(clnt == null){
            throw new Exception("The update of the client was not completed");
        }

        return clnt;
    }

    /**
     *
     * @param id
     * @return bool value
     * @throws Exception
     */
    public Boolean deleteClientById(Integer id)throws Exception{
        Boolean clnt = clientDAO.deleteById(id);
        if(clnt == null){
            throw new Exception("The deletion of the client was not completed");
        }

        return clnt;
    }

    /**
     *
     * @return A list of clients
     * @throws Exception
     */
    public List<Client> listAllClients()throws Exception{
        List<Client> clients = clientDAO.findAll();
        if(clients.size() == 0){
            throw new Exception("The table is empty");
        }

        return clients;
    }

    /**
     *
     * @param clients
     * @return a list of strings
     */
    public List<String> clientsToString(List<Client> clients){
        List<String> clt = new ArrayList<String>();

        for(Client client: clients){
            clt.add(client.getId() + " - " + client.getName());
        }

        return clt;
    }

    /**
     *
     * @param clients
     * @return a list of strings
     */
    public List<String> idsToString(List<Client> clients){
        List<String> clt = new ArrayList<String>();

        for(Client client: clients){
            clt.add(client.getId().toString());
        }

        return clt;
    }

    /**
     *
     * @param client
     * @return a string that says it is either valid or the error
     */
    public String validations(Client client){

        try{
            for(Validator<Client> val : validators){
                val.validate(client);
            }
        }catch(IllegalArgumentException e) {
            return e.getMessage();
        }

        return new String("Ok");
    }

    /**
     *
     * @param client - validates all fields except for ID
     * @return a string that says it is either valid or the error
     *
     */
    public String updateValidations(Client client){

        try{
            for(int i = 1; i < 5; i++){
                validators.get(i).validate(client);
            }
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }

        return new String("Ok");
    }
}
