import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CollectionOperation3 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();
        Consumer<Integer> myConsumer = n ->{
            System.out.println("user input value = " + n);
            if (n<5){
                System.out.println("Invalid value!");
                return;
            }
            Collections.addAll(listOfIntegers,n);
            System.out.println("values:");
            listOfIntegers.forEach(x-> System.out.println(x + " - "));
        };
        myConsumer.accept(11);
    }
}
