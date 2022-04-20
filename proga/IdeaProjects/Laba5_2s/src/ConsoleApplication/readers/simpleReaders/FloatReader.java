package ConsoleApplication.readers.simpleReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.readers.ValueFormatException;

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
