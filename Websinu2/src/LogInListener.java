import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInListener implements ActionListener {
    private WebSinu2View view;
    private WebSinu2Model model;
    LogInListener(WebSinu2View view,WebSinu2Model model){
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = view.getUsername();
        String pass = view.getPassword();
        try {
            String result = model.verifUsrPass(user, pass);
            if(result.equals("parola incorecta"))
                throw new Exception("Parola incorecta");
            else{
                if(result.equals("conectare la cont reusita")) {
                    this.model.discoverUtilizator(user);
                    this.view.conectareOK(this.model.getUtilizator_tip());
                }
                else{
                    this.view.utilizatorInexistent();
                }
            }
        } catch (Exception e1) {
            this.view.frameIncorectPass();
        }
    }
}
