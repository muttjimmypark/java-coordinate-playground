package coordinateCalculator;

import java.util.List;

public class Triangle extends AbstractFigure {
    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    protected double calculateValue() {
        double a = points.get(0).getDistanceWithAnother(points.get(1));
        double b = points.get(0).getDistanceWithAnother(points.get(2));
        double c = points.get(1).getDistanceWithAnother(points.get(2));
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
