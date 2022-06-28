package coordinateCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
        Figure figure = FigureFactory.getFigure(points);

        assertThat(figure).isInstanceOf(Line.class);
        assertThat(figure.calculateValue()).isEqualTo(1.0, offset(0.1d));
    }

    @Test
    void makeTriangle() {
        points.add(new Point(1,0));
        points.add(new Point(2,0));
        points.add(new Point(2,3));
        Figure figure = FigureFactory.getFigure(points);

        assertThat(figure).isInstanceOf(Triangle.class);
        assertThat(figure.calculateValue()).isEqualTo(1.5, offset(0.1d));
    }

    @Test
    void makeRectangle() {
        points.add(new Point(1,1));
        points.add(new Point(2,2));
        points.add(new Point(2,1));
        points.add(new Point(1,2));
        Figure figure = FigureFactory.getFigure(points);

        assertThat(figure).isInstanceOf(Rectangle.class);
        assertThat(figure.calculateValue()).isEqualTo(1.0, offset(0.1d));
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
