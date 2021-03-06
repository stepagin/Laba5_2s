package consoleapplication.readers.simpleReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueFormatException;

/**
 * Класс, считывающий значение типа Integer
 */
public class IntegerReader extends NumberReader<Integer>{

    public IntegerReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    public IntegerReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager);
    }

    @Override
    protected int compareValues(Integer t1, Integer t2) {
        return t1.compareTo(t2);
    }

    @Override
    protected Integer parseValue(String argument) throws ValueFormatException {
        try {
            return Integer.parseInt(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа");
        }
    }

    public IntegerReader setLowerBound(Integer lowerBound) {
        super.setLowerBound(lowerBound);
        return this;
    }


}
