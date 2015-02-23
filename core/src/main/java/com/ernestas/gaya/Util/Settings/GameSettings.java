package com.ernestas.gaya.Util.Settings;

import com.ernestas.gaya.ResourceLoaders.ResourceLoader;

public class GameSettings {
    /********************************************************/
    private static GameSettings instance = null;

    private GameSettings() {}

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public static void reset() { instance = null; }
    /********************************************************/

    private ResourceLoader resourceLoader;


    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }



}
