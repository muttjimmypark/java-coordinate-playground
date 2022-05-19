package coordinateCalculator;

public interface Figure {
    String getValueMessage();
    int getPointsSize();
    double calculateValue();
    boolean existPoint(int x, int y);
}
