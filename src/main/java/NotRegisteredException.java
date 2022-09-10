import java.util.NoSuchElementException;

public class NotRegisteredException extends NoSuchElementException {
    public NotRegisteredException(String msg) {
        super(msg);
    }
}
