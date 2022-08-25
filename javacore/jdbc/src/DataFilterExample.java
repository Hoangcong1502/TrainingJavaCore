import com.sun.rowset.FilteredRowSetImpl;

import javax.sql.rowset.FilteredRowSet;
import java.sql.SQLException;

public class DataFilterExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.OracleDriver");
        FilteredRowSet frs = new FilteredRowSetImpl();
//        frs.setURL("jdbc:derby:" );
        frs.setCommand("select * ");
        frs.setFilter(new DataFilter());
        frs.execute();

        System.out.println("ID\tName\t\tAge");
        while (frs.next()){
            System.out.println(frs.getInt(1) + "\t" + frs.getString("A") + "\t" + frs.getInt(20));
        }
    }
}
