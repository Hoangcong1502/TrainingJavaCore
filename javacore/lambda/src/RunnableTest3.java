public class RunnableTest3 {
    public static void main(String[] args) {
        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " say hello");
                    System.out.println("1 + 1 =" + (1+1));
                }
        ).start();
    }
}
