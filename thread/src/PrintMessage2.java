import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage2 implements Runnable{
    // Multi thread example

    private String message=null;

    public PrintMessage2(String message) {
        this.message = message;
    }
    @Override
    public synchronized void run() {
        String[] elements = message.split(" ");
        Arrays.stream(elements).forEach(ele->{
            System.out.println(Thread.currentThread().getName() + "print "+ ele);
            try {
                Thread.sleep((int)(Math.random()*3) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
    }

    public static void main(String[] args) {
        PrintMessage message = new PrintMessage("Say hello");
        new Thread(message).start();
        new Thread(message).start();

    }
}
