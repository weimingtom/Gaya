package com.ernestas.gaya;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.ResourceLoaders.ResourcesPather;
import com.ernestas.gaya.Screens.PlayScreen;
import com.ernestas.gaya.Screens.SplashScreen;
import com.ernestas.gaya.Ships.EnemyShip;
import com.ernestas.gaya.Ships.PlayerShip;
import com.ernestas.gaya.Util.Printable;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public class GayaEntry extends Game {

    public static final float DEFAULT_WIDTH = 320;
    public static final float DEFAULT_HEIGHT = 480;

	@Override
	public void create () {
        GameSettings.getInstance().setResourceLoader(new ResourceLoader(ResourcesPather.defaultResourcesPather()));
        GameSettings.getInstance().getResourceLoader().load();


        Printable s;

        s = new PlayerShip(new Vector2f());
        s.println();

        s = new EnemyShip(new Sprite(), 0, 0);
        s.println();



        setScreen(new PlayScreen(this));
	}



}
