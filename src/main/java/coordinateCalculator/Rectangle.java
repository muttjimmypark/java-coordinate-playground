package coordinateCalculator;

import java.util.*;
import java.util.function.Function;

public class Rectangle extends AbstractFigure {
    private static final String MESSAGE_INVALID_RECTANGLE = "입력받은 사각형은 직사각형이 아닙니다.";

    public Rectangle(List<Point> points) {
        super(points);
        if (checkValidCoordinates()) {
            throw new IllegalArgumentException(MESSAGE_INVALID_RECTANGLE);
        }
    }

    private boolean checkValidCoordinates() {
        return points.stream().map(Point::getX).distinct().count() != 2
                || points.stream().map(Point::getY).distinct().count() != 2;
    }

    @Override
    public double calculateValue() {
        List<Double> distances = Arrays.asList(
                points.get(0).getDistanceWithAnother(points.get(1)),
                points.get(0).getDistanceWithAnother(points.get(2)),
                points.get(0).getDistanceWithAnother(points.get(3))
        );
        Collections.sort(distances);

        return distances.get(0) * distances.get(1);
    }
}
