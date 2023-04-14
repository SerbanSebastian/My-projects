import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewSearchBtn implements ActionListener {
    WebSinu2View view;
    WebSinu2Model model;
    NewSearchBtn(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.view.SuperAdminSrc();
    }
}
