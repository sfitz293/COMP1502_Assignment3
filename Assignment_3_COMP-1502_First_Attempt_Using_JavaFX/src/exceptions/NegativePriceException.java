package exceptions;

public class NegativePriceException extends Exception {

    // This is the unique ID for the class
    private static final long serialVersionUID = 1L;

    public NegativePriceException(String message) {
        super(message);
    }
}