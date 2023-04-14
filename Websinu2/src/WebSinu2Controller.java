public class WebSinu2Controller {
    private WebSinu2View view;
    private WebSinu2Model model;

    WebSinu2Controller(WebSinu2Model model, WebSinu2View view){

        this.model = model;
        this.view = view;
        this.view.addRetryBtn(new RetryListener(this.view, this.model));
        this.view.addLogInBtn(new LogInListener(this.view, this.model));
        this.view.addInputBtn(new InputListener(this.view, this.model));
        this.view.addLogOutBtn(new LogOutListener(this.view, this.model));
        this.view.addNewUserBtn(new NewUserListener(this.view, this.model));
        this.view.addNewSearchBtn(new NewSearchBtn(this.view, this.model));
        this.view.addSrcBtn(new SearchBtn(this.view, this.model));
        this.view.addBackBtn(new BackBtn(this.view, this.model));
        this.view.addNewDeleteBtn(new NewDeleteButton(this.view, this.model));
        this.view.addDeleteBtn(new DeleteButton(this.view, this.model));
        this.view.addDatePersonaleBtn(new DatePersonaleButton(this.view, this.model));
        this.view.addImpartireBtn(new ImpartireProcentualaButton(this.view, this.model));
        this.view.addUpdateProcente(new UpdateProcenteButton(this.view, this.model));
        this.view.addCurs(new AddCursButton(this.view, this.model));
        this.view.addNewCurs(new AddNewCursButton(this.view, this.model));
        this.view.addActivitateBtn(new AddActivitate(this.view, this.model));
        this.view.addNewActivity(new NewActivity(this.view, this.model));
        this.view.addAfisNote(new AfisNote(this.view, this.model));
    }
}
