package buttons;

import businessLogic.ClientBLL;
import model.Client;
import presentationLayer.UpdateClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the EditCLient Button</p>
 */
public class EditClient implements ActionListener {
    private UpdateClientFrame frame;
    private ClientBLL bll;

    public EditClient(UpdateClientFrame frame){
        this.frame = frame;
        bll = new ClientBLL();
    }
    public void actionPerformed(ActionEvent e) {
        boolean flag = false;
        frame.initLabels();
        if(frame.getInfo(0).equals("")){
            flag = true;
            frame.setInfo(0, "This field must not be empty");
        }if(frame.getInfo(1).equals("")){
            flag = true;
            frame.setInfo(1, "This field must not be empty");
        }if(frame.getInfo(2).equals("")){
            flag = true;
            frame.setInfo(2, "This field must not be empty");
        }if(frame.getInfo(3).equals("")){
            flag = true;
            frame.setInfo(3, "This field must not be empty");
        }
        if(flag == true)    return;
        String[] parts = ((String) frame.getClientBox().getSelectedItem()).split(" - ");
        Integer id = Integer.parseInt(parts[0].trim());
        Client client = new Client(id, frame.getInfo(0), frame.getInfo(1), frame.getInfo(2), frame.getInfo(3));
        String result = bll.updateValidations(client);
        if(!result.equals("Ok")) {
            switch (result) {
                case "The name is not valid. It must have the following pattern surname firstname":
                    frame.setInfo(0, result);
                    break;
                case "The e-mail you provided is not valid":
                    frame.setInfo(1, result);
                    break;
                case "The phone number is not valid. It must contain only digits":
                    frame.setInfo(2, result);
                    break;
                case "The address is not valid, try following the next pattern: Street name number(No.3), City, County, Country":
                    frame.setInfo(3, result);
                    break;
                default:
                    throw new NoSuchElementException("How did you end up here?");
            }
        }else{
            try {
                bll.updateClient(client);
                frame.init();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
