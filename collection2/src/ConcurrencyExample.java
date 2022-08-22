
import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {
    public void addData(List<Integer> addData){
        while(true){
            try {
                int random = (int)(Math.random()*100);
                addData.add(random);
                System.out.println("add new data"+random);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printData(List<Integer> data){
        while(true){
            try {
                System.out.println("-----------------");
                data.forEach(value-> System.out.println("value="+value));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {

    }
}
