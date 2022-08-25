import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyTest {
    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<Integer>();
        Collections.addAll(listOfInteger,1,3,4,2,3,6,3,3,8);
        System.out.println("Before remove: size of list =" + listOfInteger.size());

        for (int i =0 ; i < listOfInteger.size(); i++){
            if (listOfInteger.get(i)==3){
                listOfInteger.remove(i);
            }
        }
        System.out.println("After remove: size of list ="+ listOfInteger.size());
    }
}
