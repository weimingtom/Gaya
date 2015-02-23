package com.ernestas.gaya.Backgrounds;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoopedBackground {

    private Background background;
    private Background backgroundLoop;

    public LoopedBackground(Background background) {
        this.background = background;
        this.backgroundLoop = new Background(background);
        this.backgroundLoop.setPosition(background.getSprite().getX(), background.getSprite().getY() + background.getSprite().getHeight());
    }

    public LoopedBackground(Sprite sprite, float speed) {
        this(new Background(sprite, 0, speed));
    }

    public void update(float delta) {
        background.update(delta);
        backgroundLoop.update(delta);

        if (background.getSprite().getY() + background.getSprite().getHeight() < 0) {
            background.setPosition(backgroundLoop.getSprite().getX(), backgroundLoop.getSprite().getY());
            backgroundLoop.setPosition(background.getSprite().getX(), background.getSprite().getY() + background.getSprite().getHeight());
        }

    }

    public void render(SpriteBatch batch) {
        background.getSprite().draw(batch);
        backgroundLoop.getSprite().draw(batch);
    }

}
