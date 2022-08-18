import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionTest2 {
    public static void main(String[] args) {
        String[] names = {"Tran Van A", "Nguyen Thi B", "Nguyen Thi C", "Ta Van C"};
        Integer[] ages = {23,45,12,67};
        IntStream intStream = IntStream.rangeClosed(0, names.length - 1);
        Stream<Student> stream = intStream.mapToObj(value ->
                new Student( ages[value],names[value]));

        Consumer<Student> c = (Student student) ->{
            System.out.println(student);
        };

        Function<Student,String> jsonToFunction = (Student student)->{
            StringBuilder builder = new StringBuilder();
            builder.append("student{\n");
            builder.append("\tid:").append(student.getId()).append("\n");
            builder.append("\tage:").append(student.getAge()).append("\n");
            builder.append("\tname:").append(student.getName()).append("\n");
            builder.append("}");
            return  builder.toString();
        };

        c = (Student student)->{
            System.out.println(jsonToFunction.apply(student));
        };
        stream.forEach(c);
    }
}
