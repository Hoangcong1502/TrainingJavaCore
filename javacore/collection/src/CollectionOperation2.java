import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation2 {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>();

        Collector<Integer,?, IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);
        IntSummaryStatistics summaryStatistics = listOfIntegers.stream().collect(collector);

        System.out.println("total = " + summaryStatistics.getSum());
        System.out.println("overage = " + summaryStatistics.getAverage());

        int sum = listOfIntegers.stream().reduce(0,(x,y) -> x+y);

    }
}
