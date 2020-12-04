import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
        private static final String url = "jdbc:mysql://localhost/university?autoReconnect=true&useSSL=false";
        private static final String username = "root";
        private static final String password = "42249031";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url,username,password);
        }

    }


