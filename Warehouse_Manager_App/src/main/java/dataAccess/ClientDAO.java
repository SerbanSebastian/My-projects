package dataAccess;

import model.Client;

import java.sql.Statement;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class is meant to be used in order to manipulate data from the DB</p>
 */
public class ClientDAO extends AbstractDAO<Client>{

    /**
     *
     * @param client
     * @return String
     */
    public static String insertQueryBuilder(Client client){
        StringBuilder string = new StringBuilder();
        string.append("INSERT INTO warehousedb.client (id, name, email, phoneNr, address) VALUES (");
        string.append(client.getId() + ", ");
        string.append("'" + client.getName() + "', ");
        string.append("'" + client.getEmail() + "', ");
        string.append("'" + client.getPhoneNr() + "', ");
        string.append("'" + client.getAddress() + "')");
        return string.toString();
    }

    /**
     *
     * @param client
     * @return String
     */
    public static String updateQueryBuilder(Client client){
        StringBuilder string = new StringBuilder();
        string.append("UPDATE warehousedb.client SET name = ");
        string.append("'" + client.getName() + "', email = ");
        string.append("'" + client.getEmail() + "', phoneNr = ");
        string.append("'" + client.getPhoneNr() + "', address = ");
        string.append("'" + client.getAddress() + "' WHERE id = " + client.getId());
        return string.toString();
    }
}
