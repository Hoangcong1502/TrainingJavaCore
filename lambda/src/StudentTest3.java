import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest3 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23,"Tran Van A"));
        students.add(new Student(34,"Tran Van B"));
        students.add(new Student(15,"Tran Van C"));
        students.add(new Student(46,"Tran Van D"));

        Stream<Student> stream = students.stream().sorted(
                (student1,student2)-> student1.getAge() - student2.getAge());

        System.out.println(stream);

        Comparator<Student> comparator = (student1,student2)->student1.getAge() - student2.getAge();

        Stream<Student> stream1 = students.stream().sorted(comparator);
        stream1.forEach(student -> System.out.println(student));

        System.out.println("Max is" + students.stream().max(comparator));
        int sum = students.stream().mapToInt(Student::getAge).sum();
        System.out.println("Average of age is" + sum/students.size());

        students.parallelStream().forEach((it)-> System.out.println(Thread.currentThread().getName() + "hello"+ it.getName()));
    }
}
