package com.ernestas.gaya.ResourceLoaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.Util.Settings.Settings;

import java.util.HashMap;

public class ResourceLoader {

    public enum ResourceId {
        splash, background, cloud, shipPlayer, shipEnemy
    }

    ResourcesPather pather;
    HashMap<ResourceId, Sprite> spriteMap = new HashMap<ResourceId, Sprite>();
    boolean loaded = false;

    public ResourceLoader(ResourcesPather pather) {
        if (pather != null) {
            this.pather = pather;
        } else {
            this.pather = ResourcesPather.defaultResourcesPather();
        }
    }

    public void load() {
        spriteMap.clear();
        try {
            loadResource(ResourceId.splash, pather.splash);
            loadResource(ResourceId.background, pather.background);
            loadResource(ResourceId.cloud, pather.cloud);
            loadResource(ResourceId.shipPlayer, pather.shipPlayer);
            loadResource(ResourceId.shipEnemy, pather.shipEnemy);

            loaded = true;
        } catch(Exception e) {
            e.printStackTrace(); // Handle it somehow different?
//            throw e;
        }
    }

    private void loadResource(ResourceId id, String path) {
        Texture texture = new Texture(path);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        Sprite sprite = new Sprite(texture);
        scaleSprite(sprite, Settings.getInstance().getScale());
        spriteMap.put(id, sprite);
    }

    private void scaleSprite(Sprite sprite, float scale) {
//        sprite.setOriginCenter();
        sprite.setOrigin(0, 0);
        sprite.setScale(scale);
    }

    public Sprite getResource(ResourceId id) {
        if (loaded == false) {
            return null;
        }

        Sprite sprite = spriteMap.get(id);
        return new Sprite(sprite);
    }

}
