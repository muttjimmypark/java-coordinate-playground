package CoordinateCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DotTest {
    @Test
    void validValues() {
        assertThatThrownBy(() -> new Dot(0, 25)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Dot(25, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Dot(-1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Dot(0, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}
