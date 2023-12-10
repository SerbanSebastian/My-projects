package businessLogic.validators;

import model.Product;

import java.util.regex.Pattern;

public class ProductQuantityValidator implements Validator<Product>{
    private static final String PATTERN = "\\d+";

    @Override
    public void validate(Product product) {
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(product.getQuantity().toString()).matches()){
            throw new IllegalArgumentException("The quantity is invalid");
        }
        if(product.getQuantity() <= 0){
            throw new IllegalArgumentException("The quantity must be greater than 0");
        }
    }
}
