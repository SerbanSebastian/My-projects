package buttons;

import businessLogic.ProductBLL;
import model.Product;
import presentationLayer.AddClientFrame;
import presentationLayer.AddProductFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

/**
 * @author Serban Sebastian Mihai
 *
 * <p>This Class describes the functionality of the AddProduct Button</p>
 */
public class AddProduct implements ActionListener {
    private AddProductFrame frame;
    private ProductBLL bll;

    public AddProduct(AddProductFrame frame){
        this.frame = frame;
        bll = new ProductBLL();
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
        }if(frame.getTfPrice().equals("")){
            frame.setMsgPrice("This field can't be empty");
            flag = true;
        }if(frame.getTfQuantity().equals("")){
            frame.setMsgQuantity("This field can't be empty");
            flag = true;
        }
        if(flag == true) return;
        Product product = new Product(Integer.valueOf(frame.getTfId()), frame.getTfName(), Double.valueOf(frame.getTfPrice()), Integer.valueOf(frame.getTfQuantity()));
        String result = bll.validations(product);
        if(!result.equals("Ok")) {
            switch (result) {
                case "The id is not valid, it must be composed only by digits":
                case "The id already exists in the database":
                    frame.setMsgId(result);
                    break;
                case "The name is invalid":
                    frame.setMsgName(result);
                    break;
                case "The price is not valid. It must have 2 digits after de decimal point":
                case "The price must be greater than 0":
                    frame.setMsgPrice(result);
                    break;
                case "The quantity is invalid":
                case "The quantity must be greater than 0":
                    frame.setMsgQuantity(result);
                    break;
                default:
                    throw new NoSuchElementException("How did you end up here?");
            }
        }else{
            try {
                bll.insertProduct(product);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
