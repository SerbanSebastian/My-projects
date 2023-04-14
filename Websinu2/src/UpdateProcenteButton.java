import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateProcenteButton implements ActionListener {
    WebSinu2View view; WebSinu2Model model;
    public UpdateProcenteButton(WebSinu2View view, WebSinu2Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.model.updateProcente(this.view.getIdCurs(), Float.valueOf(this.view.getPondereLab()), Float.valueOf(this.view.getPondereSeminar()), Float.valueOf(this.view.getPondereCurs()));
            this.view.profesor();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
