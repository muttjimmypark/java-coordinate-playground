package CoordinateCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Pattern coordinatePattern = Pattern.compile("(\\d+),(\\d+)");

    public static Dots scanValues() {
        System.out.println("좌표를 입력하세요.");
        List<Dot> result = new ArrayList<>();
        List<String> notValidDots = Arrays.asList(new Scanner(System.in).nextLine().split("-"));

        for (String notValidDot : notValidDots) {
            Matcher m = coordinatePattern.matcher(notValidDot);

            if (m.find()) {
                result.add(new Dot(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
            }
        }

        return new Dots(result);
    }
}
