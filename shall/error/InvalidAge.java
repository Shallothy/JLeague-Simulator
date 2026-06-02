package shall.error;

public class InvalidAge extends RuntimeException {
    public InvalidAge(String message) {
        super(message);
    }
}
