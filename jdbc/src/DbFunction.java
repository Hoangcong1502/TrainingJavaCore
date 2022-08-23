
import java.sql.*;

public class DbFunction {
    public static void getAge(String name, int[] ages) throws SQLException {
        Connection con = null;
        Statement statement = null;

        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(AGE) FROM Student_CongNH WHERE NAME LIKE '%" + name + "%'");
            ages[0] = rs.next() ? rs.getInt(1):-1;
        }finally {
            statement.close();
            con.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        int[] ages = new int[1];
        getAge("Thi Z",ages);
        System.out.println(ages[0]);
    }

}
