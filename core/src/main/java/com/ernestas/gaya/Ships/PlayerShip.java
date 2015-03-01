package com.ernestas.gaya.Ships;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class PlayerShip extends Ship {

    private Sprite sprite;
    private int health;
    private float speed;

    private Rectangle flyBounds;

    public PlayerShip() {
        super(new Vector2f(100, 100));
        this.health = 3;
        this.speed = 150f;
        this.flyBounds = new Rectangle(0, 0, Settings.getInstance().getWidth(), Settings.getInstance().getHeight());
    }

    public PlayerShip(Sprite sprite) {
        this();
        this.sprite = sprite;
        setBounds(sprite.getBoundingRectangle());
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

    public Rectangle getFlyBounds() { return flyBounds; }
    public void setFlyBounds(Rectangle flyBounds) { this.flyBounds = flyBounds; }

}
