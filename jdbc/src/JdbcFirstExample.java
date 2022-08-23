
import java.sql.*;

public class JdbcFirstExample {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
         Connection con = null;
         Statement statement = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            System.out.println("Connect database successful!");

            String sql = "create table Student_CongNH(\n" +
                    "    id int primary key,\n" +
                    "    genereted int unique ,\n" +
                    "    name varchar (1000),\n" +
                    "    age int default (20)\n" +
                    ")";
            System.out.println(statement.execute(sql));

        } finally {
            statement.close();
            con.close();
        }
    }

}
