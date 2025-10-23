import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/expense_tracker";
            String username = "root";
            String password = "12345";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Database connected successfully!");
            System.out.println("Your setup is working!");
            
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}