package com.ernestas.gaya.Ships;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class PlayerShip extends Ship {

    private static final int DEFAULT_HEALTH = 3;
    private static final float DEFAULT_SPEED = 150f;

    private Sprite sprite = null;
    private int health = DEFAULT_HEALTH;
    private float speed = DEFAULT_SPEED;

    public PlayerShip(Vector2f position) {
        super(position);
    }

    public PlayerShip(Sprite sprite, Vector2f position) {
        this(position);
        this.sprite = sprite;
        setBounds(sprite.getBoundingRectangle());
        setPosition(getPosition());
    }

    public Sprite getSprite() {
        if (sprite != null) {
            sprite.setPosition(position.x - bounds.getWidth() / 2, position.y - bounds.getHeight() / 2);
        }
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

        if (vecX != 0)
            move(vecX, 0, delta);
        if (vecY != 0)
            move(0, vecY, delta);

    }

    private void move(float vecX, float vecY, float delta) {
        float x = getPosition().x + vecX * speed * delta;
        float y = getPosition().y + vecY * speed * delta;

        float boX = bounds.width / 2;
        float boY = bounds.height / 2;

        if (x - boX >= 0 && x + boX <= Settings.getInstance().getWidth() &&
            y - boY >= 0 && y + boY <= Settings.getInstance().getHeight()) {

            setPosition(x, y);
        }
    }

}
