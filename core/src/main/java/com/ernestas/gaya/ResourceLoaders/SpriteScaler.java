package com.ernestas.gaya.ResourceLoaders;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteScaler {

    private SpriteScaler(){}

    public static Sprite scaleSprite(Sprite sprite, float scale) {
        Sprite result = new Sprite(sprite);

        result.setOrigin(0, 0);
        result.setScale(scale);

        return result;
    }

}
