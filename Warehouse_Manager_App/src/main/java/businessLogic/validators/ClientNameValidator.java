package businessLogic.validators;

import model.Client;

import java.util.regex.Pattern;

public class ClientNameValidator implements Validator<Client>{
    private static final String PATTERN = "^[\\p{L}\\s'-]+ [\\p{L}\\s'-]+$";

    public void validate(Client client) {
        Pattern pattern = Pattern.compile(PATTERN);
        if (!pattern.matcher(client.getName()).matches()) {
            throw new IllegalArgumentException("The name is not valid. It must have the following pattern surname firstname");
        }
    }
}
