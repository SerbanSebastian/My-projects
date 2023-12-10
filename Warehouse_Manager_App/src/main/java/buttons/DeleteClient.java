package buttons;

import businessLogic.ClientBLL;
import presentationLayer.DeleteClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the DeleteClient Button</p>
 */
public class DeleteClient implements ActionListener {
    private DeleteClientFrame frame;
    private ClientBLL bll;

    public DeleteClient(DeleteClientFrame frame){
        this.frame = frame;
        bll = new ClientBLL();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] parts = ((String) frame.getComboBox().getSelectedItem()).split(" - ");
        Integer id = Integer.parseInt(parts[0].trim());

        try {
            bll.deleteClientById(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        frame.init();
    }
}
