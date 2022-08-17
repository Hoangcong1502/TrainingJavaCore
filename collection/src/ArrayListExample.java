import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String > listOfString = new ArrayList<String>();
        listOfString.add("a");
        listOfString.add("b");
        listOfString.add("c");
        listOfString.add("d");

        Collections.addAll(listOfString,args);

        for (int i = 0; i < listOfString.size();i++){
            System.out.println("Element at " + i + " is " + listOfString.get(i));
        }
    }
}
