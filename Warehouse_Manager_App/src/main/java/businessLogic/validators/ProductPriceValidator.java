package businessLogic.validators;

import model.Product;

import java.util.regex.Pattern;

public class ProductPriceValidator implements Validator<Product>{
    private static final String PATTERN = "^\\d+(\\.\\d{1,2})?$";

    @Override
    public void validate(Product product) {
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(product.getPrice().toString()).matches()){
            throw new IllegalArgumentException("The price is not valid. It must have 2 digits after de decimal point");
        }
        if(product.getPrice() <= 0) {
            throw new IllegalArgumentException("The price must be greater than 0");
        }
    }
}
