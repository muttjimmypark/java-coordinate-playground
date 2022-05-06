package CoordinateCalculator;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Integer> getXHaveSameY(int y) {
        return dots.stream()
                .filter(dot -> dot.isSameValueY(y))
                .map(Dot::getValueX)
                .sorted()
                .collect(Collectors.toList());
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
