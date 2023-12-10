package dataAccess;

import model.Order;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class is meant to be used in order to manipulate data from the DB</p>
 */
public class OrderDAO extends AbstractDAO<Order>{

    /**
     *
     * @param order
     * @return String
     */
    public static String insertQueryBuilder(Order order){
        StringBuilder string = new StringBuilder();
        string.append("INSERT INTO warehousedb.order (clientID, productID, total) VALUES (");
        string.append(order.getClientID() + ", ");
        string.append(order.getProductID() + ", ");
        string.append(order.getTotal() + ")");
        return string.toString();
    }

    /**
     *
     * @param order
     * @return String
     */
    public static String updateQueryBuilder(Order order){
        StringBuilder string = new StringBuilder();
        string.append("UPDATE warehousedb.order clientID = ");
        string.append(order.getClientID() + ", productID = ");
        string.append(order.getProductID() + ", total = ");
        string.append(order.getTotal() + " WHERE id = " + order.getId());
        return string.toString();
    }
}
