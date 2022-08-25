import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrencyTest2 {
    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<Integer>();
        Collections.addAll(listOfInteger,1,3,4,2,3,6,3,3,8);

        System.out.println("Before remove: size of list =" + listOfInteger.size());
        listOfInteger.forEach(v->{
            if (v==3){
                listOfInteger.remove(v);
            }
        });
        System.out.println("After remove: size of list =" + listOfInteger.size());
    }
}
