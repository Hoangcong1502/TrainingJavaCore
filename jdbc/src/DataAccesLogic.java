import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccesLogic {
    private final static Logger logger = Logger.getLogger(DataAccesLogic.class.getName());
    Connection con = null;
    CachedRowSet rowSet;

    public DataAccesLogic() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        this.con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");

        rowSet = new CachedRowSetImpl();
        rowSet.setCommand("select * from Student_CongNH");
        rowSet.execute(con);


    }
    public void disconnect(){
        try {
            if (con != null){
                con.close();
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING,e.toString());
        }
    }

    int pageSize = 10;

    List<String> loadNames(int page) throws SQLException {
        List<String> names = new ArrayList<>();
        rowSet.setPageSize(pageSize);
        int start = (page - 1) * pageSize + 1;
        if (!rowSet.absolute(start)) return names;

        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if (names.size() >= pageSize) break;
        }
        return names;
    }

    int numberOfPage() throws SQLException {
        Statement statement = null;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Student_CongNH");
            if (!rs.next()) return 0;
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if (total%pageSize != 0) totalPage++;
            return totalPage;
        }finally {
            statement.close();
        }
    }


}
