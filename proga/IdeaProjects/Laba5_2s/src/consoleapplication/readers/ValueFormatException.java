package consoleapplication.readers;

/**
 * исключение неправильного значения.
 */
public class ValueFormatException extends Exception{
    public ValueFormatException(String message){
        super(message);
    }
}
