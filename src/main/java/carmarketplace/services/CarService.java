package carmarketplace.services;

import carmarketplace.entity.Car;
import carmarketplace.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }
}
