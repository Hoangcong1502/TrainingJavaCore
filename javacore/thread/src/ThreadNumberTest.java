

public class ThreadNumberTest {
    public static void main(String[] args) {
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("Hanoi_Thread");
        thread.start();
        while (thread.isAlive()){
            if(number.getNumber()%10==0){
                number.setAlive(false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        //end while
    }
}
