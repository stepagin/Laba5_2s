package ConsoleApplication.person;
import java.lang.*;


public class Person {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long height; //Поле может быть null, Значение поля должно быть больше 0
    private ConsoleApplication.person.eye.Color eyeColor; //Поле не может быть null
    private ConsoleApplication.person.hair.Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null
    private Location location; //Поле может быть null

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
}
