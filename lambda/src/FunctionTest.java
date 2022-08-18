import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FunctionTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Consumer<Student> c = (Student student) ->{
          if (student.getAge()>23) {
              student.setAge(23);
              students.add(student);
          }
        };

        c.accept(new Student(34,"Nguyen Van A"));

        System.out.println(students.get(0));
    }
}
