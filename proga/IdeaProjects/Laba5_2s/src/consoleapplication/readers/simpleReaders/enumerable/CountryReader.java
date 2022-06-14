package consoleapplication.readers.simpleReaders.enumerable;

import consoleapplication.InputManager;
import consoleapplication.OutputManager;
import consoleapplication.person.Country;

/**
 * Класс, считывающий значение национальности
 */
public class CountryReader extends EnumReader<Country> {

    public CountryReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    @Override
    Country[] getEnumValues() {
        return Country.values();
    }

    @Override
    Country valueOf(String name) {
        return Country.valueOf(name);
    }
}
