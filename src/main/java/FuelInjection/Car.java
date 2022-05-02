package FuelInjection;

public interface Car {
    double getDistancePerLiter();
    double getTripDistance();
    String getName();

    default double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    default String getReport() {
        return getName() + " : " + (int) getChargeQuantity() + "리터\n";
    }
}
