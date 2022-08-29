package springtraining.unit2_JDBC;


//import com.example.SpringCoreApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    public static void main(String[] args) {

        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
            LOGGER.info("created bean "+ jdbc);

            List<Student> students= new ArrayList<>();
            LOGGER.info("Total Student = " + jdbc.totalRecord());
            students.add(new Student("Tran Thi A", 17));
            students.add(new Student("Le Van L", 20));
            students.add(new Student("Phan Thi Z", 25));

            int []values = jdbc.add(students);

            for (int i =0;i<values.length;i++){
                LOGGER.info("Add record " + i + ":" + (values[i]==0? "failed":"success"));
            }

            LOGGER.info("Total Student = " + jdbc.totalRecord());


            jdbc.insert("Tran Van A",24);

            LOGGER.info("Total students is " + jdbc.totalRecord());

            jdbc.loadStudent("A").forEach(student -> {
                LOGGER.info(student);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
