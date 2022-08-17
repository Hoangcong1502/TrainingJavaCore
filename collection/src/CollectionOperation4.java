import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class CollectionOperation4 {
    public static void main(String[] args) {
        Integer value;
        List<Integer> listOfIntegers = new ArrayList<>();

        Consumer<Integer> myConsumer =  n ->{
            System.out.println("user input value = " + n);
            if (n<5){
                System.out.println("Invalid value!");
                return;
            }
            Collections.addAll(listOfIntegers,n);
            System.out.println("values:");
            listOfIntegers.forEach(x-> System.out.println(x + " - "));
        };
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please input a number");
            value = scanner.nextInt();
            myConsumer.accept(value);
            System.out.println(value);
        }
    }
}
