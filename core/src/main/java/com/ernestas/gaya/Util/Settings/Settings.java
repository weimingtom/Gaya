package com.ernestas.gaya.Util.Settings;

public class Settings {
    public static final int DEFAULT_WIDTH = 320;
    public static final int DEFAULT_HEIGHT = 480;

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
    private float scale;
    private int frameRate;

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
    public float getScale() {
        return scale;
    }
    public void setScale(float scale) {
        this.scale = scale;
    }
    public int getFrameRate() { return frameRate; }
    public void setFrameRate(int frameRate) { this.frameRate = frameRate; }

}
