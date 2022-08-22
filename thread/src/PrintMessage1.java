import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage1 implements Runnable{
    private String message=null;

    public PrintMessage1(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        String[] elements = message.split(" ");
        Arrays.stream(elements).forEach(ele->{
            System.out.println(Thread.currentThread().getName() + "print "+ ele);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }
}

