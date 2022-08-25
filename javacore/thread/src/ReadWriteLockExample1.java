
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample1 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();

        Runnable readTask =()->{
            System.out.println("start reading");
            try {
                System.out.println(map.get("foo"));
            } finally {
                System.out.println("end reading");
            }
        };
        executor.submit((readTask));
        executor.submit((readTask));

    }
}
