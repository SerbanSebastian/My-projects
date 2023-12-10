package businessLogic.validators;

import model.Client;

import java.util.regex.Pattern;

public class ClientAddressValidator implements Validator<Client>{
    private static final String PATTERN = "[a-zA-Z]+ No.\\d+, [a-z\\-A-Z]+, [a-z\\-A-Z]+, [a-z\\-A-Z]+";

    public void validate(Client client){
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(client.getAddress()).matches()){
            throw new IllegalArgumentException("The address is not valid, try following the next pattern: Street name number(No.3), City, County, Country");
        }
    }
}
