package coordinateCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final int CONSTRUCT_NUMBER_LINE = 2;
    private static final int CONSTRUCT_NUMBER_TRIANGLE = 3;
    private static final int CONSTRUCT_NUMBER_RECTANGLE = 4;
    private static final String MESSAGE_NOT_SUPPORT_FIGURE = "지원하지 않는 도형입니다.";
    private static final Map<Integer, Function<List<Point>, Figure>> figureConstructConditions = new HashMap<>();

    static {
        figureConstructConditions.put(CONSTRUCT_NUMBER_LINE, Line::new);
        figureConstructConditions.put(CONSTRUCT_NUMBER_TRIANGLE, Triangle::new);
        figureConstructConditions.put(CONSTRUCT_NUMBER_RECTANGLE, Rectangle::new);
    }

    public static Figure getFigure(List<Point> points) {
        if (points == null) {
            throw new IllegalArgumentException(AbstractFigure.MESSAGE_INVALID_POINTS);
        }
        if (points.size() < CONSTRUCT_NUMBER_LINE || points.size() > CONSTRUCT_NUMBER_RECTANGLE) {
            throw new IllegalArgumentException(MESSAGE_NOT_SUPPORT_FIGURE);
        }

        return figureConstructConditions.get(points.size()).apply(points);
    }
}
