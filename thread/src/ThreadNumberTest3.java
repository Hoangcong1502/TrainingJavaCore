public class ThreadNumberTest3 {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("Fsoft_thread");
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread say hello");
        System.out.println("Main Thread say goodbye");
    }
}
