package buttons;

import businessLogic.ProductBLL;
import model.Product;
import presentationLayer.UpdateProductFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the ChoseProduct Button</p>
 */
public class ChoseProduct implements ActionListener {
    private JComboBox<String> comboBox;
    private ProductBLL productBLL;
    private UpdateProductFrame frame;

    public ChoseProduct(JComboBox comboBox, UpdateProductFrame frame){
        this.comboBox = comboBox;
        this.frame = frame;
        productBLL = new ProductBLL();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] parts = ((String) comboBox.getSelectedItem()).split(" - ");
        Integer id = Integer.parseInt(parts[0].trim());
        Product product;
        product = productBLL.findProductById(id);

        frame.setOldInfo(0, product.getName());
        frame.setOldInfo(1, product.getPrice().toString());
        frame.setOldInfo(2, product.getQuantity().toString());
    }
}
