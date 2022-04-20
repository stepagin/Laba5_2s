package ConsoleApplication.readers.simpleReaders.enumerable;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.person.hair.Color;

public class HairColorReader extends EnumReader<Color> {

    public HairColorReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    Color[] getEnumValues() {
        return Color.values();
    }

    @Override
    Color valueOf(String name) {
        return Color.valueOf(name);
    }
}
