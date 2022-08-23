
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample2 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);
        Map<String,String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(()->{
            System.out.println("start writing");
            lock.writeLock().lock();
            lock.writeLock().lock();
            try{
                TimeUnit.SECONDS.sleep(3);
                map.put("foo","bar");
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();
                System.out.println("End writing");
            }
        });
    }
}
