package CoordinateCalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DotsTest {
    Dot dot1 = new Dot(1, 1);
    Dot dot2 = new Dot(2, 2);
    Dot dot3 = new Dot(3, 2);
    Dot dot4 = new Dot(4, 3);
    Dot dot5 = new Dot(5, 1);
    Dot dot6 = new Dot(6, 2);
    Dot dot7 = new Dot(7, 4);
    Dots dots = new Dots(Arrays.asList(dot1, dot2, dot3, dot4, dot5, dot6, dot7));

    @Test
    void getXHaveSameY() {
        assertThat(dots.getXHaveSameY(2)).isEqualTo(Arrays.asList(2, 3, 6));
        assertThat(dots.getXHaveSameY(1)).isEqualTo(Arrays.asList(1, 5));
    }

    @Test
    void howManyDots() {
        assertThat(dots.howManyDots()).isEqualTo(7);
    }
}
