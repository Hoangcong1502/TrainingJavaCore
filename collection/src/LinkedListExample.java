import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> listOfString = new LinkedList<>();
        for (String ele : args) {
            listOfString.add(ele);
        }

        listOfString.add("a");
        listOfString.add("b");

        Iterator<String> iterator = listOfString.iterator();
        while (iterator.hasNext()){
            System.out.println("===>" + iterator.next());
        }

    }
}
