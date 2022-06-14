package consoleapplication.person;
import consoleapplication.person.eye.Color;

import java.io.Serializable;
import java.lang.*;


/**
 * Класс, хранящий данные о человеке.
 */
public class Person implements Comparable<Person>, Serializable {
    private final Integer id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Long height; //Поле может быть null, Значение поля должно быть больше 0
    private final consoleapplication.person.eye.Color eyeColor; //Поле не может быть null
    private final consoleapplication.person.hair.Color hairColor; //Поле не может быть null
    private final Country nationality; //Поле не может быть null
    private final Location location; //Поле может быть null

    public Person(int id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate, Long height,
                  consoleapplication.person.eye.Color eyeColor, consoleapplication.person.hair.Color hairColor,
                  Country nationality, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public String convertToCSV() {
        return "" + id + ';' + name + ';' + coordinates.toString() + ';' + creationDate + ';' +
                height + ';' + eyeColor + ';' + hairColor + ';' + nationality + ';' + location.toString();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Person o) {
        if (o == null) {
            return 1;
        } else if (!(id.equals(o.id))) {
            return id.compareTo(o.id);
        } else if (!name.equals(o.name)) {
            return name.compareTo(o.name);
        } else if (!coordinates.equals(o.coordinates)) {
            return Coordinates.compare(coordinates, o.coordinates);
        } else if (!creationDate.equals(o.creationDate)) {
            return creationDate.compareTo(o.creationDate);
        } else if (!height.equals(o.height)) {
            return height.compareTo(o.height);
        } else if (!eyeColor.equals(o.eyeColor)) {
            return eyeColor.compareTo(o.eyeColor);
        } else if (!hairColor.equals(o.hairColor)) {
            return hairColor.compareTo(o.hairColor);
        } else if (!nationality.equals(o.nationality)) {
            return nationality.compareTo(o.nationality);
        } else
            return Location.compare(location, o.location);
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public String getName() {
        return name;
    }
}
