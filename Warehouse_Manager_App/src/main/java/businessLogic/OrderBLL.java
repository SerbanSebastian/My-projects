package businessLogic;

import dataAccess.AbstractDAO;
import dataAccess.OrderDAO;
import model.Order;

/**
 * @author Serban Sebastian Mihai
 */
public class OrderBLL extends AbstractDAO<Order> {
    private OrderDAO dao;

    public OrderBLL(){
        dao = new OrderDAO();
    }

    /**
     *
      * @param order
     * @return Order
     * @throws Exception
     */
    public Order insertOrder(Order order) throws Exception {
        Order ord = (Order) dao.insert(order);
        if(ord == null){
            throw new Exception("The insertion of the order was not completed");
        }

        return ord;
    }
}
