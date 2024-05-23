package com.example.redisdemo.service;

import com.example.redisdemo.model.Car;
import com.example.redisdemo.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car createCar(String company, String model) {
        Car car = new Car();
        car.setCompany(company);
        car.setModel(model);

        carRepository.save(car);

        return car;
    }

    public void deleteCars() {
        carRepository.deleteAll();
    }
}
