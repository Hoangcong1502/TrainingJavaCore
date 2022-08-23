
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample3 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable readTask =()->{
            System.out.println("start reading");
            lock.readLock();
            try {
                System.out.println(map.get("foo"));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("End reading");
                lock.readLock().unlock();
            }
        };
    }
}
