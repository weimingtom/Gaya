package com.ernestas.gaya.ResourceLoaders;

public class ResourcesPather {

    // Images
    public String splash;
    public String background;
    public String cloud;

    // Player Ship
    public String shipPlayer;

    // Enemy Ship
    public String shipGreen;

    public String simpleBullet;

    // FX
    public String explosionSS;

    // Sounds

    private ResourcesPather() {
    }

    public static ResourcesPather defaultResourcesPather() {
        ResourcesPather resourcesPather = new ResourcesPather();
        String defaultPath = "Sprites/";

        return defaultResourcesPather(defaultPath);
    }

    public static ResourcesPather defaultResourcesPather(String defaultPath) {
        ResourcesPather resourcesPather = new ResourcesPather();

        resourcesPather.splash = defaultPath + "splash.png";
        resourcesPather.background = defaultPath + "desert-background-looped.png";
        resourcesPather.cloud = defaultPath + "clouds-transparent.png";
        resourcesPather.shipPlayer = defaultPath + "spaceship32.png";
        resourcesPather.shipGreen = defaultPath + "greenShip.png";
        resourcesPather.explosionSS = defaultPath + "explosionSS.png";
        resourcesPather.simpleBullet = defaultPath + "bullets/simpleBullet.png";

        return resourcesPather;
    }

}
