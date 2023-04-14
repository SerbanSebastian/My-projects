import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackBtn implements ActionListener {
    WebSinu2View view;
    WebSinu2Model model;

    BackBtn(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(this.model.getUtilizator_tip()) {
            case 1:
                this.view.profesor();
                break;
            case 2:
                this.view.student();
                break;
            default:
                this.view.superAdmin();
        }
    }
}
