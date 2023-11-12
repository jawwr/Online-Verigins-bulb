package com.example.bulb.model;

public record BulbBrightnessLevel(
        int max,
        int min,
        int precision
) {
}
