package com.ernestas.gaya.Game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

//    Waves

//    Enemies

//    Player
    private PlayerShip player;

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

        bg = new LoopedBackground(new Sprite(bgSprite), -60f);
    }


    public void render(SpriteBatch batch) {
        bg.render(batch);
        player.getSprite().draw(batch);
    }

    public void update(float delta) {
        bg.update(delta);
        player.update(input, delta);
    }

}
