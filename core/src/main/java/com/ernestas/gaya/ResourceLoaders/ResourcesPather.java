package com.ernestas.gaya.ResourceLoaders;

public class ResourcesPather {

    // Images
    public String splash;
    public String background;

    // Ships
    public String shipPlayer;


    // Sounds

    private ResourcesPather() {
    }

    public static ResourcesPather defaultResourcesPather() {
        ResourcesPather resourcesPather = new ResourcesPather();
        String defaultPath = "";

        resourcesPather.splash = defaultPath + "splash.png";
        resourcesPather.background = defaultPath + "desert-background-looped.png";
        resourcesPather.shipPlayer = defaultPath + "spaceship32.png";

        return resourcesPather;
    }

}
