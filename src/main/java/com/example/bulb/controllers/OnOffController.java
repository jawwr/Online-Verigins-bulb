package com.example.bulb.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/state")
@Tag(name = "OnOffController")
public interface OnOffController {
    @Operation(summary = "Get State", description = "Метод для определения состояния")
    @GetMapping("/")
    ResponseEntity<Boolean> getState();

    @Operation(summary = "Turn On", description = "Метод для включения лампочки")
    @PostMapping("/on")
    ResponseEntity<Boolean> turnOn();

    @Operation(summary = "Turn Off", description = "Метод для отключения лампочки")
    @PostMapping("/off")
    ResponseEntity<Boolean> turnOff();
}
