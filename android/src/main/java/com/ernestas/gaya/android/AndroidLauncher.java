package com.ernestas.gaya.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Util.Settings.Settings;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        //this.getWindow().getWindowManager().getDefaultDisplay().


        double scale = 1.0;
        Settings.getInstance().setWidth((int) (320 * scale));
        Settings.getInstance().setHeight((int) (480 * scale));


//        config.resizable = false;
////        config.useGL30 = true; // Use GL30 for performance improvement
//
//        config.foregroundFPS = 2;
//        config.backgroundFPS = 2;

		initialize(new GayaEntry(), config);
	}
}
