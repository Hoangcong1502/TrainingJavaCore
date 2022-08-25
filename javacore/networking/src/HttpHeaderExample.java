
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class HttpHeaderExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.cooc.vn/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println("Http method " + connection.getRequestMethod());

         List<String> headers = (List<String>) connection.getHeaderFields();
        BiConsumer<String, List<String>> header = (key, values) -> {
            System.out.println("Key: " + key +" - Values: " + values);
        };
        headers.forEach((Consumer<? super String>) header);
    }
}
