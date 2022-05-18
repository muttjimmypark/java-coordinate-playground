package coordinateCalculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public static final String MESSAGE_INVALID_POINT = "일부 점이 잘못된 입력입니다.";
    private static final String MESSAGE_SCAN_START = "좌표를 입력하세요 : ";
    private static final String MESSAGE_INVALID_SCAN = "잘못된 입력입니다.";

    public static List<Point> scanPoints() {
        System.out.print(MESSAGE_SCAN_START);
        return scanPoints(new Scanner(System.in).nextLine());
    }

    public static List<Point> scanPoints(String scanString) {
        try {
            validPoints(scanString);
            return mappingString(scanString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return scanPoints();
        }
    }

    private static List<Point> mappingString(String scanString) {
        return splitPoints(scanString)
                .stream()
                .map(InputView::stringToPoint)
                .collect(Collectors.toList());
    }

    private static void validPoints(String scanString) {
        Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}");
        Matcher matcher = pattern.matcher(scanString);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(MESSAGE_INVALID_SCAN);
        }
    }

    private static List<String> splitPoints(String scanString) {
        //수업에서 Java16 미사용 수준으로 권고
//        Arrays.stream(scanString.split("-")).toList();
        List<String> list = new ArrayList<>();
        Collections.addAll(list, scanString.split("-"));
        return list;
    }

    private static Point stringToPoint(String scanPoint) {
        Pattern pattern = Pattern.compile("\\([0-9]{1,2},[0-9]{1,2}\\)");
        Matcher matcher = pattern.matcher(scanPoint);
        if (matcher.find()) {
            return new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }
        throw new IllegalArgumentException(MESSAGE_INVALID_POINT);
    }
}
