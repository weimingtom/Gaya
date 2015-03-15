package com.ernestas.gaya.Ships;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class EnemyShip extends Ship {

    public static class Builder {
        private EnemyShip ship;

        public Builder() {
            ship = new EnemyShip();
        }

        public Builder withSprite(Sprite sprite) {
            ship.setSprite(sprite);
            return this;
        }

        public Builder withHealth(int health) {
            ship.setHealth(health);
            return this;
        }

        public Builder withSpeed(float speed) {
            ship.setSpeed(speed);
            return this;
        }

        public Builder withPosition(Vector2f pos) {
            ship.setPosition(pos.x, pos.y);
            return this;
        }

        public EnemyShip build() {
            return ship;
        }

    }

    private Sprite sprite;
    private int health;
    private float speed;

    private EnemyShip() {
        this.sprite = null;
        this.health = 0;
        this.speed = 0f;
    }

    public EnemyShip(Sprite sprite, int health, float speed) {
        this.sprite = sprite;
        this.health = health;
        this.speed = speed;
    }

    public void update(float delta) {
        //TODO: AI
        setPosition(position.x, position.y - speed * delta);
    }

    public boolean canRemove() {
        return getPosition().y + sprite.getHeight() < 0;
    }

    public Sprite getSprite() {
        if (sprite != null) {
            sprite.setPosition(position.x - bounds.getWidth() / 2, position.y - bounds.getHeight() / 2);
        }
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
        setBounds(sprite.getBoundingRectangle());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
