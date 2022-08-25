public class ThreadNumberTest2 {
    // main thread exam
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("Hanoi_thread");
        thread.start();
        System.out.println("Main Thread say hello");
        System.out.println("Main Thread say goodbye");
    }
}
