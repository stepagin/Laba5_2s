package consoleapplication.readers.complexReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.person.Coordinates;
import consoleapplication.readers.simpleReaders.IntegerReader;
import consoleapplication.readers.simpleReaders.LongReader;

public class CoordinatesReader extends ComplexValueReader<Coordinates> {

    public CoordinatesReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected Coordinates readFields() {
        Long x = new LongReader(inputManager, outputManager, false)
                .setLowerBound((long) -33).read("координата х");
        Integer y = new IntegerReader(inputManager, outputManager, false)
                .read("координата у");
        return new Coordinates(x, y);
    }

    @Override
    protected String getTypeName() {
        return Coordinates.class.getSimpleName();
    }
}
