package coordinateCalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    Figure figure1;
    Figure figure2;
    List<Point> points;

    @Test
    void makeLine() {
        figure1 = InputView.scanPoints("(1,1)-(2,1)");
        assertThat(figure1).isInstanceOf(Line.class);

        points = Arrays.asList(new Point(1, 1), new Point(2, 1));
        figure2 = FigureFactory.getFigure(points);
        assertThat(figure1).isEqualTo(figure2);
    }


    @Test
    void makeTriangle() {
        figure1 = InputView.scanPoints("(1, 1) - (2, 1) - (3, 2)");
        assertThat(figure1).isInstanceOf(Triangle.class);

        points = Arrays.asList(new Point(1, 1), new Point(2, 1), new Point(3, 2));
        figure2 = FigureFactory.getFigure(points);
        assertThat(figure1).isEqualTo(figure2);
    }


    @Test
    void makeRectangle() {
        figure1 = InputView.scanPoints("(1, 1) - (2, 1) - (1, 2)-( 2,2)");
        assertThat(figure1).isInstanceOf(Rectangle.class);

        points = Arrays.asList(new Point(1, 1), new Point(2, 1), new Point(1, 2), new Point(2, 2));
        figure2 = FigureFactory.getFigure(points);
        assertThat(figure1).isEqualTo(figure2);
    }

}
