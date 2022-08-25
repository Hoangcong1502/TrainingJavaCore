import java.util.concurrent.TimeUnit;

public class ThreadNumberTest1 {
    //Join thread example
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("Hanoi_Thread");
        thread.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (thread.isAlive()){
            if(number.getNumber()%10==0){
                number.setAlive(false);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //end while
    }
}
