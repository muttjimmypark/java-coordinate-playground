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
    Dot dot4 = new Dot(4, 3);
    Dot dot5 = new Dot(5, 1);
    Dot dot6 = new Dot(6, 2);
    Dot dot7 = new Dot(7, 2);
    Dots dots = new Dots(Arrays.asList(dot0, dot1, dot2, dot3, dot4, dot5, dot6, dot7));

    @Test
    void getXHaveSameY() {
        assertThat(dots.getXHaveSameY(2)).isEqualTo(Arrays.asList(2, 6, 7));
        assertThat(dots.getXHaveSameY(1)).isEqualTo(Arrays.asList(1, 5));
    }

    @Test
    void howManyDots() {
        assertThat(dots.howManyDots()).isEqualTo(8);
    }

    @Test
    void lineLength() {
        Dots lineLength = new Dots(Arrays.asList(dot0, dot3));
        assertThat(lineLength.coordinateCalculate()).isEqualTo(5.0);

        lineLength = new Dots(Arrays.asList(dot0, dot1));
        assertEquals(1.414, lineLength.coordinateCalculate(), 0.001);
        //밑에 이 둘의 차이가 뭐지, 둘다 통과하는데 수업자료에서는 첫번째 줄을 권유했음, 셋째줄은 검색했을때 나온 권장 사용법
        assertThat(lineLength.coordinateCalculate()).isEqualTo(1.414, offset(0.00099));
        assertThat(lineLength.coordinateCalculate()).isEqualTo(1.414, offset(0.001));
        assertThat(lineLength.coordinateCalculate()).isEqualTo(1.414, offset(0.001d));
    }
}
