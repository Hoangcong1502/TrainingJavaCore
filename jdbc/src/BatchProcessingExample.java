
import java.sql.*;

public class BatchProcessingExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            System.out.println("Connect database successful!");

            for (int i = 0; i < 20; i++) {
                String name = "Nguyen Van E" + i;
                int age = 10 + i;
                String sql = "insert into Student_CongNH(name,age)" +
                        "values ("+name+","+age+")";

                statement.addBatch(sql);
            }
            statement.executeBatch();

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Student_CongNH");
            if (rs.next()) System.out.println("total records = " + rs.getInt(1));
        } finally {
            statement.close();
            con.close();
        }
    }
}
