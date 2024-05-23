package com.example.redisdemo.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
    private CarService carService;

    public ScheduledTask(CarService carService) {
        this.carService = carService;
    }

    // secs mins hrs day month dayofweek
    // 0 0 9 * * * -> 9AM everyday
    // 0 0 17 * * 1 -> 5pm Monday

    @Scheduled(cron = "0 * * * * *")
    public void execute() {
        System.out.println("Cron job was called");
    }
}
