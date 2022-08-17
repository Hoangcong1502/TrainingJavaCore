import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionOperation5 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        Predicate<Integer> tester = v -> v >5;
        Consumer<Integer> myConsumer = n -> listOfIntegers.add(n);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please input a number:");
            int value = scanner.nextInt();
            if (value < 0){
                break;
            }

            if (tester.test(value)){
                myConsumer.accept(value);
            }

            listOfIntegers.forEach(x-> System.out.println(x + " -"));
        }
    }
}
