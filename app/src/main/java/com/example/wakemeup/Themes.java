package com.example.wakemeup;

import java.util.HashMap;
import java.util.LinkedList;

public enum Themes {
    Vaporwave,
    Temple,
    Forest,
    Field,
    Default;

    public static LinkedList<String> themesValues = new LinkedList<>();
    public static HashMap<String, ThemeOptions> options = new HashMap<>();

    public static void initialize() {
        for (Themes t : Themes.values()) {
            themesValues.add(t.name());
        }

        options.put(Default.name(), new ThemeOptions(R.drawable.default_button, R.raw.default_ringtone, "It's time to wake up!"));
        options.put(Temple.name(), new ThemeOptions(R.drawable.temple_button, R.raw.temple, "Amen"));
        options.put(Forest.name(), new ThemeOptions(R.drawable.forest_button, R.raw.forest, "Birds are singing!"));
        options.put(Field.name(), new ThemeOptions(R.drawable.field_button, R.raw.field, "Herbs are growing!"));
        options.put(Vaporwave.name(), new ThemeOptions(R.drawable.vaporwave_button, R.raw.vaporwave, "ｅｎｔｅｒｉｎｇ  ｔｈｅ  ｐｌａｚａ．．．"));

    }

    public static class ThemeOptions {
        int background;
        int sound;
        String message;

        public ThemeOptions(int background, int sound, String message) {
            this.background = background;
            this.sound = sound;
            this.message = message;
        }
    }
}
