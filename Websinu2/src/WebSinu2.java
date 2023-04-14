import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class WebSinu2 {
    public static void main(String[] args) throws SQLException {
        WebSinu2Model model = new WebSinu2Model();
        WebSinu2View view = new WebSinu2View(model);
        WebSinu2Controller controller = new WebSinu2Controller(model, view);
        view.setVisible(true);
    }
}
