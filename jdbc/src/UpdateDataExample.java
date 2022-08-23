
import java.sql.*;

public class UpdateDataExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            System.out.println("Connect database successful!");

            PreparedStatement statement = con.prepareStatement("UPDATE Student_CongNH SET NAME = ? WHERE ID = ?");
            statement.setString(1,"Le Thi Z") ;
            statement.setInt(2,2);
            statement.executeUpdate();

            System.out.println("success!");

            con.close();

    }
}
