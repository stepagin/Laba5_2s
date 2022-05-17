package ConsoleApplication.readers.simpleReaders.enumerable;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;
import ConsoleApplication.readers.ValueReader;
import ConsoleApplication.readers.simpleReaders.SimpleValueReader;

public abstract class EnumReader<T extends Enum<T>> extends SimpleValueReader<T> {

    protected EnumReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected T parse(String argument) throws ValueFormatException {
        try {
            return valueOf(argument);
        } catch (IllegalArgumentException e) {
            throw new ValueFormatException("Данное значение не определено. " + getFieldNames());
        } catch (NullPointerException e) {
            throw new ValueFormatException("Пустое значение недопустимо. " + getFieldNames());
        } catch (Exception e) {
            throw new ValueFormatException("Некорректное значение. " + getFieldNames());
        }
    }

    private String getFieldNames() {
        StringBuilder sb = new StringBuilder("Доступные значния: ");
        for (T value : getEnumValues()) {
            sb.append(value.toString()).append(" ");
        }
        return sb.toString();
    }

    abstract T[] getEnumValues();

    abstract  T valueOf(String name);

}
