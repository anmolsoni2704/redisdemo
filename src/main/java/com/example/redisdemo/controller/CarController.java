package com.example.redisdemo.controller;

import com.example.redisdemo.model.Car;
import com.example.redisdemo.service.CarService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "car")
    public Car getCar(@PathVariable("id") Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("")
    @Cacheable(value = "car")
    public List<Car> getCars() {
        return carService.getAllCars();
    }

    @PostMapping("/create")
    @CachePut(key = "#car.company", value = "car")
    public Car createCar(@RequestBody Car car) {
       return carService.createCar(car.getCompany(), car.getModel());
    }
}
