package com.ernestas.gaya.Gameplay;

import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Ships.EnemyShip;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;

import java.util.LinkedList;
import java.util.List;

public class Scenario {

    public static final int NO_EVENT = 0;
    public static final int NEW_WAVE = 1;
    public static final int NEW_PICKUP = 2;

    // TODO: make sorted list
    private List<Wave> waves = new LinkedList<Wave>();

    public Scenario() {

    }

    public int event(float offset) {
        for (int i = 0; i < waves.size(); ++i) {
            if (waves.get(i).getOffset() <= offset) {
                return NEW_WAVE;
            }
        }
        return NO_EVENT;
    }

    public void addWave(Wave wave) {
        if (!waves.contains(wave)) {
            waves.add(wave);
        }
    }

    public Wave getWave(float offset) {
        for (int i = 0; i < waves.size(); ++i) {
            Wave wave = waves.get(i);
            if (wave.getOffset() <= offset) {
                waves.remove(i);
                return wave;
            }
        }

        return null;
    }

    public boolean scenarioCompleted() {
        return waves.isEmpty();
    }

    public List<Wave> getWaves() { return waves; }


    public static Scenario getTestScenario() {
        Scenario scenario = new Scenario();

        Wave wave = new Wave.Builder()
            .withOffset(100f)
            .withEnemy(new Wave.EnemyWithOffset(
                0, 0, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                -64, 64, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                64, 64, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .build()
            ;


        Wave wave1 = new Wave.Builder()
            .withOffset(200f)
            .withEnemy(new Wave.EnemyWithOffset(
                0, 0, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                -64, 64, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                64, 64, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                -128, 96, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                0, 96, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .withEnemy(new Wave.EnemyWithOffset(
                128, 96, new EnemyShip.Builder()
                .withSprite(GameSettings.getInstance().getResourceLoader().getResource(ResourceLoader.ResourceId.shipEnemy))
                .withHealth(1)
                .withSpeed(60f)
                .build()))
            .build()
            ;


        scenario.addWave(wave);
        scenario.addWave(wave1);
        return scenario;
    }

}
