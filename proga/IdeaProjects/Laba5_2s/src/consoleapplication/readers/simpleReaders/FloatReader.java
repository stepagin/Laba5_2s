package consoleapplication.readers.simpleReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueFormatException;

/**
 * Класс, считывающий значение типа Float
 */
public class FloatReader extends NumberReader<Float> {

    public FloatReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager, false);
    }

    @Override
    protected Float parseValue(String argument) throws ValueFormatException {
        try {
            return Float.parseFloat(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа");
        }
    }

    @Override
    protected int compareValues(Float t1, Float t2) {
        return t1.compareTo(t2);
    }
}
