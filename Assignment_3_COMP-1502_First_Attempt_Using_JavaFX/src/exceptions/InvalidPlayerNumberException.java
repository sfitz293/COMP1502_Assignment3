package exceptions;

public class InvalidPlayerNumberException extends Exception {
    
    // This is the unique ID for the class
    private static final long serialVersionUID = 1L;

    public InvalidPlayerNumberException(String message) {
        super(message);
    }
}