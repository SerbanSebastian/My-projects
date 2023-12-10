package businessLogic.validators;

import dataAccess.ClientDAO;
import model.Client;

import java.util.regex.Pattern;

public class ClientIdValidator implements Validator<Client>{
    private static final String PATTERN = "\\d+";
    private ClientDAO dao;

    public ClientIdValidator(){
        dao = new ClientDAO();
    }

    public void validate(Client client) {
        Pattern pattern = Pattern.compile(PATTERN);
        Client aux;
        if(!pattern.matcher(client.getId().toString()).matches()){
            throw new IllegalArgumentException("The id is not valid, it must be composed only by digits");
        }
        aux = (Client) dao.findByID(client.getId());
        if(aux != null){
            throw new IllegalArgumentException("The id already exists in the database");
        }
    }
}
