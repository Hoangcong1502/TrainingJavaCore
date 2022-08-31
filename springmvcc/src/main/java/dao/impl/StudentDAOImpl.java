package dao.impl;



import dao.StudentDAO;
import model.Student;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class StudentDAOImpl implements StudentDAO, DisposableBean {
    @Autowired
    StudentDAO studentDAO;
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Override
    public void setDataSource(){

    }

    @Override
    public void createTableIfNotExist(){

    }

    @Override
    public List<Student> listStudent() {
        String sql="select * from congnh_students order by id asc";
        return jdbcTemplate.query(sql,new StudentRowMapper());
    }

    @Override
    public Student findById(Integer id) {
        String sql="select*from congnh_students where id="+id;
        return jdbcTemplate.queryForObject(sql,new StudentRowMapper());
    }

    @Override
    public void insert(Student student) {
            jdbcTemplate.update("insert into congnh_students(name,age)" +
                    "values (?,?)",student.getName(),student.getAge());
            System.out.println("Created record name = "+student.getName());
    }

    @Override
    public void update(Student student) {
            jdbcTemplate.update("update congnh_students set name=? where id=?",
                    student.getName(),student.getId());
    }
    @Override
    public void delete(Integer id) {
        jdbcTemplate.update("delete from congnh_students where id = " + id);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public StudentDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl");
    }
    private final static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }catch (Exception e){
                return null;
            }
        }
    }
}
