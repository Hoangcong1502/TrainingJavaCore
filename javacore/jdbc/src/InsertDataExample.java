
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataExample {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         Connection con = null;
         Statement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            System.out.println("Connect database successful!");

            statement.execute("INSERT INTO Student_CongNH(name ,age) VALUES ('Nguyen Van A',20)");
            statement.execute("INSERT INTO Student_CongNH(name ,age) VALUES ('Nguyen Van B',21)");
            statement.execute("INSERT INTO Student_CongNH(name ,age) VALUES ('Nguyen Van C',22)");

            System.out.println("success!");
        } finally {
            statement.close();
            con.close();
        }
    }

}
