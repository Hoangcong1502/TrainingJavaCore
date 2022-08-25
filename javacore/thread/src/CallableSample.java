import org.w3c.dom.ranges.Range;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CallableSample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        AtomicInteger total = new AtomicInteger(0);
        Thread thread = new Thread();
        IntStream.range(0,10).forEach(number->{
            System.out.println(thread.getName()+"running"+total.addAndGet(number));
            Random random = new Random();
            LongStream longStream = random.longs(100,1000);
            long sleep = longStream.findFirst().getAsLong();
        });
        return total.get();
    }
}
