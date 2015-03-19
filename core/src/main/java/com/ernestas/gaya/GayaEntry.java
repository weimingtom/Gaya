package com.ernestas.gaya;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.ResourceLoaders.ResourcesPather;
import com.ernestas.gaya.Screens.PlayScreen;
import com.ernestas.gaya.Screens.SplashScreen;
import com.ernestas.gaya.Ships.EnemyShip;
import com.ernestas.gaya.Ships.PlayerShip;
import com.ernestas.gaya.Util.Printable;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;
import com.ernestas.gaya.Validator.Validator;

import static com.ernestas.gaya.Util.Settings.Settings.*;

public class GayaEntry extends Game {

    public static final int DESKTOP = 0;
    public static final int ANDROID = 1;

    public final int DEVICE;

    private InputProcessor input;

    public GayaEntry(int device) {
        DEVICE = device;
    }

	@Override
	public void create () {
        input = new InputProcessor(DEVICE == ANDROID);
        if (DEVICE == ANDROID) {
            float scale = Gdx.graphics.getHeight() / DEFAULT_HEIGHT;
            if (Gdx.graphics.getWidth() / DEFAULT_WIDTH < scale) {
                scale = Gdx.graphics.getWidth() / DEFAULT_WIDTH;
            }

            Settings.getInstance().setScale(scale);
            Settings.getInstance().setWidth((int) (Settings.DEFAULT_WIDTH * scale));
            Settings.getInstance().setHeight((int) (Settings.DEFAULT_HEIGHT * scale));
        } else if (DEVICE == DESKTOP) {

        }

//        Validator val = new Validator("Scenarios/scenario1.json");
//        if (val.isValid()) {
//            System.out.println("FILE IS VALID!");
//        } else {
//            System.out.println("INVALID FILE!");
//        }


        GameSettings.getInstance().setResourceLoader(new ResourceLoader(ResourcesPather.defaultResourcesPather()));
        GameSettings.getInstance().getResourceLoader().load();


        setScreen(new PlayScreen(this));
	}


    public InputProcessor getInputProcessor() {
        return input;
    }
}
