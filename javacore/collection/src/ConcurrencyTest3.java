import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ConcurrencyTest3 {
    //remove with iterator
    public static void main(String[] args) {
        List<Integer> listOfInteger = new ArrayList<Integer>();
        Collections.addAll(listOfInteger,1,3,4,2,3,6,3,3,8);
        System.out.println("Before remove: size of list =" + listOfInteger.size());
        Iterator<Integer>  iterator = listOfInteger.iterator();

        while (iterator.hasNext()){
            if (iterator.next()==3){
                iterator.remove();
            }
        }
        System.out.println("After remove: size of list =" + listOfInteger.size());
    }
}
