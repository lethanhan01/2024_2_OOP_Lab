package hust.soict.hedspi.aims.exception;

public class CartFullException extends Exception {
    public CartFullException() {
    }
    public CartFullException(String message) {
        super(message);
    }
    public CartFullException(Throwable cause) {
        super(cause);
    }
    public CartFullException(String message, Throwable cause) {
        super(message, cause);
    }
    public CartFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}