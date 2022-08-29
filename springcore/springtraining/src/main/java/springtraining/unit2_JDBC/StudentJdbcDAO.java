package springtraining.unit2_JDBC;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentJdbcDAO {
    @Autowired
    private PlatformTransactionManager transactionManager;

    public void save(String name , Integer age){
        TransactionDefinition def =new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String countQuery = "Select count(*) from congnh_students";
        try {
            int total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("before save data, total record is " + total);
            transactionManager.commit(status);

            LOGGER.info("before delete data, total record is " + total);
            String sql ="insert into congnh_students(name, age) values(?,?)";
            jdbcTemplate.update(sql, name, age);

            int total1 = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after save data, total record is " + total1);

            String countQuery2="Select count(*) from congnh_students";
            int total2 = jdbcTemplate.queryForObject(countQuery2, Integer.class);

            transactionManager.commit(status);
        } catch (DataAccessException exp) {
            transactionManager.rollback(status);

            int total = jdbcTemplate.queryForObject(countQuery, Integer.class);
            LOGGER.info("after rollback, total record is  " + total);
        }
    }

    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    @Autowired
    private DataSource dataSource;
    private String insertQuery;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(String name, int age) {
        jdbcTemplate.update(insertQuery, name, age);
        LOGGER.info("Created Record name = " + name + "Age= " + age);
    }

    private void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "congnh_students", null);
        if (rs.next()) {
            LOGGER.info("Table" + rs.getString("TABLE_NAME") + "already exists!");
            return;
        }
        String sql = "create table congnh_students (\n" +
                "    id int primary key ,\n" +
                "    name varchar (1000),\n" +
                "    age int\n" +
                ")";
        jdbcTemplate.execute(sql);
        System.out.println("success !");
    }

    public String getInsertQuery() {
        return insertQuery;
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public int totalRecord() {
        return jdbcTemplate.execute((Statement statement) -> {
            ResultSet rs = statement.executeQuery("select count(*) from congnh_students");
            int count = 0;
            while (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        });

//        return jdbcTemplate.execute(new StatementCallback<Integer>() {
//
//            @Override
//            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
//                Connection connection = dataSource.getConnection();
//                Statement statement = connection.createStatement();
//                ResultSet rs = statement.executeQuery("select count(*) from congnh_students");
//                return rs.next() ? rs.getInt(1) : 0;
//            }
//        });
    }

    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            int i = 0;
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            } catch (Exception e) {
                LOGGER.error(e, e);
                return null;
            }
        }

        ;
    }

    public List<Student> loadStudent(String name) {
        String sql = "select * from congnh_students where name like '%" + name + "%'";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    private String updateAgeByNameSQL = "update age where name = ?";

    public void updateAgeByName(String name, Integer age) {
        return;
    }

//    public void updateAgeById(int id,int age){
//        String updateAgeByNameSQL = "update va_students set age=? where id=?";
//        jdbcTemplate.update(updateAgeByNameSQL,age,id);
//    }

    public int[] add(List<Student> students) {
        List<Object[]> batch = new ArrayList<>();
        students.forEach(student -> batch.add(new Object[]{student.getName(), student.getAge()}));
        return jdbcTemplate.batchUpdate("insert into congnh_students (name,age) values (?,?)", batch);
    }
}
