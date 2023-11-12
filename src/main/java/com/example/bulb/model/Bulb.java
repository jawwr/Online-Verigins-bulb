package com.example.bulb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bulb {
    private BulbColor color;
    private int brightness;
    private boolean isPowered;
}
