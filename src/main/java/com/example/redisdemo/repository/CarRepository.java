package com.example.redisdemo.repository;

import com.example.redisdemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {}
