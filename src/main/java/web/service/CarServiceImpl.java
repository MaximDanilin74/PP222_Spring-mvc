package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getAllCars() {
        return getCars();
    }

    @Override
    public List<Car> getCars(int count) {
        List<Car> allCars = getAllCars();
        return allCars.subList(0, Math.min(count, allCars.size()));
    }

    private List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car(2021, "Black", "Toyota RAV"));
        cars.add(new Car(2020, "Gray", "Ford F150"));
        cars.add(new Car(2024, "Silver", "RAM 1500"));
        cars.add(new Car(2015, "Red", "Audi A6"));
        cars.add(new Car(2016, "Blue", "BMW X5"));
        return cars;
    }
}
