import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfisNote implements ActionListener {
    private WebSinu2View view;
    private WebSinu2Model model;
    public AfisNote(WebSinu2View view, WebSinu2Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.view.AfisareCatalog();
    }
}
