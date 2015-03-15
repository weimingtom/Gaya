package com.ernestas.gaya.ResourceLoaders;

public class ResourcesPather {

    // Images
    public String splash;
    public String background;
    public String cloud;

    // Ships
    public String shipPlayer;
    public String shipEnemy;


    // Sounds

    private ResourcesPather() {
    }

    public static ResourcesPather defaultResourcesPather() {
        ResourcesPather resourcesPather = new ResourcesPather();
        String defaultPath = "";

        resourcesPather.splash = defaultPath + "splash.png";
        resourcesPather.background = defaultPath + "clouds-transparent.png";//"desert-background-looped.png";
        resourcesPather.cloud = defaultPath + "clouds-transparent.png";
        resourcesPather.shipPlayer = defaultPath + "spaceship32.png";
        resourcesPather.shipEnemy = defaultPath + "enemyShip32.png";

        return resourcesPather;
    }

}
