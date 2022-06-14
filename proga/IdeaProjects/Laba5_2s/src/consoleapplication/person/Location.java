package consoleapplication.person;

/**
 * Класс, хранящий значение локации.
 */
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

    @Override
    public String toString() {
        return "Location{'" +
                name +
                "', (x=" + x +
                ", y=" + y +
                ", z=" + z +
                ")}";
    }

    public static int compare(Location a, Location b) {
        if (a == null) {
            return b == null ? 0 : -1;
        } else {
            if (b == null) {
                return 1;
            } else if (Long.compare(a.x, b.x) != 0) {
                return Long.compare(a.x, b.x);
            } else if (Integer.compare(a.y, b.y) != 0) {
                return Integer.compare(a.y, b.y);
            } else if (Double.compare(a.z, b.z) != 0) {
                return Double.compare(a.z, b.z);
            } else {
                if (a.name == null) {
                    return b.name == null ? 0 : -1;
                } else {
                    return a.name.compareTo(b.name);
                }
            }
        }
    }
}

