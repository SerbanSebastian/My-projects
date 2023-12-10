package buttons;

import businessLogic.BillBLL;
import businessLogic.OrderBLL;
import businessLogic.ProductBLL;
import model.Bill;
import model.Order;
import model.Product;
import presentationLayer.OrderFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @Autohr Serban Sebastian Mihai
 * <p>This is a class meant to describe the functionality of the Add Order Button</p>
 */
public class AddOrder implements ActionListener {
    private OrderFrame frame;
    private ProductBLL pbll;
    private OrderBLL obll;
    private BillBLL bbll;

    public AddOrder(OrderFrame frame){
        this.frame = frame;
        obll = new OrderBLL();
        pbll = new ProductBLL();
        bbll = new BillBLL();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.initLabel();
        if(frame.getQuantity().equals("")){
            frame.setQuantity("This field must not be empty");
            return;
        }
        Product product = pbll.findProductById(Integer.valueOf((String) frame.getProductId().getSelectedItem()));
        if( product.getQuantity() < Integer.valueOf(frame.getQuantity())){
            frame.setQuantity("We do not currently have this much quantity of the product");
        }
        else{
            Order order = new Order(Integer.valueOf((String)frame.getClientId().getSelectedItem()), Integer.valueOf((String)frame.getProductId().getSelectedItem()), Integer.valueOf(frame.getQuantity()) * product.getPrice());

            try {
                obll.insertOrder(order);
                Random random = new Random();
                Bill bill = new Bill(random.nextInt(), Integer.valueOf((String)frame.getClientId().getSelectedItem()), Integer.valueOf((String)frame.getProductId().getSelectedItem()), Integer.valueOf(frame.getQuantity()) * product.getPrice());
                //bbll.insertBill(bill);
                if(product.getQuantity() - Integer.valueOf(frame.getQuantity()) > 0)
                    pbll.updateProduct(new Product(product.getId(), product.getName(), product.getPrice(), product.getQuantity() - Integer.valueOf(frame.getQuantity())));
                else
                    pbll.deleteProductById(product.getId());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
