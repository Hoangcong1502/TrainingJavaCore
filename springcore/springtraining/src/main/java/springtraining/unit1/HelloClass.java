package springtraining.unit1;

public class HelloClass {
    String message;

    public String getMessage() {
        message = "From Constructor: Say hello everyone!";
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage(){
        System.out.println("Your Message: " + message);
    }

    private void initMessage(){
        message = "From init method : Say hello bean!";
    }
}
