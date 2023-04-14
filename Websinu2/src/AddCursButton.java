import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddCursButton implements ActionListener {
    WebSinu2View view;
    WebSinu2Model model;
    public AddCursButton(WebSinu2View view, WebSinu2Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.model.addCurs(this.view.getIdCurs(), this.view.getMaterie(), this.view.getActivitati(),  this.view.getNrOre(), this.view.getPondereLab(), this.view.getPondereSeminar(), this.view.getPondereCurs(), this.view.getIdProfesor());
            this.view.profesor();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
