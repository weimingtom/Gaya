package com.ernestas.gaya.Backgrounds;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

import java.util.*;

public class LoopedBackground {
    private Background background;

    private Queue<Background> bgs = new LinkedList<Background>();
    private List<BgCloud> clouds = new ArrayList<BgCloud>();
    private final float cloudSpeed = 50f;
    private boolean cloudsEnabled;

    public LoopedBackground(Background background, boolean cloudsEnabled) {
        this.background = background;
        this.cloudsEnabled = cloudsEnabled;
        init();
    }

    public LoopedBackground(Sprite sprite, float speed, boolean cloudsEnabled) {
        this(new Background(sprite, 0, speed), cloudsEnabled);
    }

    private void init() {
        float posX = 0;
        float posY = 0;
        while(true) {
            Background bg = new Background(background);
            bg.setPosition(posX, posY);
            bgs.add(bg);

            posX = left(bg);
            posY = top(bg);

            if (bottom(bg) > Settings.getInstance().getHeight()) {
                break;
            }
        }
    }

    public void update(float delta) {
        if (cloudsEnabled) {
            updateClouds(delta);
        }

        for (Background bg : bgs) {
            bg.update(delta);
        }

        if (top(bgs.peek()) < 0) {
            Background bg = bgs.poll();
            Background last = lastBg();
            bg.setPosition(left(last), top(last));
            bgs.add(bg);
        }

    }

    private void updateClouds(float delta) {
        for (int i = 0; i < clouds.size(); ++i) {
            BgCloud cloud = clouds.get(i);
            cloud.update(delta);
            if (cloud.isFinished()) {
                clouds.remove(i);
                --i;
            }
        }

        // TODO: Make a method for adding clouds
        Random r = new Random();
        float lastY = clouds.size() > 0 ? clouds.get(clouds.size() - 1).getY() : 0;
        while (lastY < Settings.getInstance().getHeight()) {
            Sprite cloudSprite = GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.cloud);
            clouds.add(new BgCloud(cloudSprite,
                        new Vector2f(Math.abs(r.nextFloat() * Settings.getInstance().getWidth() - cloudSprite.getWidth() / 2),
                        Math.abs(r.nextFloat() * 300) + lastY + 20), cloudSpeed));

            lastY = clouds.get(clouds.size() - 1).getY();
        }

    }

    public void render(SpriteBatch batch) {
        for (Background bg : bgs) {
            bg.getSprite().draw(batch);
        }

        if (cloudsEnabled) {
            for (int i = 0; i < clouds.size(); ++i) {
                clouds.get(i).getSprite().draw(batch);
            }
        }
    }


    private Background lastBg() {
        Background bg = null;
        for (Background background : bgs) {
            bg = background;
        }
        return bg;
    }

    private float left(Background background) {
        return background.getSprite().getX();
    }
    private float top(Background background) {
        return background.getSprite().getY() + background.getSprite().getHeight() * background.getSprite().getScaleY();
    }
    private float bottom(Background background) {
        return background.getSprite().getY();
    }
}
