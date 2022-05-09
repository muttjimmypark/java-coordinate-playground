package CoordinateCalculator;

import static CoordinateCalculator.Dots.DOT_VALUE_MAX;

public class OutputView {
    public static void printGraph(Dots dots) {
        //y축의 index와 좌표출력가능 영역
        //y가 1~24 일때 y축과 좌표 출력
        //y가 0 일때 x축 출력 까지
        for (int y = DOT_VALUE_MAX; y >= 0; y--) {
            //y축 왼편 index 출력 : 홀수줄에서 공백2칸, 짝수줄에서 숫자 출력
            printIndexNumbers(y);

            //y값에 해당하는 좌표들 출력
            printGraphOneLine(dots, y);

            //한줄 마치고 newline 출력
            System.out.println();
        }

        //x축 index 출력 부분
        System.out.print(" ");
        for (int x = 0; x <= DOT_VALUE_MAX; x++) {
            printIndexNumbers(x);
        }

        System.out.println();
    }

    public static void printCalculateMessage(Dots dots) {
        int howManyDots = dots.howManyDots();
        double coordinateCalculate = dots.coordinateCalculate();

        if (coordinateCalculate == -1) {
            return;
        }

        if (howManyDots == 2) {
            System.out.print("길이 : ");
        } else {
            System.out.print("넓이 : ");
        }

        System.out.println(coordinateCalculate);
    }

    private static void printIndexNumbers(int i) {
        String indexNum = "  ";
        if (i % 2 == 0) {
            indexNum = Integer.toString(i);
        }

        if (i < 10 && i % 2 == 0) {
            System.out.print(" ");
        }
        System.out.print(indexNum);
    }

    private static void printGraphOneLine(Dots dots, int y) {
        for (int x = 0; x <= DOT_VALUE_MAX; x++) {
            if (dots.existValue(x, y)) {
                System.out.print("# ");
            } else if (x == 0 && y == 0) {
                System.out.print("+-");
            } else if (x == 0) {
                System.out.print("| ");
            } else if (y == 0) {
                System.out.print("--");
            } else {
                System.out.print("  ");
            }
        }
    }
}
