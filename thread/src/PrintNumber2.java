public class PrintNumber2 implements Runnable{
    private Integer number = new Integer(1);

    public void run() {
        Thread current = Thread.currentThread();
        while (number < 30){
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

    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread1 = new Thread(number);
        thread1.setName("FSoft_Thread 1");
        thread1.start();

        Thread thread2 = new Thread(number);
        thread2.setName("FSoft_Thread 2");
        thread2.start();

    }
}
