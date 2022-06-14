package consoleapplication.readers.simpleReaders.enumerable;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueFormatException;
import consoleapplication.readers.simpleReaders.SimpleValueReader;

/**
 * Класс, определяющий правила считывания перечисляемых значений
 * @param <T> тип значений
 */
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
