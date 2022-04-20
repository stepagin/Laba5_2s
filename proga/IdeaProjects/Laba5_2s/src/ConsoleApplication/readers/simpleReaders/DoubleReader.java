package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;

public class DoubleReader extends  NumberReader<Double> {

    public DoubleReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager, true);
    }

    @Override
    protected int compareValues(Double t1, Double t2) {
        return t1.compareTo(t2);
    }

    @Override
    protected Double parseValue(String argument) throws ValueFormatException {
        try {
            return Double.parseDouble(argument);
        } catch (Exception e) {
            throw new ValueFormatException("Некорректный формат числа");
        }
    }

    @Override
    public DoubleReader setLowerBound(Double lowerBound) {
        super.setLowerBound(lowerBound);
        return this;
    }
}
