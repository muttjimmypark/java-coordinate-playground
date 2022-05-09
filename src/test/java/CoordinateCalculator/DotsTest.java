package CoordinateCalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DotsTest {
    Dot dot0 = new Dot(0, 0);
    Dot dot1 = new Dot(1, 1);
    Dot dot2 = new Dot(2, 2);
    Dot dot3 = new Dot(3, 4);
    Dots dots = new Dots(Arrays.asList(dot0, dot1, dot2, dot3));

    @Test
    void existValue() {
        assertThat(dots.existValue(2, 2)).isTrue();
    }

    @Test
    void howManyDots() {
        assertThat(dots.howManyDots()).isEqualTo(4);
    }

    @Test
    void lineLength_coordinateCalculate() {
        Dots forLineLengthTest = new Dots(Arrays.asList(dot0, dot3));
        assertThat(forLineLengthTest.coordinateCalculate()).isEqualTo(5.0);

        forLineLengthTest = new Dots(Arrays.asList(dot0, dot1));
        assertEquals(1.414, forLineLengthTest.coordinateCalculate(), 0.001);
        //밑에 이 셋의 차이가 뭐지, 둘다 통과하는데 수업자료에서는 첫번째 줄을 권유했음, 셋째줄은 검색했을때 나온 권장 사용법
        assertThat(forLineLengthTest.coordinateCalculate()).isEqualTo(1.414, offset(0.00099));
        assertThat(forLineLengthTest.coordinateCalculate()).isEqualTo(1.414, offset(0.001));
        assertThat(forLineLengthTest.coordinateCalculate()).isEqualTo(1.414, offset(0.001d));
    }

    @Test
    void validRactangle() {
        assertThat(dots.validRectangle()).isFalse();

        dot2 = new Dot(1, 0);
        dot3 = new Dot(0, 1);
        dots = new Dots(Arrays.asList(dot0, dot1, dot2, dot3));

        assertThat(dots.validRectangle()).isTrue();
    }

    @Test
    void rectangleSize_coordinateCalculate() {
        assertThat(dots.coordinateCalculate()).isEqualTo(-1);

        dot1 = new Dot(2, 0);
        dot3 = new Dot(0, 2);
        dots = new Dots(Arrays.asList(dot0, dot1, dot2, dot3));

        assertThat(dots.coordinateCalculate()).isEqualTo(4);
    }
}
