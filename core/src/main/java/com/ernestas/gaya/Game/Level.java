package com.ernestas.gaya.Game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Backgrounds.LoopedBackground;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.ResourceLoaders.ResourcesPather;
import com.ernestas.gaya.Ships.PlayerShip;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;

public class Level {

    private GayaEntry gaya;
    private InputProcessor input;


//    Background
    private LoopedBackground bg;
    private float backgroundSpeed = 30f;

//    Waves

//    Enemies

//    Player
    private PlayerShip player;


    // Debug
    private boolean debug = false;


    public Level(GayaEntry gaya, InputProcessor input) {
        this.gaya = gaya;
        this.input = input;
    }

    public void setup() {
        //TODO: do stuff

        player = new PlayerShip(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipPlayer));

        Sprite bgSprite = GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.background);
        bgSprite.setOrigin(0, 0);
        bgSprite.setScale(Settings.getInstance().getWidth() / bgSprite.getWidth(), 1f);

        bg = new LoopedBackground(new Sprite(bgSprite), -backgroundSpeed, true);
    }


    public void render(SpriteBatch batch) {
        bg.render(batch);
        player.getSprite().draw(batch);

        if (debug) {
            batch.end();
            Rectangle rec = player.getBounds();
            ShapeRenderer renderer = new ShapeRenderer();

            renderer.begin(ShapeRenderer.ShapeType.Line);

            // player
            renderer.setColor(Color.RED);
            renderer.rect(rec.x, rec.y, rec.width, rec.height);

            // enemies
            renderer.setColor(Color.BLUE);


            // pickups
            renderer.setColor(Color.GREEN);


            renderer.end();

            batch.begin();
        }
    }

    public void update(float delta) {
        if (input.isPressedAdvanced(Input.Keys.STAR)) {
            debug = !debug;
        }

        bg.update(delta);
        player.update(input, delta);
    }

}
