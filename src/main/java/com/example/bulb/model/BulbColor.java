package com.example.bulb.model;

public enum BulbColor {
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    WHITE("white"),
    TEAL("teal"),
    BROWN("brown"),
    CORAL("coral"),
    CYAN("cyan"),
    GOLD("gold"),
    YELLOW("yellow"),
    INDIGO("indigo"),
    MAROON("maroon"),
    MEDIUMPURPLE("mediumpurple"),
    PINK("pink"),
    PERU("peru"),
    SEAGREEN("seagreen"),
    SLATEBLUE("slateblue"),
    TOMATO("tomato"),
    PURPLE("purple");

    public final String colorName;
    BulbColor(String colorName) {
        this.colorName = colorName;
    }
}
