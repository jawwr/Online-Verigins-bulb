package com.example.bulb.controllers;

import com.example.bulb.service.BulbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnOffControllerImpl implements OnOffController {
    private final BulbServiceImpl service;

    @Autowired
    public OnOffControllerImpl(BulbServiceImpl service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Boolean> getState() {
        return ResponseEntity.ok(service.getCurrentState());
    }

    @Override
    public ResponseEntity<Boolean> turnOn() {
        return ResponseEntity.ok(service.setState(true));
    }

    @Override
    public ResponseEntity<Boolean> turnOff() {
        return ResponseEntity.ok(service.setState(false));
    }
}
