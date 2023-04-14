public class HangManController {
    HangManController(HangManView view, HangManModel model) {

        view.addInputListener(new InputListener(model, view));
        view.addResetListener(new ResetListener(model, view));
    }
}
