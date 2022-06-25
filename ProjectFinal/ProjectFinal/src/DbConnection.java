import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String DB_URl = "jdbc:sqlserver://localhost:1433;" +
                                    "integratedSecurity=true;" +
                                    "encrypt=false";
    private static String Username = "sa";
    private static String Password = "abcd1234";


    public static void getConnect(){
        try{
            Connection connection = DriverManager.getConnection(DB_URl, Username, Password);
            if(connection != null){
                System.out.println("Database Connected");
                DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
                System.out.println("Product name: " + dm.getDatabaseProductName());
            }
            connection.close();
        } catch (SQLException e) {
            System.err.println("Cannot connect database, " + e);
        }
    }
}
