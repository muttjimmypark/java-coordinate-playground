package CoordinateCalculator;

public class Application {
    public static void main(String[] args) {
        Dots dots;

        while (true) {
            try {
                dots = InputView.scanValues();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        OutputView.printGraph(dots);
        OutputView.printCalculateMessage(dots);
    }
}
