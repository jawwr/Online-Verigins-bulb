package com.example.bulb.controllers;

import com.example.bulb.model.BulbColorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/color")
@Tag(name = "ColorController")
public interface ColorController {
    @Operation(summary = "Get Colors", description = "Метод для получения возможных цветов с их разъяснениями")
    @GetMapping("/")
    ResponseEntity<List<BulbColorDto>> getColors();

    @Operation(summary = "Set Color", description = "Метод для задания цвета лампочки")
    @PostMapping("/")
    ResponseEntity<Boolean> setColor(@RequestParam("color") String color);

    @Operation(summary = "Get Current Color", description = "Метод для определения цвета")
    @GetMapping("/current")
    ResponseEntity<BulbColorDto> getCurrentColor();

    @Operation(summary = "Get Color Names", description = "Метод для получения возможных наименований")
    @GetMapping("/names_only")
    ResponseEntity<List<String>> getColorNames();
}
