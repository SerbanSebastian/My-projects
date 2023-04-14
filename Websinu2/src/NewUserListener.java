import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUserListener implements ActionListener {
    WebSinu2Model model;
    WebSinu2View view;

    NewUserListener(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.view.superAdminAdd();
    }
}
