package CoordinateCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Dots {
    public static final int DOT_AXIS_MIN = 0;
    public static final int DOT_AXIS_MAX = 24;
    List<Dot> dots;

    public Dots(List<Dot> dots) {
        this.dots = dots;
    }

    public int howManyDots() {
        return dots.size();
    }

    public List<Integer> getXHaveSameY(int y) {
        return dots.stream()
                .filter(dot -> dot.isSameAxisY(y))
                .map(Dot::getAxisX)
                .collect(Collectors.toList());
    }

    public double coordinateCalculate() {
        if (howManyDots() == 2) {
            return lineLength();
        }

        return -1;
    }

    private double lineLength() {
        return Math.sqrt(Math.pow(dots.get(0).getAxisX() - dots.get(1).getAxisX(), 2)
                + Math.pow(dots.get(0).getAxisY() - dots.get(1).getAxisY(), 2));
    }
}
