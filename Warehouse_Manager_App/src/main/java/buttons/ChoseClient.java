package buttons;

import businessLogic.ClientBLL;
import model.Client;
import presentationLayer.UpdateClientFrame;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the ChoseCLient Button</p>
 */
public class ChoseClient implements ActionListener {
    private JComboBox<String> comboBox;
    private ClientBLL clientBLL;
    private UpdateClientFrame frame;

    public ChoseClient(JComboBox comboBox, UpdateClientFrame frame){
        this.comboBox = comboBox;
        this.frame = frame;
        clientBLL = new ClientBLL();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] parts = ((String) comboBox.getSelectedItem()).split(" - ");
        Integer id = Integer.parseInt(parts[0].trim());
        Client client;
        client = clientBLL.findClientById(id);

        frame.setOldInfo(0, client.getName());
        frame.setOldInfo(1, client.getEmail());
        frame.setOldInfo(2, client.getPhoneNr());
        frame.setOldInfo(3, client.getAddress());
    }
}
