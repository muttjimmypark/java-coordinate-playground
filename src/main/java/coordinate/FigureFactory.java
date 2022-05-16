package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {
    private static final Map<Integer, Function<List<Point>, Figure>> creators = new HashMap<>();

    static {
        creators.put(Line.LINE_POINT_SIZE, Line::new);
        creators.put(Triangle.TRIANGLE_POINT_SIZE, Triangle::new);
        creators.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle::new);
    }

    static Figure getInstance(List<Point> points) {
//        if (points.size() == Line.LINE_POINT_SIZE) {
//            return new Line(points);
//        }
//
//        if (points.size() == Triangle.TRIANGLE_POINT_SIZE) {
//            return new Triangle(points);
//        }
//
//        if (points.size() == Rectangle.RECTANGLE_POINT_SIZE) {
//            return new Rectangle(points);
//        }
//
//        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        return creators.get(points.size()).apply(points);
    }
}
