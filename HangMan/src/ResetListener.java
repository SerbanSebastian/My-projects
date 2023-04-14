import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetListener implements ActionListener {
    HangManModel model;
    HangManView view;

    public ResetListener(HangManModel model, HangManView view){
        this.model = model;
        this.view = view;
    }

    public void actionPerformed(ActionEvent event){
        model.reset();
        view.reset();
    }
}
