package FuelInjection;

public class Sonata implements Car {
    double tripDistance;

    public Sonata(double tripDistance) {
        //abstract로 만들어진 Car를 extend받았으면 super(tripDistance)가 됐을것
        this.tripDistance = tripDistance;
    }

    @Override
    public double getDistancePerLiter() {
        return 10;
    }

    @Override
    public double getTripDistance() {
        return tripDistance;
    }

    @Override
    public String getName() {
        return "Sonata";
    }
}
