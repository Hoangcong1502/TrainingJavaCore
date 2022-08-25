package springtraining.unit1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean(name = "bean2")
    public return_type getHelloBean(){
        HelloClass bean = new HelloClass();
        bean.message = "Xin chao lop hoc Java";
        return getHelloBean();
    }
}
