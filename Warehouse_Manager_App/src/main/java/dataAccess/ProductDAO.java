package dataAccess;

import model.Product;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This class is meant to be used in order to manipulate data from the DB</p>
 */
public class ProductDAO extends AbstractDAO<Product>{

    /**
     *
     * @param product
     * @return String
     */
    public static String insertQueryBuilder(Product product){
        StringBuilder string = new StringBuilder();
        string.append("INSERT INTO product (id, name, price, quantity) VALUES (");
        string.append(product.getId() + ", ");
        string.append("'" + product.getName() + "', ");
        string.append(product.getPrice() + ", ");
        string.append(product.getQuantity() + ")");
        return string.toString();
    }

    /**
     *
     * @param product
     * @return String
     */
    public static String updateQueryBuilder(Product product){
        StringBuilder string = new StringBuilder();
        string.append("UPDATE product SET name = ");
        string.append("'" + product.getName() + "', price = ");
        string.append(product.getPrice() + ", quantity = ");
        string.append(product.getQuantity() + " WHERE id = " + product.getId());
        return string.toString();
    }
}
