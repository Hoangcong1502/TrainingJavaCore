public class ThreadTest {

    public static void main(String[] args) {
        PrintMessage message = new PrintMessage("Say hello to everyone");
        new Thread(message).start();
    }
}
