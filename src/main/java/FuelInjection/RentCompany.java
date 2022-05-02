package FuelInjection;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    //본 클래스 자체가 일급콜렉션이 아닐까라는 생각이 들었음
    List<Car> cars;

    //factory method를 사용했으니 감출 수 있는건가?
    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() throws Exception {
        String result = "";

        for (Car car : cars) {
            result += car.getReport();
        }

        return result;
    }
}
