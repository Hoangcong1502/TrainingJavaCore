
public class PrintNumber1 implements Runnable{
    // Main thread

    private int number =1;

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (number < 10){
            number++;
            System.out.println(current.getName()+ "number is \"" + number + "\"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(current.getName() + " is stoped!");
    }
}
