package buttons;

import businessLogic.ProductBLL;
import model.Product;
import presentationLayer.UpdateProductFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the EditProduct Button</p>
 */
public class EditProduct implements ActionListener {
    private UpdateProductFrame frame;
    private ProductBLL bll;

    public EditProduct(UpdateProductFrame frame){
        this.frame = frame;
        bll = new ProductBLL();
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
        }
        if(flag == true)    return;
        String[] parts = ((String) frame.getProductBox().getSelectedItem()).split(" - ");
        Integer id = Integer.parseInt(parts[0].trim());
        Product product = new Product(id, frame.getInfo(0), Double.valueOf(frame.getInfo(1)), Integer.valueOf(frame.getInfo(2)));
        String result = bll.updateValidations(product);
        if(!result.equals("Ok")) {
            switch (result) {
                case "The name is invalid":
                    frame.setInfo(0, result);
                    break;
                case "The price is not valid. It must have 2 digits after de decimal point":
                case "The price must be greater than 0":
                    frame.setInfo(1, result);
                    break;
                case "The quantity is invalid":
                case "The quantity must be greater than 0":
                    frame.setInfo(2, result);
                    break;
                default:
                    throw new NoSuchElementException("How did you end up here?");
            }
        }else{
            try {
                bll.updateProduct(product);
                frame.init();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
