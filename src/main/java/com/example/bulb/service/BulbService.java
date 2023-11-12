package com.example.bulb.service;

import com.example.bulb.model.BulbBrightnessLevel;
import com.example.bulb.model.BulbColorDto;

import java.util.List;

public interface BulbService {
    boolean getCurrentState();

    boolean setState(boolean state);

    int getCurrentBrightness();

    boolean setBrightness(int level);

    BulbBrightnessLevel getBrightnessLevel();

    BulbColorDto getCurrentColor();

    List<String> getColorNames();

    List<BulbColorDto> getColors();

    boolean setColor(String color);
}
