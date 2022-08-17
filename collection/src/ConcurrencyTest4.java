import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyTest4 {
    //remove with remove if
    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<Integer>();
        Collections.addAll(listOfInteger,1,3,4,2,3,6,3,3,8);
        System.out.println("Before remove: size of list =" + listOfInteger.size());

        listOfInteger.removeIf(item ->{
            return item ==3;
        });
        System.out.println("After remove: size of list =" + listOfInteger.size());
    }
}
