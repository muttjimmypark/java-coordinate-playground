package CoordinateCalculator;

public class Dot {
    public static final int DOT_AXIS_MIN = 0;
    public static final int DOT_AXIS_MAX = 24;
    private final int x;
    private final int y;

    public Dot(int x, int y) {
        if (x < DOT_AXIS_MIN || x > DOT_AXIS_MAX
                || y < DOT_AXIS_MIN || y > DOT_AXIS_MAX) {
            throw new IllegalArgumentException("좌표값이 범위를 벗어났습니다 : 0~24");
        }

        this.x = x;
        this.y = y;
    }

    public boolean isSameAxisY(int y) {
        return this.y == y;
    }

    public int getAxisX() {
        return x;
    }
}
