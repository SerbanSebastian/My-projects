import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetryListener implements ActionListener {
    private WebSinu2View view;
    private WebSinu2Model model;
    RetryListener(WebSinu2View view, WebSinu2Model model){
        this.view = view;
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        view.initPasswordTxt();
        view.init();
    }
}
