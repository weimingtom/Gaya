package com.ernestas.gaya.Backgrounds;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class BgCloud {

    private Sprite sprite;
    private float speed;

    public BgCloud(Sprite sprite, Vector2f position, float speed) {
        this.sprite = sprite;
        this.speed = speed;
        sprite.setPosition(position.x, position.y);
    }

    public void update(float delta) {
        sprite.setPosition(sprite.getX(), sprite.getY() - delta * speed);
    }

    public boolean isFinished() {
        return sprite.getY() + sprite.getHeight() < 0;
    }


    public Sprite getSprite() {
        return sprite;
    }
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public float getY() { return sprite.getY(); }
}
