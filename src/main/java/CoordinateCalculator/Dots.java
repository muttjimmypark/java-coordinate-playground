package CoordinateCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Dots {
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
}
