package coordinateCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void constructorAndEquals() {
        assertThat(new Point(1, 2)).isEqualTo(new Point(1, 2));
    }

    @Test
    void coordinateLimits() {
        assertThatThrownBy(() -> new Point(-1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Point(0, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Point(25, 24)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Point(24, 25)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getDistanceWithAnother() {
        assertThat(new Point(0, 0).getDistanceWithAnother(new Point(0, 1))).isEqualTo(1);
    }
}
