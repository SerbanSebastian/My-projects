import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewCursButton implements ActionListener {
    private WebSinu2View view;
    private WebSinu2Model model;
    public AddNewCursButton(WebSinu2View view, WebSinu2Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.view.addNewCurs();
    }
}
