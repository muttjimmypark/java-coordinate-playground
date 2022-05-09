package CoordinateCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static Dots scanValues() {
        System.out.println("좌표를 입력하세요.");
        List<Dot> result = new ArrayList<>();
        List<String> notValidDots = Arrays.asList(new Scanner(System.in).nextLine().split("-"));

        for (String notValidDot : notValidDots) {
            Matcher m = Pattern.compile("(\\d+),(\\d+)").matcher(notValidDot);

            if (m.find()) {
                System.out.println(m.groupCount());
                result.add(new Dot(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
                System.out.println(result);
            }
        }

        return new Dots(result);
    }
}
