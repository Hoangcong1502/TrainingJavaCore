import java.util.*;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new  ArrayList<>(Arrays.asList(4,7,1,3,8,9,2,6,10));
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(listOfIntegers,comparator);

        listOfIntegers.stream().filter(v->v>5).forEach(v->{
            System.out.println(v);
        });

    }
}
