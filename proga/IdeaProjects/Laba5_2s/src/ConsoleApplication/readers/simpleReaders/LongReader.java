package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;

public class LongReader extends NumberReader<Long> {

    public LongReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected int compareValues(Long t1, Long t2) {
        return t1.compareTo(t2);
    }

    @Override
    protected Long parseValue(String argument) throws ValueFormatException {
        try {
            return Long.parseLong(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа");
        }
    }

    @Override
    public NumberReader<Long> setLowerBound(Long lowerBound) {
        super.setLowerBound(lowerBound);
        return this;
    }
}
