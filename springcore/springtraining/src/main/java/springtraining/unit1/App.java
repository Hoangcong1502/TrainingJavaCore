package springtraining.unit1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloClass obj = (HelloClass) context.getBean("helloJavaClazz");
        obj.printMessage();
        System.out.println(obj);

        HelloClass obj2 = (HelloClass) context.getBean("helloJavaClazz");
        obj2.printMessage();
        System.out.println(obj2 == obj2);

    }
}
