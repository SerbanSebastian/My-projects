import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InputListener implements ActionListener {
    private WebSinu2View view;
    private WebSinu2Model model;
    InputListener(WebSinu2View view, WebSinu2Model model) {
        this.model = model;
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try {
            this.model.insertUser(
                    this.view.getUser(),
                    this.view.getPas(),
                    this.view.getTip(),
                    this.view.getNume(),
                    this.view.getPrenume(),
                    this.view.getAdresa(),
                    this.view.getNrTelefon(),
                    this.view.getIBAN(),
                    this.view.geteMail(),
                    this.view.getNrContract()
            );
            this.view.superAdmin();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
