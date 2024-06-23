
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConectDataBase {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/electronicbook";
            String userName = "root";
            String pass = "";
            return DriverManager.getConnection(url, userName, pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
