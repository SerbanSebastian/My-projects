import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputListener implements ActionListener {
    private HangManModel model;
    private HangManView view;

    InputListener(HangManModel model, HangManView view){
        this.model = model;
        this.view = view;
    }
    public void actionPerformed(ActionEvent event){
        if(model.getMistakes().equals(7)){
            this.view.setMsg(1);
            return;
        }
        if(model.getGuessedNo().equals(model.getWordsNumber())){
            this.view.setMsg(2);
            return;
        }

        Boolean result = this.model.check(this.view.getUserInput(), this.view.getSearchFor());
        if(result.equals(true)){
            this.view.setMsg(4);
            if(model.getGuessedNo() < this.model.getWordsNumber())
                this.view.setWord(this.view.toString(this.model.randomWord()));
            if(model.getGuessedNo().equals(this.model.getWordsNumber()))
                this.view.setMsg(2);
        }
        else{
            this.view.setMsg(3);
            this.view.setImg(this.model.getMistakes());
            if(model.getMistakes().equals(7)){
                this.view.setMsg(1);
            }
        }
    }
}
