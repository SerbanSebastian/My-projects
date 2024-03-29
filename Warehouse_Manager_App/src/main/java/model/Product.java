package model;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class represent a data model for the DB table</p>
 */
public class Product {
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;

    public Product(){

    }
    public Product(Integer id, String name, Double price, Integer quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
