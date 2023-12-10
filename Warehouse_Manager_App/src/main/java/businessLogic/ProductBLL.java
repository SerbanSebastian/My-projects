package businessLogic;

import businessLogic.validators.*;
import dataAccess.ProductDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Serban Sebastian Mihai
 */
public class ProductBLL {
    private ProductDAO productDAO;
    private List<Validator<Product>> validators;

    public ProductBLL(){
        productDAO = new ProductDAO();

        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductIdValidator());
        validators.add(new ProductNameValidator());
        validators.add(new ProductPriceValidator());
        validators.add(new ProductQuantityValidator());
    }

    /**
     *
     * @param id
     * @return Product
     */
    public Product findProductById(Integer id){
        Product product = (Product)productDAO.findByID(id);
        if(product == null){
            throw new NoSuchElementException("The product with id = " + id + "was not found");
        }
        return product;
    }

    /**
     *
     * @param product
     * @return Product
     * @throws Exception
     */
    public Product insertProduct(Product product) throws Exception {
        Product prod = (Product)productDAO.insert(product);
        if(prod == null){
            throw new Exception("The insertion of the product was not completed");
        }

        return prod;
    }

    /**
     *
     * @param product
     * @return Product
     * @throws Exception
     */
    public Product updateProduct(Product product)throws Exception{
        Product prod = (Product)productDAO.update(product);
        if(prod == null){
            throw new Exception("The update of the product was not completed");
        }

        return prod;
    }

    /**
     *
     * @return list of products
     * @throws Exception
     */
    public List<Product> listAllProducts()throws Exception{
        List<Product> products = productDAO.findAll();
        if(products.size() == 0){
            throw new Exception("The table is empty");
        }

        return products;
    }

    /**
     *
     * @param products
     * @return list of strings
     */
    public List<String> productsToString(List<Product> products){
        List<String> prod = new ArrayList<String>();

        for(Product product: products){
            prod.add(product.getId() + " - " + product.getName());
        }

        return prod;
    }

    /**
     *
     * @param products
     * @return list of strings
     */
    public List<String> idsToString(List<Product> products){
        List<String> prod = new ArrayList<String>();

        for(Product product: products){
            prod.add(product.getId().toString());
        }

        return prod;
    }

    /**
     *
     * @param product
     * @return String
     */
    public String validations(Product product){

        try{
            for(Validator<Product> val : validators){
                val.validate(product);
            }
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }
        return new String("Ok");
    }

    /**
     *
     * @param id
     * @return Boolean value
     * @throws Exception
     */
    public Boolean deleteProductById(Integer id)throws Exception{
        Boolean clnt = productDAO.deleteById(id);
        if(clnt == null){
            throw new Exception("The deletion of the product was not completed");
        }

        return clnt;
    }

    /**
     *
     * @param product
     * @return String
     */
    public String updateValidations(Product product){
        try{
            for(int i = 1; i < 4; i++){
                validators.get(i).validate(product);
            }
        }catch(IllegalArgumentException e){
            return e.getMessage();
        }

        return new String("Ok");
    }
}
