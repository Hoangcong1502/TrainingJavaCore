import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    //TreeMap duy trì các phần tử theo thứ tự key tăng dần
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(3,"Nguyen Van A");
        map.put(1,"Nguyen Van B");
        map.put(2,"Nguyen Van C");
        map.put(4,"Nguyen Van D");

        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }
}
