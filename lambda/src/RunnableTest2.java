public class RunnableTest2 {
    public static void main(String[] args) {
        new Thread(
                ()-> System.out.println(Thread.currentThread().getName()+ " say hello")
        ).start();
    }
}
