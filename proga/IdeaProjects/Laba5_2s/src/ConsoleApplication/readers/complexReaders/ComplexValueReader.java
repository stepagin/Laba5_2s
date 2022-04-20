package ConsoleApplication.readers.complexReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;
import ConsoleApplication.readers.ValueReader;


/**
 * Класс для определения правил считывания сложных значений,
 * состоящих из нескольких простых.
 */
public abstract class ComplexValueReader<T> extends ValueReader<T> {
    public ComplexValueReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager);
    }

    public ComplexValueReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected T parse(String argument) throws ValueFormatException {
        if (argument.equals(getTypeName())) {
            return readFields();
        } else {
            throw new ValueFormatException("Неверный тип данных");
        }
    }

    protected abstract T readFields();

    protected abstract String getTypeName();
}
