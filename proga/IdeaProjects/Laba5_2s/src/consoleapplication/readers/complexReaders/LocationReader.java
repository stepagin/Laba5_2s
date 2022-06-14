package consoleapplication.readers.complexReaders;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.person.Location;
import consoleapplication.readers.simpleReaders.DoubleReader;
import consoleapplication.readers.simpleReaders.IntegerReader;
import consoleapplication.readers.simpleReaders.LongReader;
import consoleapplication.readers.simpleReaders.StringReader;

public class LocationReader extends ComplexValueReader<Location> {

    public LocationReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    protected Location readFields() {
        Long x;
        if (!isNullable()){
            x = new LongReader(inputManager, outputManager, false)
                    .read("координата x");
        } else {
            x = new LongReader(inputManager, outputManager, true)
                    .read("координата x");
            if (x == null){
                return null;
            }
        }
        int y = new IntegerReader(inputManager, outputManager, false)
                .read("кордината y");
        double z = new DoubleReader(inputManager, outputManager, false)
                .read("координата z");
        String name = new StringReader(inputManager, outputManager, false)
                .read("название локации");
        return new Location(x, y, z, name);
    }

    @Override
    protected String getTypeName() {
        return Location.class.getSimpleName();
    }
}
