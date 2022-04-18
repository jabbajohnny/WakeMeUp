package com.example.wakemeup;

import java.util.LinkedList;

public enum Themes {
    Default,
    Temple,
    Forest,
    Field,
    Motivation;

    public static LinkedList<String> themesValues;


    public static void initalize() {
        themesValues = new LinkedList<>();
        for (Themes t : Themes.values()) {
            themesValues.add(t.name());
        }
    }
}
