import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String DB_URl = "jdbc:sqlserver://localhost:1433;" +
                                    "databaseName=ManageTourist;" +
                                    "integratedSecurity=true;" +
                                    "encrypt=false";
    private static String Username = "sa";
    private static String Password = "abcd1234";


    public static Connection getConnect(){
        try{
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Connected success");
            return DriverManager.getConnection(DB_URl, Username, Password);
//        }catch (ClassNotFoundException ex) {
//            System.out.println("Không load được driver" + ex);
        } catch (SQLException ex) {
            System.out.println("Không kết nối được" + ex);
        }
        return null;
    }
}
