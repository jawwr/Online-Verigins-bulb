package com.example.bulb.controllers;

import com.example.bulb.model.BulbColorDto;
import com.example.bulb.service.BulbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorControllerImpl implements ColorController {
    private final BulbService service;

    @Autowired
    public ColorControllerImpl(BulbService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<BulbColorDto>> getColors() {
        return ResponseEntity.ok(service.getColors());
    }

    @Override
    public ResponseEntity<Boolean> setColor(String color) {
        return ResponseEntity.ok(service.setColor(color));
    }

    @Override
    public ResponseEntity<BulbColorDto> getCurrentColor() {
        return ResponseEntity.ok(service.getCurrentColor());
    }

    @Override
    public ResponseEntity<List<String>> getColorNames() {
        return ResponseEntity.ok(service.getColorNames());
    }
}
