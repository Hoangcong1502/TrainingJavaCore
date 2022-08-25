import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample2 {
    public static void main(String[] args) {
        List<String> listOfString = new LinkedList<>(Arrays.asList("Java","C#"));

        listOfString.forEach(value -> {
            System.out.println(value);
        });
    }
}
