package springtraining.unit1;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    private final static Logger LOGGER = Logger.getLogger(HelloWorld.class);
    String message;

    @Autowired(required = true)
    @Qualifier("helloJavaClazz2")
    private HelloClazz clazz;

    public HelloWorld() {
    }

        public HelloClazz getClazz() {
        return clazz;
    }

    public void setClazz(HelloClazz clazz) {
        this.clazz = clazz;
    }

    public HelloWorld(String name, HelloClazz clazz){
        message="From HelloWorld constructor: "+name+":"+clazz.getMessage();
    }
    public String getMessage() {
        return message;
    }

    @Required
    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHello(){
        clazz.printMessage();
        LOGGER.info("From HelloWorld: "+message);
    }
}
