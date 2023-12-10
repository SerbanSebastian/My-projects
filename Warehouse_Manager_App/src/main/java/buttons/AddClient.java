package buttons;

import businessLogic.ClientBLL;
import model.Client;
import presentationLayer.AddClientFrame;
import java.util.NoSuchElementException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 * <p>This class descrbies the functionality of AddClient Button</p>
 */
public class AddClient implements ActionListener {

    private AddClientFrame frame;
    private ClientBLL bll;

    public AddClient(AddClientFrame frame){
        this.frame = frame;
        bll = new ClientBLL();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        frame.initLabels();
        if(frame.getTfId().equals("")){
            frame.setMsgId("This field can't be empty");
            flag = true;
        }if(frame.getTfName().equals("")){
            frame.setMsgName("This field can't be empty");
            flag = true;
        }if(frame.getTfEmail().equals("")){
            frame.setMsgEmail("This field can't be empty");
            flag = true;
        }if(frame.getTfPhoneNr().equals("")){
            frame.setMsgPhoneNr("This field can't be empty");
            flag = true;
        }if(frame.getTfAddress().equals("")){
            frame.setMsgAddress("This field can't be empty");
            flag = true;
        }
        if(flag == true) return;
        Client client = new Client(Integer.valueOf(frame.getTfId()), frame.getTfName(), frame.getTfEmail(), frame.getTfPhoneNr(), frame.getTfAddress());
        String result = bll.validations(client);
        if(!result.equals("Ok")) {
            switch (result) {
                case "The id is not valid, it must be composed only by digits":
                case "The id already exists in the database":
                    frame.setMsgId(result);
                    break;
                case "The name is not valid. It must have the following pattern surname firstname":
                    frame.setMsgName(result);
                    break;
                case "The e-mail you provided is not valid":
                    frame.setMsgEmail(result);
                    break;
                case "The phone number is not valid. It must contain only digits":
                    frame.setMsgPhoneNr(result);
                    break;
                case "The address is not valid, try following the next pattern: Street name number(No.3), City, County, Country":
                    frame.setMsgAddress(result);
                    break;
                default:
                    throw new NoSuchElementException("How did you end up here?");
            }
        }else{
            try {
                bll.insertClient(client);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
