package buttons;

import businessLogic.ProductBLL;
import presentationLayer.DeleteProductFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the DeleteProduct Button</p>
 */
public class DeleteProduct implements ActionListener {
    private DeleteProductFrame frame;
    private ProductBLL bll;

    public DeleteProduct(DeleteProductFrame frame){
        this.frame = frame;
        bll = new ProductBLL();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] parts = ((String) frame.getComboBox().getSelectedItem()).split(" - ");
        Integer id = Integer.parseInt(parts[0].trim());

        try {
            bll.deleteProductById(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        frame.init();
    }
}
