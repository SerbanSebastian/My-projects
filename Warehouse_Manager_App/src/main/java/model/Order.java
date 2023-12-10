package model;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a data model for the DB table</p>
 */
public class Order {
    private Integer id;
    private Integer clientID;
    private Integer productID;
    private Double total;

    public Order(){

    }

    public Order(Integer clientID, Integer productID, Double total){
        this.clientID = clientID;
        this.productID = productID;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productsID) {
        this.productID = productID;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
