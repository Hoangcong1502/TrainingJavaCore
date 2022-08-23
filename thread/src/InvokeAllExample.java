import javax.xml.transform.Result;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static java.util.Arrays.stream;


public class InvokeAllExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<CallableSample> callables = Arrays.asList(new CallableSample(),new CallableSample(),new CallableSample());
        Stream stream = executor.invokeAll(callables).stream();
        Stream resultStream = stream.map(future->{
           return future.getClass();
        });

        Object[] results = resultStream.toArray(Integer[]::new);
        stream(results).forEach(System.out::println);
    }
}
