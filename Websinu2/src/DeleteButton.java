import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteButton implements ActionListener {
    WebSinu2View view;
    WebSinu2Model model;

    DeleteButton(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.model.deleteUser(this.view.getUsrname());
            this.view.superAdmin();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
