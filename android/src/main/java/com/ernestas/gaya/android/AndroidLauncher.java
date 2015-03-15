package com.ernestas.gaya.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Util.Settings.Settings;

public class AndroidLauncher extends AndroidApplication {
    private static final float SCALE = 1f;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        //this.getWindow().getWindowManager().getDefaultDisplay().



        Settings.getInstance().setScale(SCALE);
        Settings.getInstance().setWidth((int) (Settings.DEFAULT_WIDTH * SCALE));
        Settings.getInstance().setHeight((int) (Settings.DEFAULT_HEIGHT * SCALE));


//        config.resizable = false;
////        config.useGL30 = true; // Use GL30 for performance improvement
//
//        config.foregroundFPS = 2;
//        config.backgroundFPS = 2;

		initialize(new GayaEntry(), config);
	}
}
