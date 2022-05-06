package CoordinateCalculator;

import java.util.List;

public class Dots {
    public static final int DOT_VALUE_MIN = 0;
    public static final int DOT_VALUE_MAX = 24;
    private final List<Dot> dots;

    public Dots(List<Dot> dots) {
        this.dots = dots;
    }

    public int howManyDots() {
        return dots.size();
    }

    public boolean existValue(int x, int y) {
        return dots.contains(new Dot(x, y));
    }

    public double coordinateCalculate() {
        if (howManyDots() == 2) {
            return lineLength();
        }

        return -1;
    }

    private double lineLength() {
        return Math.sqrt(Math.pow(dots.get(0).getValueX() - dots.get(1).getValueX(), 2)
                + Math.pow(dots.get(0).getValueY() - dots.get(1).getValueY(), 2));
    }

}
