package coordinateCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FigureTest {
    List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
    }

    @Test
    void nullPoints() {
        assertThatThrownBy(() -> FigureFactory.getFigure(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void fivePoints() {
        points.add(new Point(1,0));
        points.add(new Point(2,0));
        points.add(new Point(3,0));
        points.add(new Point(4,0));
        points.add(new Point(5,0));

        assertThatThrownBy(() -> FigureFactory.getFigure(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void makeLine() {
        points.add(new Point(1,0));
        points.add(new Point(2,0));

        assertThat(FigureFactory.getFigure(points)).isInstanceOf(Line.class);
    }

    @Test
    void makeTriangle() {
        points.add(new Point(1,0));
        points.add(new Point(2,0));
        points.add(new Point(2,3));

        assertThat(FigureFactory.getFigure(points)).isInstanceOf(Triangle.class);
    }

    @Test
    void makeRectangle() {
        points.add(new Point(1,1));
        points.add(new Point(2,2));
        points.add(new Point(2,1));
        points.add(new Point(1,2));

        assertThat(FigureFactory.getFigure(points)).isInstanceOf(Rectangle.class);
    }

    @Test
    void invalidRectangle() {
        points.add(new Point(1,1));
        points.add(new Point(2,2));
        points.add(new Point(2,1));
        points.add(new Point(1,3));

        assertThatThrownBy(() -> FigureFactory.getFigure(points)).isInstanceOf(IllegalArgumentException.class);
    }
}
