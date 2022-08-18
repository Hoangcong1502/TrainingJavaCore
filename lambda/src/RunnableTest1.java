public class RunnableTest1 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+ " say hello");
        };
        new Thread(runnable).start();
    }
}
