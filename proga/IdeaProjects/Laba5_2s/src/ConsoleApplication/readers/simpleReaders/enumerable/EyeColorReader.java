package ConsoleApplication.readers.simpleReaders.enumerable;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.person.eye.Color;

public class EyeColorReader extends EnumReader<Color> {
    public EyeColorReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
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
