package businessLogic.validators;

import dataAccess.ProductDAO;
import model.Product;

import java.util.regex.Pattern;

public class ProductIdValidator implements Validator<Product>{
    private static final String PATTERN = "\\d+";
    private ProductDAO dao;

    public ProductIdValidator(){
        dao = new ProductDAO();
    }

    public void validate(Product product) {
        Product aux;
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(product.getId().toString()).matches()){
            throw new IllegalArgumentException("The id is not valid, it must be composed only by digits");
        }

        aux = dao.findByID(product.getId());
        if(aux != null){
            throw new IllegalArgumentException("The id already exists in the database");
        }
    }
}
