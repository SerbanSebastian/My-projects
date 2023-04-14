import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebSinu2Model {
    private Connection connection = null;
    private Integer utilizator_tip; // {-1 = "super-admin", 0 = "administrator, 1 = "profesor", 2 = "student"}
    ResultSet rs = null;
    WebSinu2Model() throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String pass = "@Lore20030911.";
        Statement database;
        try{
            this.connection = DriverManager.getConnection(url, user, pass);
        }catch(Exception e){
            System.out.println(e);
        }
        database = connection.createStatement();
        database.execute("USE websinu2");
    }

    public String verifUsrPass(String user,String password) throws SQLException {
        Statement select= connection.createStatement();
        select.execute("SELECT * FROM utilizator WHERE username = '" + user + "'");
        rs = select.getResultSet();
        rs.next();
        try {
            String parola = rs.getString("parola");
            if (parola.equals(password)) {
                return "conectare la cont reusita";
            }
            else {
                return "parola incorecta";
            }
        }catch(SQLException sqlex){
                return "utilizatorul nu exista";
        }
    }

    public void discoverUtilizator(String user) throws SQLException {
        Statement select = connection.createStatement();
        ResultSet rs;

        select.execute("SELECT * FROM utilizator WHERE username = '" + user + "'");

        rs = select.getResultSet();

        rs.next();
        this.utilizator_tip = rs.getInt("tip");
    }

    public void insertUser(String user,
                           String pass,
                           String tip,
                           String nume,
                           String prenume,
                           String adresa,
                           String nrTel,
                           String IBAN,
                           String eMail,
                           String nrContract) throws SQLException {
        Statement insert = connection.createStatement();
        insert.executeUpdate("INSERT INTO Utilizator(username, parola, nume, prenume, adresa, nrTelefon, IBAN, email, nrContract,tip) values " +
                "( '" + user + "', '" + pass + "', '" + nume + "', '" + prenume + "', '" + adresa + "', '" + nrTel + "', '" + IBAN + "', '" + eMail + "', " + nrContract + ", " + tip + ");");

    }

    public ResultSet searchUser(String user) throws SQLException {
        Statement select = connection.createStatement();

        select.execute("SELECT * from utilizator where username = '" + user + "'");

        return select.getResultSet();
    }

    public void deleteUser(String user) throws SQLException{
        Statement delete = connection.createStatement();

        delete.executeUpdate("DELETE FROM utilizator WHERE username = '" + user + "'");
    }

    public void datePersonale(String user, WebSinu2View view)throws SQLException{
        Statement call = connection.createStatement();
        ResultSet result;

        if(this.utilizator_tip.equals(1)){
            call.executeUpdate("CALL date_personale_profesor()");
            result = call.getResultSet();
            while(result.next()){
                if(result.getString("username").equals(user))
                    break;
            }
            view.datePersonale(result.getString("nume"), result.getString("prenume"), result.getString("CNP"), result.getString("adresa"),
                    result.getString("nrTelefon"), result.getString("IBAN"), result.getString("email"), result.getString("nrContract"));
        }
        else{
            if(this.utilizator_tip.equals(2)){
                call.execute("CALL date_personale_student()");
                result = call.getResultSet();
                while(result.next()){
                    if(result.getString("username").equals(user))
                        break;
                }
                view.datePersonale(result.getString("nume"), result.getString("prenume"), result.getString("CNP"), result.getString("adresa"),
                        result.getString("nrTelefon"), result.getString("IBAN"), result.getString("email"), result.getString("nrContract"));
            }
            else{
                System.out.println("Utilizatorul nu are acces la aceasta operatie");
            }
        }
    }

    public void updateProcente(String idCurs, Float pl, Float ps, Float pc) throws SQLException {
        Statement update = connection.createStatement();
        update.execute("UPDATE curs SET pondereLab = " + pl + ", pondereSeminar = " + ps + ", pondereCurs = " + pc + "WHERE idCurs = " + idCurs);
    }

    public void addCurs(String idCurs,
                        String materie, String activitati,
                        String nrOre,
                        String pondereLab,
                        String pondereSeminar,
                        String pondereCurs,
                        String idProfesor) throws SQLException {
        Statement call = connection.createStatement();
        String sql = "call add_curs(" + idCurs + ", '" + materie + "', '" + activitati +"', " + nrOre + ", " + pondereLab + ", " + pondereSeminar + ", " + pondereCurs + ", '" + idProfesor + "')";

        call.execute(sql);
    }
    public void addActivitate(String idCurs,
                              String idActivitate,
                              String intervalOrar,
                              String dataAct,
                              String nrMinimPart,
                              String deadline,
                              String materie,
                              String nrMaximPart,
                              String idProfesor) throws SQLException {
        String sql = "CALL add_activitate(" + idActivitate + ", " + idCurs + ", " + intervalOrar + ", '" + dataAct + "', '" + deadline + "', " + nrMinimPart + ", " + nrMaximPart + ", '" + materie + "', '" + idProfesor + "')";
        Statement call = connection.createStatement();
        call.execute(sql);
    }
    public Integer getUtilizator_tip(){
        return this.utilizator_tip;
    }
}