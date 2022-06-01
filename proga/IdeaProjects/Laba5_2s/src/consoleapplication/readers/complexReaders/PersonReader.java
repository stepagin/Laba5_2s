package consoleapplication.readers.complexReaders;


import consoleapplication.*;
import consoleapplication.person.*;
import consoleapplication.person.Country;
import consoleapplication.person.Location;
import consoleapplication.person.Person;
import consoleapplication.readers.simpleReaders.*;
import consoleapplication.readers.simpleReaders.enumerable.*;

import java.time.ZonedDateTime;

public class PersonReader extends ComplexValueReader<Person> {

    public PersonReader(InputManager inputManager, OutputManager outputManager, boolean canBeNull) {
        super(inputManager, outputManager, canBeNull);
    }

    public PersonReader(InputManager inputManager, OutputManager outputManager) {
        super(inputManager, outputManager, false);
    }

    @Override
    protected Person readFields() {
        Integer id = (int)(System.currentTimeMillis() % (Integer.MAX_VALUE) / 10000);
        String name = new StringReader(inputManager, outputManager, false)
                .setCanBeEmpty(false).setLengthUpperBound(942).read("имя"); //
        Coordinates coordinates = new CoordinatesReader(inputManager, outputManager, false)
                .read("координаты");
        ZonedDateTime creationDate = ZonedDateTime.now();
        Long height = new LongReader(inputManager, outputManager, true)
                .setLowerBound(0L).read("рост");
        consoleapplication.person.eye.Color eyeColor = new EyeColorReader(inputManager, outputManager, false)
                .read("цвет глаз");
        consoleapplication.person.hair.Color hairColor = new HairColorReader(inputManager, outputManager, false)
                .read("цвет волос");
        Country nationality = new CountryReader(inputManager, outputManager, false)
                .read("национальность");
        Location location = new LocationReader(inputManager, outputManager, false)
                .read("локация");
        return new Person(id, name, coordinates, creationDate, height, eyeColor, hairColor, nationality, location);
    }

    @Override
    protected String getTypeName() {
        return Person.class.getSimpleName();
    }
}
