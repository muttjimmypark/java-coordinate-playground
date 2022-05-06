package CoordinateCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    public static Dots scanAxises() {
        List<Dot> result = new ArrayList<>();
        List<String> notValidDots = Arrays.asList(new Scanner(System.in).next().split("-"));

        for (String notValidDot : notValidDots) {
            Matcher m = Pattern.compile("(" + "(.),(.)" +")").matcher(notValidDot);

            if (m.find()) {
                result.add(new Dot(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
            }
        }

        return new Dots(result);
    }
}
