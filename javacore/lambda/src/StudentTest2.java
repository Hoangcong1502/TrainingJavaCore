import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTest2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23,"Tran Van A"));
        students.add(new Student(34,"Tran Van B"));
        students.add(new Student(15,"Tran Van C"));
        students.add(new Student(46,"Tran Van D"));

        Collections.sort(students,
                (Student student1,Student student2)-> student1.getAge() - student2.getAge());
        students.forEach(student -> System.out.println(student));
    }
}
