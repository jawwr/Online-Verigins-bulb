package com.example.bulb.controllers;

import com.example.bulb.model.BulbBrightnessLevel;
import com.example.bulb.service.BulbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrightnessControllerImpl implements BrightnessController {
    private final BulbService service;

    @Autowired
    public BrightnessControllerImpl(BulbService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<BulbBrightnessLevel> getBrightnessLevel() {
        return ResponseEntity.ok(service.getBrightnessLevel());
    }

    @Override
    public ResponseEntity<Boolean> setBrightnessLevel(int level) {
        return ResponseEntity.ok(service.setBrightness(level));
    }

    @Override
    public ResponseEntity<Integer> getCurrentLevel() {
        return ResponseEntity.ok(service.getCurrentBrightness());
    }
}
