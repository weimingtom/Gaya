package com.ernestas.gaya.Util.Settings;

public class Settings {
    /********************************************************/
    private static Settings instance = null;

    private Settings() {}

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public static void reset() {
        instance = null;
    }
    /********************************************************/


    private int width;
    private int height;


    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
