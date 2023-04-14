import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DatePersonaleButton implements ActionListener {
    WebSinu2View view;
    WebSinu2Model model;
    public DatePersonaleButton(WebSinu2View view, WebSinu2Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.model.datePersonale(this.view.getUsername(), this.view);
        } catch (SQLException ex) {
            System.out.println("Nereusit");
        }
    }
}
