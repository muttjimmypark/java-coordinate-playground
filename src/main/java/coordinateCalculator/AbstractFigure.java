package coordinateCalculator;

import java.util.List;

public abstract class AbstractFigure implements Figure {
    protected static final String MESSAGE_AREA_IS = "넓이는 ";
    protected static final String MESSAGE_INVALID_POINTS = "점 입력이 잘못되었습니다.";
    protected final List<Point> points;

    public AbstractFigure(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_INVALID_POINTS);
        }
        this.points = points;
    }

    @Override
    public String getValueMessage() {
        return MESSAGE_AREA_IS + calculateValue();
    }

    protected abstract double calculateValue();

    @Override
    public int getPointsSize() {
        return points.size();
    }
}
