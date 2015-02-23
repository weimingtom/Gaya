package com.ernestas.gaya.Backgrounds;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Background {

    private Sprite sprite;
    private float xSpeed;
    private float ySpeed;

    public Background(Sprite sprite, float xSpeed, float ySpeed) {
        this.sprite = new Sprite(sprite);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Background(Background background) {
        this.sprite = new Sprite(background.getSprite());
        this.xSpeed = background.getXSpeed();
        this.ySpeed = background.getYSpeed();
    }

    public void update(float delta) {
        float x = sprite.getX();
        float y = sprite.getY();

        sprite.setPosition(x + xSpeed * delta, y + ySpeed * delta);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getXSpeed() {return xSpeed;}
    public float getYSpeed() {return ySpeed;}

    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

}
