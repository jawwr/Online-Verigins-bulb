package com.example.bulb.service;

import com.example.bulb.model.Bulb;
import com.example.bulb.model.BulbBrightnessLevel;
import com.example.bulb.model.BulbColor;
import com.example.bulb.model.BulbColorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class BulbServiceImpl implements BulbService {

    private static final Bulb BULB = new Bulb(BulbColor.WHITE, 100, true);
    private static final BulbBrightnessLevel BULB_BRIGHTNESS_LEVEL = new BulbBrightnessLevel(100, 0, 1);
    private static final Map<BulbColor, BulbColorDto> COLORS = new HashMap<>();

    static {
        var colors = BulbColor.values();
        for (int i = 0; i < colors.length; i++) {
            var color = colors[i];
            COLORS.put(color, new BulbColorDto(i, color.name(), color.toString(), color.colorName));
        }
    }

    @Override
    public boolean getCurrentState() {
        return BULB.isPowered();
    }

    @Override
    public boolean setState(boolean state) {
        BULB.setPowered(state);
        return true;
    }

    @Override
    public int getCurrentBrightness() {
        if (!BULB.isPowered()) {
            throw new IllegalArgumentException("Bulb turned off");
        }
        return BULB.getBrightness();
    }

    @Override
    public boolean setBrightness(int level) {
        if (!BULB.isPowered()) {
            throw new IllegalArgumentException("Bulb turned off");
        }
        if (level < BULB_BRIGHTNESS_LEVEL.min() || level > BULB_BRIGHTNESS_LEVEL.max()) {
            throw new IllegalArgumentException("Level must be more" + BULB_BRIGHTNESS_LEVEL.min() + " and less than " + BULB_BRIGHTNESS_LEVEL.max());
        }
        BULB.setBrightness(level);
        return true;
    }

    @Override
    public BulbBrightnessLevel getBrightnessLevel() {
        return BULB_BRIGHTNESS_LEVEL;
    }

    @Override
    public BulbColorDto getCurrentColor() {
        if (!BULB.isPowered()) {
            throw new IllegalArgumentException("Bulb turned off");
        }
        return COLORS.get(BULB.getColor());
    }

    @Override
    public List<String> getColorNames() {
        return Arrays.stream(BulbColor.values()).map(x -> x.colorName).toList();
    }

    @Override
    public List<BulbColorDto> getColors() {
        return COLORS.values().stream().toList();
    }

    @Override
    public boolean setColor(String color) {
        if (!BULB.isPowered()) {
            throw new IllegalArgumentException("Bulb turned off");
        }
        BulbColor bulbColor;
        try {
            bulbColor = BulbColor.valueOf(color.toUpperCase());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("Color " + color + " does not exist");
        }
        BULB.setColor(bulbColor);
        return true;
    }
}
