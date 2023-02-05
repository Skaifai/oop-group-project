import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseOperations {
    Connection conn = null;
    public void connectToDB(Properties props) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/clothes", props);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
