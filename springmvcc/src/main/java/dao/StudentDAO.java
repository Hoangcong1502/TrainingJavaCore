package dao;


import model.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentDAO{
    public void setDataSource();
    public void insert(Student student);
    public void update(Student student);
    public void delete(Integer id);
    public void createTableIfNotExist();
    public List<Student> listStudent();
    public Student findById(Integer id);
}

