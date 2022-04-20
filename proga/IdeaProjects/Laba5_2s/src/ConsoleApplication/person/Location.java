package ConsoleApplication.person;

public class Location {
    private Long x; //Поле не может быть null
    private int y;
    private double z;
    private String name; //Длина строки не должна быть больше 942, Поле не может быть null

    public Location(Long x, int y, double z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
}

