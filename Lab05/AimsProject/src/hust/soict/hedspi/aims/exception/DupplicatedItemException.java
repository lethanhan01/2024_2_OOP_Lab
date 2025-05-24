package hust.soict.hedspi.aims.exception;

public class DupplicatedItemException extends Exception {
    public DupplicatedItemException() {
    }
    public DupplicatedItemException(String message) {
        super(message);
    }
    public DupplicatedItemException(Throwable cause) {
        super(cause);
    }
    public DupplicatedItemException(String message, Throwable cause) {
        super(message, cause);
    }
    public DupplicatedItemException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}