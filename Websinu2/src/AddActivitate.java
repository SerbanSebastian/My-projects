import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddActivitate implements ActionListener {
    private WebSinu2View view;
    private WebSinu2Model model;
    public AddActivitate(WebSinu2View view, WebSinu2Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.model.addActivitate(this.view.getIdCurs(),
                    this.view.getIdActivitate(),
                    this.view.getIntervalOrar(),
                    this.view.getDataAct(),
                    this.view.getNrMinPart(),
                    this.view.getDeadline(),
                    this.view.getMaterie(),
                    this.view.getNrMaxPart(),
                    this.view.getIdProfesor());
            this.view.profesor();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
