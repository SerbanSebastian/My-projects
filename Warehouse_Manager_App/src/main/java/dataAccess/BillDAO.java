package dataAccess;

import model.Bill;

/**
 * @author Serban Sebastian Mihai
 */
public class BillDAO extends AbstractDAO<Bill> {

    /**
     *
     * @param bill
     * @return
     */
    public static String insertQueryBuilder(Bill bill){
        StringBuilder string = new StringBuilder();
        string.append("INSERT INTO warehousedb.bill (clientID, productID, total) VALUES (");
        string.append(bill.getClientID() + ", ");
        string.append(bill.getProductID() + ", ");
        string.append(bill.getTotal() + ")");
        return string.toString();
    }
}