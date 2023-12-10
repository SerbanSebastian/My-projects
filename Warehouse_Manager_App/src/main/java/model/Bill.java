package model;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a data model for the DB table</p>
 */
public final class Bill {
    private final int id;
    private final int clientID;
    private final int productID;
    private final Double total;

    public int getId() {
        return id;
    }

    public int getClientID() {
        return clientID;
    }

    public int getProductID() {
        return productID;
    }

    public Double getTotal() {
        return total;
    }

    public Bill(int id, int clientId, int productId, Double total){
        this.id = id;
        this.clientID = clientId;
        this.productID = productId;
        this.total = total;
    }
}
