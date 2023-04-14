import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SearchBtn implements ActionListener {
    WebSinu2Model model;
    WebSinu2View view;

    SearchBtn(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.view.SearchEroare(this.model.searchUser(this.view.getUsrname()));
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
