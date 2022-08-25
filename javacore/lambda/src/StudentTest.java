import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    public static List<Student> filter(List<Student> students, Student.Filter<Student> pred){
        List<Student> listStudents = new ArrayList<>();
        for (Student student:students){
            if (pred.valid(student)){
                listStudents.add(student);
            }

        }
        return listStudents;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23,"Tran Van A"));
        students.add(new Student(34,"Tran Van B"));
        students.add(new Student(15,"Tran Van C"));
        students.add(new Student(46,"Tran Van D"));

        Student.Filter<Student> older = student -> student.getAge()>=30;
        List<Student> filtered = filter(students, older);

        for (Student student: filtered){
            System.out.println(student);
        }

    }
}
