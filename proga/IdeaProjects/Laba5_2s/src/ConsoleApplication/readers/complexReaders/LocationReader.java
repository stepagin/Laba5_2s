package ConsoleApplication.readers.complexReaders;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.person.Location;
import ConsoleApplication.readers.simpleReaders.DoubleReader;
import ConsoleApplication.readers.simpleReaders.IntegerReader;
import ConsoleApplication.readers.simpleReaders.LongReader;
import ConsoleApplication.readers.simpleReaders.StringReader;

public class LocationReader extends ComplexValueReader<Location> {

    public LocationReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected Location readFields() {
        Long x = new LongReader(inputManager, outputManager, false)
                .read("координата x");
        int y = new IntegerReader(inputManager, outputManager, true)
                .read("кордината y");
        double z = new DoubleReader(inputManager, outputManager, true)
                .read("координата z");
        String name = new StringReader(inputManager, outputManager, false)
                .read("name");

        return new Location(x, y, z, name);
    }

    @Override
    protected String getTypeName() {
        return Location.class.getSimpleName();
    }
}
