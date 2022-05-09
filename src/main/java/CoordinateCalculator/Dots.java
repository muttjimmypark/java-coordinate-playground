package CoordinateCalculator;

import java.util.Arrays;
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

    public boolean existValue(int x, int y) {
        return dots.contains(new Dot(x, y));
    }

    public boolean validRectangle() {
        if (howManyDots() != 4) {
            return false;
        }

        return dots.stream().allMatch(this::validRectangleElement);
    }

    public double coordinateCalculate() {
        if (howManyDots() == 2) {
            return lineLength(dots.get(0), dots.get(1));
        }
        if (validRectangle()) {
            return rectangleSize();
        }
        if (howManyDots() == 3) {
            return triangleSize();
        }

        return -1;
    }

    private double lineLength(Dot dot1, Dot dot2) {
        return Math.sqrt(Math.pow(dot1.getValueX() - dot2.getValueX(), 2)
                + Math.pow(dot1.getValueY() - dot2.getValueY(), 2));
    }

    private boolean validRectangleElement(Dot dot) {
        int x = dot.getValueX();
        int y = dot.getValueY();

        return dots.stream().filter(element -> element.getValueX() == x).count() == 2
                && dots.stream().filter(element -> element.getValueY() == y).count() == 2;
    }

    private double rectangleSize() {
        //한 점을 기점으로, 대각선이 아닌 직선끼리 곱하면 넓이
        //lineLength를 활용하기 위한 방법을 구상함
        List<Double> lengths = Arrays.asList(
                lineLength(dots.get(0), dots.get(1)),
                lineLength(dots.get(0), dots.get(2)),
                lineLength(dots.get(0), dots.get(3)));

        lengths = lengths.stream().sorted().collect(Collectors.toList());

        return lengths.get(0) * lengths.get(1);
    }

    private double triangleSize() {
        List<Double> lengths = Arrays.asList(
                lineLength(dots.get(0), dots.get(1)),
                lineLength(dots.get(0), dots.get(2)),
                lineLength(dots.get(1), dots.get(2)));
        double s = lengths.stream().mapToDouble(length -> length).sum() / 2;

        return Math.sqrt(s * (s - lengths.get(0)) * (s - lengths.get(1)) * (s - lengths.get(2)));
    }
}
