package consoleapplication.readers.complexReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueFormatException;
import consoleapplication.readers.ValueReader;


/**
 * Класс для определения правил считывания значений, состоящих из нескольких простых.
 */
public abstract class ComplexValueReader<T> extends ValueReader<T> {
    public ComplexValueReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager);
    }

    public ComplexValueReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    public T read(String fieldName) {
        return super.read(fieldName);
    }

    @Override
    protected T parse(String argument) throws ValueFormatException {
        return readFields();
    }

    protected abstract T readFields();

    protected abstract String getTypeName();

    @Override
    protected T readAttempt() throws ValueFormatException {
        return parse("");
    }
}
