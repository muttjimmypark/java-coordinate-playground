package coordinateCalculator;

import java.util.List;
import java.util.Objects;

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

    @Override
    public int getPointsSize() {
        return points.size();
    }

    @Override
    public boolean existPoint(int x, int y) {
        return points.contains(new Point(x, y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
