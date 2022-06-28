package coordinateCalculator;

import java.util.Objects;

public class Point {
    private static final String MESSAGE_ILLEGAL_POINT_RANGE = "표현할 수 없는 범위의 좌표입니다. (0~24)";
    public static final int COORDINATE_LOWER_LIMIT = 0;
    public static final int COORDINATE_UPPER_LIMIT = 24;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        if (!validCoordinate(x) || !validCoordinate(y)) {
            throw new IllegalArgumentException(MESSAGE_ILLEGAL_POINT_RANGE);
        }

        this.x = x;
        this.y = y;
    }

    private boolean validCoordinate(int position) {
        return position >= COORDINATE_LOWER_LIMIT
                && position <= COORDINATE_UPPER_LIMIT;
    }

    public double getDistanceWithAnother(Point anotherPoint) {
        return Math.sqrt(Math.pow(this.x - anotherPoint.x, 2) + Math.pow(this.y - anotherPoint.y, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
//        return super.equals(o);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(x, y);
//    }


}
