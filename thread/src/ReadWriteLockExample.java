
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();

        executor.submit(()->{
            System.out.println("start writing");
            try{
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("foo","bar");
            } finally {
                System.out.println("end writing");
            }
        });

    }
}
