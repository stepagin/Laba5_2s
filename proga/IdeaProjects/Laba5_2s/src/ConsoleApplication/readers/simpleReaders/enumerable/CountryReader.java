package ConsoleApplication.readers.simpleReaders.enumerable;

import ConsoleApplication.InputManager;
import ConsoleApplication.OutputManager;
import ConsoleApplication.person.Country;

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
