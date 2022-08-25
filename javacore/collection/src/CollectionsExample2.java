import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample2 {
    public static void main(String[] args) {
        List<String> listOfString = new ArrayList<String>();
        Collections.addAll(listOfString,"Tu","An","Hoa","Binh");
        Collections.sort(listOfString);

//        System.out.println(list);
        for (int i = 0; i < listOfString.size();i++ ){
            System.out.println(listOfString.get(i) + ",");
        }
        System.out.println("Vi tri thu " + Collections.binarySearch(listOfString,"Hoa"));
    }
}
