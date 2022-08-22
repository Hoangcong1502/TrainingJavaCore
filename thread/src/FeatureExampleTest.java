import java.util.concurrent.*;

public class FeatureExampleTest {
    public static void main(String[] args) {

            CallableSample callableSample = new CallableSample();

            ExecutorService executor = Executors.newFixedThreadPool(1);
            Future<Integer> future = executor.submit(callableSample);
            System.out.println("Future Done? "+future.isDone());

        Integer result = null;
        try {
            result = future.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println("Future done?"+future.isDone()+"-result= "+result);



    }
}
