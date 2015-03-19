package com.ernestas.gaya.Spritesheet;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.ResourceLoaders.SpriteScaler;
import com.ernestas.gaya.Util.Settings.Settings;

import java.util.ArrayList;
import java.util.List;

public class Spritesheet {

    private List<Sprite> spriteList = new ArrayList<Sprite>();

    public Spritesheet(Texture texture, int width, int height, int amount) {
        int srcWidth = texture.getWidth() / width;
        int srcHeight = texture.getHeight() / height;
        for (int y = 0; y < srcHeight; ++y) {
            for (int x = 0; x < srcWidth; ++x) {
                if (spriteList.size() >= amount) {
                    break;
                } else {
                    Sprite sprite = new Sprite(texture, width * x, height * y, width, height);
                    sprite = SpriteScaler.scaleSprite(sprite, Settings.getInstance().getScale());
                    spriteList.add(sprite);
                }
            }
        }
    }

    public void setPosition(int x, int y) {
        for (Sprite sprite: spriteList) {
            sprite.setPosition(x, y);
        }
    }

    public int getAmount() {
        return spriteList.size();
    }

    public Sprite getSprite(int index) {
        if (index < 0 || index >= spriteList.size()) {
            return null;
        } else {
            return spriteList.get(index);
        }
    }

}
