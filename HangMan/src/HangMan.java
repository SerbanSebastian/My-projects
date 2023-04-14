import java.io.FileNotFoundException;

public class HangMan {
    public static void main(String[] args) throws FileNotFoundException {

        HangManModel model = new HangManModel();
        HangManView view = new HangManView(model);
        HangManController controller= new HangManController(view, model);
        view.setVisible(true);
        return;
    }
}
