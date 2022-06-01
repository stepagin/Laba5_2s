package consoleapplication.person;

public class Coordinates {
    private Long x; //Значение поля должно быть больше -33, Поле не может быть null
    private Integer y; //Поле не может быть null

    public Coordinates(Long x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x=" + x +
                ", y=" + y +
                ')';
    }
    public static int compare(Coordinates a, Coordinates b) {
        if (a == null) {
            return b == null ? 0 : -1;
        } else {
            if (b == null) {
                return 1;
            } else if (Double.compare(a.x, b.x) != 0) {
                return Double.compare(a.x, b.x);
            } else {
                return Double.compare(a.y, a.y);
            }
        }
    }
}
