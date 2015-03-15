package com.ernestas.gaya.Game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Backgrounds.LoopedBackground;
import com.ernestas.gaya.Gameplay.Scenario;
import com.ernestas.gaya.Gameplay.Wave;
import com.ernestas.gaya.GayaEntry;
import com.ernestas.gaya.Input.InputProcessor;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Ships.EnemyShip;
import com.ernestas.gaya.Ships.PlayerShip;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;
import com.ernestas.gaya.Util.Vectors.Vector2f;

import java.util.LinkedList;
import java.util.List;

public class Level {

    private GayaEntry gaya;
    private InputProcessor input;

//    Scenario
    Scenario scenario;

//    Waves
    List<Wave> waves = new LinkedList<Wave>();

//    Background
    private LoopedBackground bg;
    private float backgroundSpeed = 30f;

//    Player
    private PlayerShip player;

//    Time
    private float gameTime = 0;

    // Debug
    private boolean debug = false;
    private boolean paused = false;


    public Level(GayaEntry gaya, InputProcessor input) {
        this.gaya = gaya;
        this.input = input;
    }

    public void setup() {
        //TODO: do stuff
        scenario = Scenario.getTestScenario();

        Sprite playerSprite = GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipPlayer);
        player = new PlayerShip(playerSprite, new Vector2f(Settings.getInstance().getWidth() / 2, 100));

        Sprite bgSprite = GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.background);
        bgSprite.setScale((Settings.getInstance().getWidth() / bgSprite.getWidth()), bgSprite.getScaleY());
        bg = new LoopedBackground(new Sprite(bgSprite), -backgroundSpeed, false);
    }


    public void render(SpriteBatch batch) {
        bg.render(batch);

        if (bg != null) {
            return;
        }

        player.getSprite().draw(batch);

        for (int i = 0; i < waves.size(); ++i) {
            List<Wave.EnemyWithOffset> enemyList = waves.get(i).getEnemyList();
            for (int index = 0; index < enemyList.size(); ++index) {
                EnemyShip enemy = enemyList.get(index).ship;
                enemy.getSprite().draw(batch);
            }
        }

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
            for (int i = 0; i < waves.size(); ++i) {
                List<Wave.EnemyWithOffset> enemyList = waves.get(i).getEnemyList();
                for (int index = 0; index < enemyList.size(); ++index) {
                    EnemyShip enemy = enemyList.get(index).ship;
                    rec = enemy.getSprite().getBoundingRectangle();
                    renderer.rect(rec.x, rec.y, rec.width, rec.height);
                }
            }


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
        if (input.isPressedAdvanced(Input.Keys.P)) {
            paused = !paused;
        }

        if (paused) {
            return;
        }

        gameTime += backgroundSpeed * delta;


        bg.update(delta);
        if (bg != null) {
            return;
        }

        player.update(input, delta);

        while (scenario.event(gameTime) != Scenario.NO_EVENT) {
            if (scenario.event(gameTime) == Scenario.NEW_WAVE) {
                Wave wave = scenario.getWave(gameTime);
                if (wave != null) {
                    waves.add(wave);
                }
            }

            if (scenario.event(gameTime) == Scenario.NEW_PICKUP) {
                break;
            }
        }
        for (int i = 0; i < waves.size(); ++i) {
            List<Wave.EnemyWithOffset> enemyList = waves.get(i).getEnemyList();
            for (int index = 0; index < enemyList.size(); ++index) {
                // update ship
                EnemyShip enemy = enemyList.get(index).ship;
                enemy.update(delta);

                // check collision
                if (player.getBounds().overlaps(enemy.getBounds())) {
                    System.out.println("COLLISION");
                }

                if (enemy.canRemove()) {
                    enemyList.remove(index);
                    --index;
                }
            }

            if (waves.get(i).waveCompleted()) {
                waves.remove(i);
                --i;
            }
        }

        if (scenario.scenarioCompleted() && waves.isEmpty()) {
            System.out.println("GAME FINISHED");
        }
    }

}
