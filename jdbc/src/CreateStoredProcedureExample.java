
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStoredProcedureExample {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement statement = null;
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();

            statement.executeUpdate("CREATE PROCEDURE GETAGE(STREAM_NAME VARCHAR (255),OUT AGE INT)" +
                    "PARAMETER STYLE JAVA READS " +
                    "SQL DATA LANGUAGE JAVA EXTERNAL NAME " +
                    "'jdbc.DbFunction.getAge'"
            );
            System.out.println("done");
        } finally {
            statement.close();
            con.close();
        }
    }
}
