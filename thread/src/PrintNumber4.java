public class PrintNumber4 implements Runnable {
    private Integer number = new Integer(1);

    public void run() {
        Thread current = Thread.currentThread();

            while (true) {
                number++;
                System.out.println(current.getName() + "number is \"" + number + "\"");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (number%10 ==0){
                    break;
                }
            }

        System.out.println(current.getName() + " is stoped!");
    }
}
