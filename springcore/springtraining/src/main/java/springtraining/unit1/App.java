package springtraining.unit1;

import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.start();

        HelloClazz helloClazz1 = (HelloClazz) context.getBean("helloJavaClazz");
        helloClazz1.printMessage();
        System.out.println(helloClazz1);

        HelloClazz helloClazz2 = (HelloClazz) context.getBean("helloJavaClazz");
        helloClazz2.printMessage();
        System.out.println(helloClazz2);

        context.registerShutdownHook();

        HelloWorld helloWorld1= (HelloWorld) context.getBean("helloWorld");
        helloWorld1.sayHello();


        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        System.out.println("- Map implement is "+clazz.getStudents().getClass());
        System.out.println("- There are "+clazz.getStudents().size()+" in the class");

        JavaClazz clazz1 = (JavaClazz) context.getBean("helloJavaClazz");
        System.out.println("Total classes is "+clazz.getClass());

    }
}
