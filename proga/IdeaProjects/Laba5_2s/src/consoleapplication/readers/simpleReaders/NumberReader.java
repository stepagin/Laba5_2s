package consoleapplication.readers.simpleReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.*;

/**
 * Класс для определения правил считывания числовых данных
 * @param <T> тип числового значения
 */
public abstract class NumberReader<T extends Number> extends SimpleValueReader<T>{
    T lowerBound = null;

    protected NumberReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    public NumberReader(InputManager inputManager, OutputManager outputManager) {
        this(inputManager, outputManager, true);
    }

    @Override
    protected T parse(String argument) throws ValueFormatException {
        T result = parseValue(argument);
        if (lowerBound != null && compareValues(result, lowerBound) < 1){
            throw new ValueFormatException("Значение поля должно быть не меньше " + lowerBound.toString());
        }
        return result;
    }

    protected abstract int compareValues(T t1, T t2);

    protected abstract T parseValue(String argument) throws ValueFormatException;

    public NumberReader<T> setLowerBound(T lowerBound) {
        this.lowerBound = lowerBound;
        return this;
    }
}
