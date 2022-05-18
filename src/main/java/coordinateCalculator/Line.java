package coordinateCalculator;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String MESSAGE_LENGTH_IS = "길이는 ";

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public String getValueMessage() {
        return MESSAGE_LENGTH_IS + calculateValue();
    }

    @Override
    protected double calculateValue() {
        return points.get(0).getDistanceWithAnother(points.get(1));
    }
}
