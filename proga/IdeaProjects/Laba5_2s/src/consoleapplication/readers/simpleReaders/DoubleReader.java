package consoleapplication.readers.simpleReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.readers.ValueFormatException;

public class DoubleReader extends  NumberReader<Double> {

    public DoubleReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }
    public DoubleReader(InputManager inputManager, OutputManager outputManager) {
        this(inputManager, outputManager, true);
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
