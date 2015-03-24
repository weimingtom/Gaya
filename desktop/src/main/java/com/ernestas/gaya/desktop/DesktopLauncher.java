package com.ernestas.gaya.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Util.Settings.Settings;

public class DesktopLauncher {
    private static final float SCALE = 1.4f;
    private static final String TITLE = "Gaya";
    private static final String VERSION = "v0.7";

	public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        Settings.getInstance().setScale(SCALE);
        Settings.getInstance().setWidth((int) (Settings.DEFAULT_WIDTH * SCALE));
        Settings.getInstance().setHeight((int) (Settings.DEFAULT_HEIGHT * SCALE));
        Settings.getInstance().setFrameRate(config.foregroundFPS);

        config.title = TITLE + " " + VERSION;
        config.width = Settings.getInstance().getWidth();
        config.height = Settings.getInstance().getHeight();
        config.resizable = false;
//        config.useGL30 = true; // Use GL30 for performance improvement

        new LwjglApplication(new GayaEntry(GayaEntry.DESKTOP), config);
	}
}
