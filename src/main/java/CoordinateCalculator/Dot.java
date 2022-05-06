package CoordinateCalculator;

import java.util.Objects;

import static CoordinateCalculator.Dots.DOT_VALUE_MIN;
import static CoordinateCalculator.Dots.DOT_VALUE_MAX;

public class Dot {
    private final int x;
    private final int y;

    public Dot(int x, int y) {
        if (x < DOT_VALUE_MIN || x > DOT_VALUE_MAX
                || y < DOT_VALUE_MIN || y > DOT_VALUE_MAX) {
            throw new IllegalArgumentException("좌표값이 범위를 벗어났습니다 : 0~24");
        }

        this.x = x;
        this.y = y;
    }

//    public boolean isSameValueY(int y) {
//        return this.y == y;
//    }

    public int getValueX() {
        return x;
    }

    public int getValueY() {
        return y;
    }

    //Dots.existValue()에서 객체 대 객체로 비교하므로 필요
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return x == dot.x && y == dot.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
