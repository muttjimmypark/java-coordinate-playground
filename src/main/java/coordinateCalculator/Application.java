package coordinateCalculator;

public class Application {
    public static void main(String[] args) {
        Figure figure = InputView.scanPoints();
        OutputView.printGraph(figure);
        OutputView.printValueMessage(figure);
    }
}