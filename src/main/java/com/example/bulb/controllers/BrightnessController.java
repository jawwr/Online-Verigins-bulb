package com.example.bulb.controllers;

import com.example.bulb.model.BulbBrightnessLevel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/brightness")
@Tag(name = "BrightnessController")
public interface BrightnessController {
    @Operation(summary = "Get Brightness Levels", description = "Метод для получения возможных уровней яркости лампочки")
    @GetMapping("/")
    ResponseEntity<BulbBrightnessLevel> getBrightnessLevel();

    @Operation(summary = "Set Level", description = "Метод для изменения уровня яркости лампочки")
    @PostMapping("/")
    ResponseEntity<Boolean> setBrightnessLevel(@RequestParam("level") int Level);

    @Operation(summary = "Get Current Level", description = "Метод для определения уровня яркости")
    @GetMapping("/current")
    ResponseEntity<Integer> getCurrentLevel();
}
