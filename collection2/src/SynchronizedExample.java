
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SynchronizedExample {
    static void addData(List<Integer> list){
        IntStream.range(0,1000).forEach(index->{
            try{
                list.add(index);
            }catch(Exception e){
                System.out.println(e.toString());
            }
        });
    }

    public static void main(String[] args) {
        ConcurrencyExample con = new ConcurrencyExample();
        List<List<Integer>> values = new ArrayList<>();
        try {
            for(int i=0;i<10;i++){
                List<Integer> list = new ArrayList<>();
                new Thread(()->con.addData(list)).start();
                new Thread(()->con.printData(list)).start();
                values.add(list);
            }
            Thread.sleep(5*1000);
            values.forEach(list-> System.out.println("number items of list: "+list.size()));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
