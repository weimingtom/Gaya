package com.ernestas.gaya.Backgrounds;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoopedBackground {

    private int debugTick = 0;

    //TODO: Make a container of Backgrounds in case background.height < screen.height / 2
    private Background background;
    private Background backgroundLoop;

    private List<BgCloud> clouds = new ArrayList<BgCloud>();
    private final float cloudSpeed = 50f;
    private boolean cloudsEnabled;

    public LoopedBackground(Background background, boolean cloudsEnabled) {
        this.background = background;
        this.backgroundLoop = new Background(background);
        this.cloudsEnabled = cloudsEnabled;
        this.backgroundLoop.setPosition(background.getSprite().getX(), background.getSprite().getY() + background.getSprite().getHeight()* background.getSprite().getScaleY());
    }

    public LoopedBackground(Sprite sprite, float speed, boolean cloudsEnabled) {
        this(new Background(sprite, 0, speed), cloudsEnabled);
    }

    public void update(float delta) {
        if (cloudsEnabled) {
            updateClouds(delta);
        }

        background.update(delta);
        backgroundLoop.update(delta);

//        System.out.println("height: " + background.getSprite().getHeight()* background.getSprite().getScaleY());
        Sprite bgSprite = background.getSprite();

        if (bgSprite.getY() + bgSprite.getHeight() * bgSprite.getScaleY() < 0) {
            background.setPosition(backgroundLoop.getSprite().getX(), backgroundLoop.getSprite().getY());
            backgroundLoop.setPosition(background.getSprite().getX(), background.getSprite().getY() + background.getSprite().getHeight() * bgSprite.getScaleY());
        }

        debugTick++;
        if (debugTick > 30) {
            debugTick = 0;
            System.out.println("bg --> " + background.getSprite().getY());
            System.out.println("bgLoop --> " + backgroundLoop.getSprite().getY());
            System.out.println("height --> " + background.getSprite().getHeight() * background.getSprite().getScaleY());
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
        background.getSprite().draw(batch);
        backgroundLoop.getSprite().draw(batch);

        if (cloudsEnabled) {
            for (int i = 0; i < clouds.size(); ++i) {
                clouds.get(i).getSprite().draw(batch);
            }
        }
    }

}
