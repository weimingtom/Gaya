package com.ernestas.gaya;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Util.Settings;

import java.util.ArrayList;

public class GayaEntry extends Game {

    public static final float DEFAULT_WIDTH = 320;
    public static final float DEFAULT_HEIGHT = 480;

	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

        Sprite sprite = new Sprite(img);
        sprite.setOrigin(0, 0);
        sprite.setScale(Settings.getInstance().getWidth() / DEFAULT_WIDTH, Settings.getInstance().getHeight() / DEFAULT_HEIGHT);
        sprite.draw(batch);
        batch.end();



        ShapeRenderer sr = new ShapeRenderer();
        Rectangle r = sprite.getBoundingRectangle();

        sr.setColor(Color.WHITE);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.rect(r.getX(), r.getY(), r.getWidth(), r.getHeight());
        sr.end();


        BitmapFont font = new BitmapFont();
        batch.begin();
        font.draw(batch, "My name is Earl", 100, 100);
        batch.end();
	}

}
