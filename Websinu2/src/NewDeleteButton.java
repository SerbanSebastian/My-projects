import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.WritableByteChannel;

public class NewDeleteButton implements ActionListener {
    WebSinu2View view;
    WebSinu2Model model;

    NewDeleteButton(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.view.superAdminDelete();
    }
}
