package springtraining.unit1;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean
 {
    String message;

    private List<JavaClazz> clazzes;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage(){
        System.out.println("Your Message: "+message);
    }

     public HelloClazz(){
         message="From constructor: Say hello everyone!";
     }

    private void initMessage(){
        System.out.println("Calling init method...");
        message="From init method: Say hello bean!";
    }

    private void relase(){
        if(message==null){
            System.out.println("Message is null");
        }
    }

    public HelloClazz(int person){
        message="From constructor: Say hello to "+person+" person(s)!";
    }

    public HelloClazz(HelloClazz clazz){
        message=clazz.message;
    }

    @Override
    public void destroy() throws Exception {
        if(message==null){
            System.out.println("Message is null");
        }
    }


     public List<JavaClazz> getClazzes() {
         return clazzes;
     }

     public void setClazzes(List<JavaClazz> clazzes) {
         this.clazzes = clazzes;
     }
 }
