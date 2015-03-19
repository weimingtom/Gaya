package com.ernestas.gaya.Ships.Bullets;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Ships.Ship;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class SimpleBullet extends Bullet {

    public SimpleBullet(Ship author, Vector2f position) {
        super(author,
                GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.simpleBullet),
                250f,
                new Vector2f(0, 1),
                position,
                1);
    }

    @Override
    public Rectangle getBounds() {
        Rectangle bounds = sprite.getBoundingRectangle();

        return bounds;
    }



}
