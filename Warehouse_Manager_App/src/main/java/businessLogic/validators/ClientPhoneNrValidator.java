package businessLogic.validators;

import model.Client;

import java.util.regex.Pattern;

public class ClientPhoneNrValidator implements Validator<Client>{
    private static final String PATTERN = "\\d+";

    public void validate(Client client){
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(client.getPhoneNr()).matches()){
            throw new IllegalArgumentException("The phone number is not valid. It must contain only digits");
        }
    }
}
