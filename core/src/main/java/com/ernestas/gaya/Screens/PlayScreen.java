package com.ernestas.gaya.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ernestas.gaya.Backgrounds.Background;
import com.ernestas.gaya.Backgrounds.LoopedBackground;
import com.ernestas.gaya.Game.Level;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Ships.PlayerShip;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class PlayScreen implements Screen {

    private GayaEntry gaya;
    private InputProcessor input;

    private SpriteBatch batch;

    private Sprite shipSprite;

    private float shipSpeed = 150f;

    private LoopedBackground bg;
    private PlayerShip player;

    private Level level;

    public PlayScreen(GayaEntry gaya) {
        this.gaya = gaya;

        batch = new SpriteBatch();
        input = new InputProcessor();
        level = new Level(gaya, input);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(input);
        level.setup();

        shipSprite = GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipPlayer);
        shipSprite.setPosition(100, 100);

        player = new PlayerShip(shipSprite);

        Sprite bgSprite = GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.background);
        bgSprite.setOrigin(0, 0);
        bgSprite.setScale(Settings.getInstance().getWidth() / bgSprite.getWidth(), 1f);

        bg = new LoopedBackground(new Sprite(bgSprite), -60f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


//        update(delta);
        level.update(delta);

        batch.begin();
//        bg.render(batch);
//        player.getSprite().draw(batch);
        level.render(batch);
        batch.end();
    }

    public void update(float delta) {
        bg.update(delta);

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

        player.setPosition(player.getPosition().x + vecX * shipSpeed * delta,
                                player.getPosition().y + vecY * shipSpeed * delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
