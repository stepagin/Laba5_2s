package consoleapplication.readers.simpleReaders.enumerable;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.person.hair.Color;

/**
 * Класс, считывающий значение цвета волос
 */
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
