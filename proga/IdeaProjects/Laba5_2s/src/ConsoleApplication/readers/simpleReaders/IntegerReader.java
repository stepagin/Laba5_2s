package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;

public class IntegerReader extends NumberReader<Integer>{

    public IntegerReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager, false);
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
