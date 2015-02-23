package com.ernestas.gaya.Ships;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class PlayerShip extends Ship {

    private Sprite sprite;
    private int health;
    private float speed;

    public PlayerShip() {
        super(new Vector2f(100, 100));
        this.health = 3;
        this.speed = 150f;
    }

    public PlayerShip(Sprite sprite) {
        this();
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        sprite.setPosition(position.x - bounds.getWidth() / 2, position.y - bounds.getHeight() / 2);
        return sprite;
    }

    public void update(InputProcessor input, float delta) {
        float vecX = 0;
        float vecY = 0;

        if (input.isPressed(Input.Keys.A) || input.isHold(Input.Keys.A)) {
            vecX += -1;
        }
        if (input.isPressed(Input.Keys.D) || input.isHold(Input.Keys.D)) {
            vecX += 1;
        }

        if (input.isPressed(Input.Keys.W) || input.isHold(Input.Keys.W)) {
            vecY += 1;
        }
        if (input.isPressed(Input.Keys.S) || input.isHold(Input.Keys.S)) {
            vecY += -1;
        }

        setPosition(getPosition().x + vecX * speed * delta,
            getPosition().y + vecY * speed * delta);
    }

}
