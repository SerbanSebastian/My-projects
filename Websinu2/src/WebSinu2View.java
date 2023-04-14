import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WebSinu2View extends JFrame {
    private WebSinu2Model model;
    static final Integer f1_w = 900;
    static final Integer f1_h = 600;
    static final Integer f0_w = 900;
    static final Integer f0_h = 600;

    private JTextField tfusername = new JTextField(30);
    private JTextField tfuser = new JTextField("");
    private JTextField tfpass = new JTextField("");
    private JTextField tip = new JTextField(30);
    private JTextField user = new JTextField(30);
    private JTextField pas = new JTextField(30);
    private JTextField nume = new JTextField(30);
    private JTextField prenume = new JTextField(30);
    private JTextField adresa = new JTextField(30);
    private JTextField eMail = new JTextField(30);
    private JTextField IBAN = new JTextField(30);
    private JTextField nrTelefon = new JTextField(30);
    private JTextField nrContract = new JTextField(30);
    private JTextField pondereLab = new JTextField(30);
    private JTextField pondereSeminar = new JTextField(30);
    private JTextField pondereCurs = new JTextField(30);
    private JTextField idCurs = new JTextField(30);
    private JTextField materie = new JTextField(30);
    private JTextField activitati = new JTextField(50);
    private JTextField idProfesor = new JTextField(30);
    private JTextField nrOre = new JTextField(30);
    private JTextField idActivitate = new JTextField(30);
    private JTextField intervalOrar = new JTextField(30);
    private JTextField dataActivitate = new JTextField(30);
    private JTextField nrMinimPart = new JTextField(30);
    private JTextField nrMaximPart = new JTextField(30);
    private JTextField deadline = new JTextField(30);
    private JButton rtrBtn = new JButton("Retry");
    private JButton logIn = new JButton("Log in");
    private JButton newUser = new JButton("Create new user");
    private JButton deleteUser = new JButton("Delete user");
    private JButton searchUser = new JButton("Search");
    private JButton logOut = new JButton("Log out");
    private JButton insertUser = new JButton("Insert values");
    private JButton back = new JButton("Back");

    private JButton srcUser = new JButton("Search");
    private JButton delUser = new JButton("Delete");
    private JButton datePersonaleBtn = new JButton("Date Personale");
    private JButton procenteBtn = new JButton("Impartire procentuala activitati");
    private JButton programareActBtn = new JButton("Programare activitate didactica");
    private JButton afisCatBtn = new JButton("Afisare Catalog");
    private JButton addNotaBtn = new JButton("Adauga nota");
    private JButton activitatiZiBtn = new JButton("Activitati din ziua curenta");
    private JButton cursuriBtn = new JButton("Cursuri predate");
    private JButton addNewCursBtn = new JButton("Adaugare curs nou");
    private JButton addCursBtn = new JButton("Adauga curs");
    private JButton afisareCursuriBtn=new JButton("Afisare Cursuri");
    private JButton inscriereCursBtn=new JButton("Inscriere Curs");
    private JButton vizualizareNoteBtn=new JButton("Vizualizare note");
    private JButton newGrupStudiuBtn=new JButton("Grup de studiu nou");
    private JButton grupuriDeStudiuBtn=new JButton("Grupuri de studiu");
    private JButton update = new JButton("Update");
    private JButton addActivitate = new JButton("Add");


    WebSinu2View (WebSinu2Model model) {
        this.model = model;
        this.init();
    }

    public void init(){
        JPanel panelUser = new JPanel();
        JPanel panelPass = new JPanel();
        JPanel panelBtn = new JPanel();
        JLabel user = new JLabel("Username: ");
        JLabel pass = new JLabel("Parola: ");
        JPanel p = new JPanel();

        tfuser.setColumns(30);
        tfpass.setColumns(30);
        panelUser.add(user);
        panelUser.add(tfuser);
        panelPass.add(pass);
        panelPass.add(tfpass);
        panelBtn.add(logIn);
        panelBtn.setLayout(new BoxLayout(panelBtn, 1));
        p.add(panelUser);
        p.add(panelPass);
        p.add(panelBtn);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        this.setContentPane(p);
        this.pack();
        this.setTitle("Proiect Laszlo Bogdan si Serban Sebastian");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public void frameIncorectPass(){
        JLabel errorMsg = new JLabel("Parola incorecta");
        JPanel p = new JPanel();

        p.add(errorMsg);
        p.add(rtrBtn);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        this.setContentPane(p);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public void conectareOK(Integer utilizator){
        switch(utilizator) {
            case -1: this.superAdmin();
                    break;
            case  0: this.admin();
                    break;
            case  1: this.profesor();
                    break;
            default: this.student();
        }
    }

    public void superAdmin(){
        JLabel ltext = new JLabel("Care este operatia pe care doresti sa o realizezi?");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel content = new JPanel();

        p1.add(ltext);
        p2.add(newUser);
        p2.add(searchUser);
        p2.add(deleteUser);
        p2.setLayout(new FlowLayout());
        p3.add(logOut);

        content.add(p1);
        content.add(p2);
        content.add(p3);

        content.setLayout(new BoxLayout(content, 1));
        this.setContentPane(content);
        this.pack();
        this.setSize(f0_w, f0_w);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void superAdminAdd(){
        JLabel lTip = new JLabel("Tip: ");
        JLabel lUser = new JLabel("Username: ");
        JLabel lPas = new JLabel("Parola: ");
        JLabel lNume = new JLabel("Nume: ");
        JLabel lPrenume = new JLabel("Prenume: ");
        JLabel lAdresa = new JLabel("Adresa: ");
        JLabel leMail = new JLabel("e-mail: ");
        JLabel lIBAN = new JLabel("IBAN: ");
        JLabel lNrTelefon = new JLabel("Numar Telefon: ");
        JLabel lNrContract = new JLabel("Numar Contract: ");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        tip.setText("");
        user.setText("");
        pas.setText("");
        nume.setText("");
        prenume.setText("");
        adresa.setText("");
        eMail.setText("");
        IBAN.setText("");
        nrTelefon.setText("");
        nrContract.setText("");

        p1.add(lTip);
        p1.add(tip);
        p1.add(lUser);
        p1.add(user);
        p1.add(lPas);
        p1.add(pas);
        p1.add(lNume);
        p1.add(nume);
        p1.add(lPrenume);
        p1.add(prenume);
        p1.add(lAdresa);
        p1.add(adresa);
        p1.add(leMail);
        p1.add(eMail);
        p1.add(lIBAN);
        p1.add(IBAN);
        p1.add(lNrTelefon);
        p1.add(nrTelefon);
        p1.add(lNrContract);
        p1.add(nrContract);
        p1.setLayout(new BoxLayout(p1,1));
        p2.add(insertUser);
        p2.add(back);
        JPanel p=new JPanel();
        p.add(p1);
        p.add(p2);

        this.setContentPane(p);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f1_w, f1_h);
    }

    public void SuperAdminSrc(){
        JLabel l1 = new JLabel("Username: ");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel content = new JPanel();

        p1.add(l1);
        p1.add(tfusername);
        p2.add(srcUser);
        p2.add(back);

        content.add(p1);
        content.add(p2);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f1_w, f1_h);
    }

    public void superAdminDelete(){
        JLabel l1 = new JLabel("Username: ");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel content = new JPanel();

        p1.add(l1);
        p1.add(tfusername);
        p2.add(delUser);
        p2.add(back);

        content.add(p1);
        content.add(p2);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f1_w, f1_h);
    }

    public void SearchEroare(ResultSet rs){
        try{
            rs.next();
            JLabel lTip = new JLabel("Tip: " + rs.getString("tip"));
            JLabel lUser = new JLabel("Username: " + rs.getString("username"));
            JLabel lPas = new JLabel("Parola: " + rs.getString("parola"));
            JLabel lNume = new JLabel("Nume: " + rs.getString("nume"));
            JLabel lPrenume = new JLabel("Prenume: " + rs.getString("prenume"));
            JLabel lAdresa = new JLabel("Adresa: " + rs.getString("adresa"));
            JLabel leMail = new JLabel("e-mail: " + rs.getString("email"));
            JLabel lIBAN = new JLabel("IBAN: " + rs.getString("IBAN"));
            JLabel lNrTelefon = new JLabel("Numar Telefon: " + rs.getString("nrTelefon"));
            JLabel lNrContract = new JLabel("Numar Contract: " + rs.getString("nrContract"));

            JPanel p1 = new JPanel();
            p1.setLayout(new GridLayout(0, 1));
            JPanel p2 = new JPanel();
            JPanel content = new JPanel();

            p1.add(lUser);
            p1.add(lPas);
            p1.add(lTip);
            p1.add(lNume);
            p1.add(lPrenume);
            p1.add(lAdresa);
            p1.add(lNrTelefon);
            p1.add(lIBAN);
            p1.add(leMail);
            p1.add(lNrContract);

            p2.add(back);

            content.add(p1);
            content.add(p2);
            content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

            this.setContentPane(content);
            this.pack();
            this.setSize(f1_w, f1_h);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }catch (SQLException sqle1){
            JLabel l1 = new JLabel("Utilizatorul nu exista");
            JPanel p1 = new JPanel();

            p1.add(l1);
            p1.add(back);

            p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

            this.setContentPane(p1);
            this.pack();
            this.setSize(f0_w, f0_h);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public void admin(){
        this.superAdmin();
    }
    public void student(){
        JPanel jpanel=new JPanel();
        jpanel.add(datePersonaleBtn);
        jpanel.add(afisareCursuriBtn);
        jpanel.add(inscriereCursBtn);
        jpanel.add(vizualizareNoteBtn);
        jpanel.add(activitatiZiBtn);
        jpanel.add(newGrupStudiuBtn);
        jpanel.add(grupuriDeStudiuBtn);
        jpanel.add(logOut);

        jpanel.setLayout(new BoxLayout(jpanel,1));
        this.setContentPane(jpanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }
    public void profesor(){

        JPanel jpanel=new JPanel();

        jpanel.add(datePersonaleBtn);
        jpanel.add(addNewCursBtn);
        jpanel.add(programareActBtn);
        jpanel.add(procenteBtn);
        jpanel.add(afisCatBtn);
        jpanel.add(addNotaBtn);
        jpanel.add(activitatiZiBtn);
        jpanel.add(cursuriBtn);
        jpanel.add(logOut);

        jpanel.setLayout(new BoxLayout(jpanel,1));
        this.setContentPane(jpanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public void programareActivitate(){
        JLabel l1 = new JLabel("ID Activitate: ");
        JLabel l2 = new JLabel("ID Curs: ");
        JLabel l3 = new JLabel("Interval orar: ");
        JLabel l4 = new JLabel("Data activitatii: ");
        JLabel l5 = new JLabel("Deadline: ");
        JLabel l6 = new JLabel("Materie: ");
        JLabel l7 = new JLabel("Numar minim de participanti: ");
        JLabel l8 = new JLabel("Numar maxim de participanti: ");
        JLabel l9 = new JLabel("ID Profesor: ");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel content = new JPanel();

        p1.add(l1);
        p1.add(idActivitate);
        p1.add(l2);
        p1.add(idCurs);
        p1.add(l3);
        p1.add(intervalOrar);
        p1.add(l4);
        p1.add(dataActivitate);
        p1.add(l5);
        p1.add(deadline);
        p1.add(l6);
        p1.add(materie);
        p1.add(l7);
        p1.add(nrMinimPart);
        p1.add(l8);
        p1.add(nrMaximPart);
        p1.add(l9);
        p1.add(idProfesor);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        p2.add(addActivitate);
        p2.add(back);

        content.add(p1);
        content.add(p2);

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public void addNewCurs(){
        JLabel l = new JLabel("ID Curs: ");
        JLabel l1 = new JLabel("Materie: ");
        JLabel l2 = new JLabel("Activitati: ");
        JLabel l3 = new JLabel("Numar Ore: ");
        JLabel l4 = new JLabel("Pondere Laborator: ");
        JLabel l5 = new JLabel("Pondere Seminar: ");
        JLabel l6 = new JLabel("Pondere Examen: ");
        JLabel l7 = new JLabel("ID Profesor: ");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel content = new JPanel();

        p1.add(l);
        p1.add(idCurs);
        p1.add(l1);
        p1.add(materie);
        p1.add(l2);
        p1.add(activitati);
        p1.add(l3);
        p1.add(nrOre);
        p1.add(l4);
        p1.add(pondereLab);
        p1.add(l5);
        p1.add(pondereSeminar);
        p1.add(l6);
        p1.add(pondereCurs);
        p1.add(l7);
        p1.add(idProfesor);

        p2.add(addCursBtn);
        p2.add(back);

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        content.add(p1);
        content.add(p2);

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public void impartireProcentuala(){
        JLabel l = new JLabel("ID curs: ");
        JLabel l1 = new JLabel("Pondere laborator: ");
        JLabel l2 = new JLabel("Pondere seminar: ");
        JLabel l3 = new JLabel("Pondere curs: ");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel content = new JPanel();

        p1.add(l);
        p1.add(idCurs);
        p1.add(l1);
        p1.add(pondereLab);
        p1.add(l2);
        p1.add(pondereSeminar);
        p1.add(l3);
        p1.add(pondereCurs);

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));

        p2.add(update);
        p2.add(back);

        content.add(p1);
        content.add(p2);

        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public void datePersonale(String nume, String prenume, String cnp, String adresa, String telefon, String iban, String email, String contract){
        JLabel l1 = new JLabel("Nume: " + nume);
        JLabel l2 = new JLabel("Prenume " + prenume);
        JLabel l3 = new JLabel("CNP: " + cnp);
        JLabel l4 = new JLabel("Adresa: " + adresa);
        JLabel l5 = new JLabel("Numar de telefon: " + telefon);
        JLabel l6 = new JLabel("e-Mail: " + email);
        JLabel l7 = new JLabel("IBAN: " + iban);
        JLabel l8 = new JLabel("Numar Contract: " + contract);

        JPanel content = new JPanel();

        content.add(l1);
        content.add(l2);
        content.add(l3);
        content.add(l4);
        content.add(l5);
        content.add(l6);
        content.add(l7);
        content.add(l8);
        content.add(back);

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        this.setContentPane(content);
        this.pack();
        this.setSize(f1_w, f1_h);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void utilizatorInexistent(){
        JLabel errorMsg = new JLabel("Utilizator inexistent");
        JPanel p = new JPanel();

        p.add(errorMsg);
        p.add(rtrBtn);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        this.setContentPane(p);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(f0_w, f0_h);
    }

    public String getUsername(){
        return this.tfuser.getText();
    }

    public String getPassword(){
        return this.tfpass.getText();
    }

    public void addRetryBtn(ActionListener click){
        this.rtrBtn.addActionListener(click);
    }

    public void addLogInBtn(ActionListener click){
        this.logIn.addActionListener(click);
    }

    public void addLogOutBtn(ActionListener click){
        this.logOut.addActionListener(click);
    }

    public void addInputBtn(ActionListener click){
        this.insertUser.addActionListener(click);
    }

    public void addNewUserBtn(ActionListener click){
        this.newUser.addActionListener(click);
    }

    public void addNewDeleteBtn(ActionListener click){
        this.deleteUser.addActionListener(click);
    }

    public void addDeleteBtn(ActionListener click){
        this.delUser.addActionListener(click);
    }

    public void addNewSearchBtn(ActionListener click){
        this.searchUser.addActionListener(click);
    }

    public void addSrcBtn(ActionListener click){
        this.srcUser.addActionListener(click);
    }

    public void addBackBtn(ActionListener click){
        this.back.addActionListener(click);
    }

    public void addDatePersonaleBtn(ActionListener click){
        this.datePersonaleBtn.addActionListener(click);
    }
    public void initPasswordTxt(){
        this.tfpass.setText("");
    }

    public String getTip() {
        return this.tip.getText();
    }

    public String getUser() {
        return this.user.getText();
    }

    public String getPas() {
        return this.pas.getText();
    }

    public String getNume() {
        return this.nume.getText();
    }

    public String getPrenume() {
        return this.prenume.getText();
    }

    public String getAdresa() {
        return this.adresa.getText();
    }

    public String geteMail() {
        return this.eMail.getText();
    }

    public String getIBAN() {
        return this.IBAN.getText();
    }

    public String getNrTelefon() {
        return this.nrTelefon.getText();
    }

    public String getNrContract() {
        return this.nrContract.getText();
    }

    public String getUsrname(){
        return tfusername.getText();
    }

    public void addImpartireBtn(ActionListener click) {
        this.procenteBtn.addActionListener(click);
    }

    public String getPondereLab() {
        return pondereLab.getText();
    }

    public String getPondereSeminar() {
        return pondereSeminar.getText();
    }

    public String getPondereCurs() {
        return pondereCurs.getText();
    }

    public String getIdCurs() {
        return idCurs.getText();
    }

    public void addUpdateProcente(ActionListener click) {
        this.update.addActionListener(click);
    }

    public void addCurs(ActionListener click) {
        this.addCursBtn.addActionListener(click);
    }

    public void addNewCurs(ActionListener click){
        this.addNewCursBtn.addActionListener(click);
    }

    public String getMaterie() {
        return this.materie.getText();
    }

    public String getActivitati() {
        return this.activitati.getText();
    }

    public String getNrOre() {
        return this.nrOre.getText();
    }

    public String getIdProfesor() {
       return this.idProfesor.getText();
    }

    public void addActivitateBtn(ActionListener click){
        this.addActivitate.addActionListener(click);
    }

    public void addNewActivity(ActionListener click) {
        this.programareActBtn.addActionListener(click);
    }

    public String getIdActivitate() {
        return this.idActivitate.getText();
    }

    public String getIntervalOrar() {
        return this.intervalOrar.getText();
    }

    public String getDataAct() {
        return this.dataActivitate.getText();
    }

    public String getDeadline() {
        return this.deadline.getText();
    }

    public String getNrMinPart() {
        return this.nrMinimPart.getText();
    }

    public String getNrMaxPart() {
        return this.nrMaximPart.getText();
    }

    public void addAfisNote(ActionListener click){
        this.afisCatBtn.addActionListener(click);
    }

    public void AfisareCatalog(){

    }
}