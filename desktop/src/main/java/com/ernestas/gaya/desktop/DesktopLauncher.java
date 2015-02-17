package com.ernestas.gaya.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Util.Settings;

public class DesktopLauncher {
	public static void main (String[] arg) {
        double scale = 1.2;
        Settings.getInstance().setWidth((int) (320 * scale));
        Settings.getInstance().setHeight((int) (480 * scale));

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "Gaya pre-alpha v0.0.2";
        config.width = Settings.getInstance().getWidth();
        config.height = Settings.getInstance().getHeight();
        config.resizable = false;
//        config.useGL30 = true; // Use GL30 for performance improvement

        config.foregroundFPS = 2;
        config.backgroundFPS = 2;

        new LwjglApplication(new GayaEntry(), config);
	}
}
