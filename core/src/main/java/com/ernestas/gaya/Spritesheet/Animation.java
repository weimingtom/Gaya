package com.ernestas.gaya.Spritesheet;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Animation {

    private Spritesheet spritesheet;
    private int frequency;
    private float deltaBucket = 0;
    private float framesPerSecond;

    private int currentAnimation = 0;
    private boolean iterationDone;

    public Animation(Spritesheet spritesheet, int posX, int posY, int frequency, float framesPerSecond) {
        this.spritesheet = spritesheet;
        setPosition(posX, posY);
        this.frequency = frequency;
        this.framesPerSecond = framesPerSecond;
    }

    public void update(float delta) {
        deltaBucket += delta;
        while (deltaBucket >= frequency * framesPerSecond) {
            deltaBucket -= frequency * framesPerSecond;
            currentAnimation++;
            if (currentAnimation == spritesheet.getAmount()) {
                currentAnimation = 0;
                iterationDone = true;
            }
        }
    }

    public Sprite getSprite() {
        return spritesheet.getSprite(currentAnimation);
    }

    public void setPosition(int posX, int posY) {
        spritesheet.setPosition(posX, posY);
    }

    public boolean iterationDone() {
        return iterationDone;
    }

    public float percentageDone() {
        return (currentAnimation + 1f) / spritesheet.getAmount();
    }

    public static float frameRateToDeltaRate(int framesPerSecond) {
        return 1f / framesPerSecond;
    }

}
