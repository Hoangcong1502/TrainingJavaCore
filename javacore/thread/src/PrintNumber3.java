public class PrintNumber3 {
    private Integer number = new Integer(1);

    public void run() {
        Thread current = Thread.currentThread();
        synchronized (number) {
            while (number < 30) {
                number++;
                System.out.println(current.getName() + "number is \"" + number + "\"");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(current.getName() + " is stoped!");
    }

}
