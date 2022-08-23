import com.sun.rowset.WebRowSetImpl;

import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class WebRowSetExample {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException, SQLException, IOException {
        Connection con = null;
        Statement statement = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Student_CongNH");

            File file = new File("output.xml");
            FileWriter writer = new FileWriter(file);
            WebRowSet wrs = new WebRowSetImpl() ;
            wrs.writeXml(rs,writer);

            Desktop.getDesktop().open(file);
        }finally {
            con.close();
        }
    }
}
