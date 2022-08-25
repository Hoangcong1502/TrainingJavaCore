import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23,"Tran Van A"));
        students.add(new Student(34,"Tran Van B"));
        students.add(new Student(15,"Tran Van C"));
        students.add(new Student(46,"Tran Van D"));

        Stream<Student> stream = students.stream().filter(student -> student.getAge()>=30);
        stream.forEach(student -> System.out.println(student));
    }
}
