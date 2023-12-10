package businessLogic.validators;

import model.Product;

import java.util.regex.Pattern;

public class ProductNameValidator implements Validator<Product>{
    private static final String PATTERN = "^[A-Za-z0-9\\s]+$";

    @Override
    public void validate(Product product) {
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(product.getName()).matches()){
            throw new IllegalArgumentException("The name is invalid");
        }
    }
}
