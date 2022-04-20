package ConsoleApplication.person;

public class Coordinates {
    private Long x; //Значение поля должно быть больше -33, Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }
}
