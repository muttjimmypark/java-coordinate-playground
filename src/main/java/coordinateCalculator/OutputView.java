package coordinateCalculator;

public class OutputView {

    public static final String GRAPH_BLANK = "  ";
    public static final String GRAPH_POINT = " *";
    public static final String GRAPH_VERTICAL = " |";
    public static final String GRAPH_ORIGIN = " +";
    public static final String GRAPH_HORIZONTAL = "--";

    public static void printGraph(Figure figure) {
        for (int y = Point.COORDINATE_UPPER_LIMIT; y > Point.COORDINATE_LOWER_LIMIT; y--) {
            printLineWithVerticalAxis(figure, y);
        }
        printLineWithHorizontalAxis(figure);
        printIndexAxisX();
    }

    private static void printLineWithVerticalAxis(Figure figure, int y) {
        String indexY = GRAPH_BLANK;
        if (y % 2 == 0) {
            indexY = String.format("%2d", y);
        }
        System.out.print(indexY);

        for (int x = Point.COORDINATE_LOWER_LIMIT; x <= Point.COORDINATE_UPPER_LIMIT; x++) {
            if (figure.existPoint(x, y)) {
                System.out.print(GRAPH_POINT);
                continue;
            }
            if (x == 0) {
                System.out.print(GRAPH_VERTICAL);
                continue;
            }
            System.out.print(GRAPH_BLANK);
        }

        System.out.println();
    }

    private static void printLineWithHorizontalAxis(Figure figure) {
        System.out.print(GRAPH_BLANK);

        for (int x = Point.COORDINATE_LOWER_LIMIT; x <= Point.COORDINATE_UPPER_LIMIT; x++) {
            if (figure.existPoint(x, 0)) {
                System.out.print(GRAPH_POINT);
                continue;
            }
            if (x == 0) {
                System.out.print(GRAPH_ORIGIN);
                continue;
            }
            System.out.print(GRAPH_HORIZONTAL);
        }

        System.out.println();
    }

    private static void printIndexAxisX() {
        System.out.print(GRAPH_BLANK);
        for (int x = Point.COORDINATE_LOWER_LIMIT; x <= Point.COORDINATE_UPPER_LIMIT; x++) {
            String indexX = GRAPH_BLANK;
            if (x % 2 == 0) {
                indexX = String.format("%2d", x);
            }
            System.out.print(indexX);
        }
        System.out.println();
    }

    public static void printValueMessage(Figure figure) {
        System.out.println(figure.getValueMessage());
    }
}
