package CoordinateCalculator;

import java.util.List;

import static CoordinateCalculator.Dots.DOT_VALUE_MAX;

public class OutputView {
    public static void printIllegalInputMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printGraph(Dots dots) {
        //y가 1~24 일때 y축과 좌표 출력 부분
        for (int i = DOT_VALUE_MAX; i > 0 ; i--) {
            //홀수줄에서 공백2칸, 짝수줄에서 숫자 출력
            String indexNum = "  ";
            if (i % 2 == 0) {
                indexNum = Integer.toString(i);
            }
            System.out.print(indexNum);

            List<Integer> needToPrintAxisesX = dots.getXHaveSameY(i);
            for (int j = 0; j < ; j++) {
                
            }
        }

        //y가 0 일때 x축과 좌표 출력 부분
        //

        //x축 index 출력 부분
        //
    }
}
