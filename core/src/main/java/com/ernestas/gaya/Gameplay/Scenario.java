package com.ernestas.gaya.Gameplay;

import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.Ships.EnemyShip;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;

import java.util.Collections;
import java.util.Comparator;
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

    public int event() {
        // Powerups
        return NO_EVENT;
    }

    public void addWave(Wave wave) {
        if (!waves.contains(wave)) {
            waves.add(wave);
            sort();
        }
    }

    public Wave getNextWave() {
        Wave wave = Wave.EMPTY_WAVE;
        if (!waves.isEmpty()) {
            wave = waves.get(0);
            waves.remove(0);
        }
        return wave;
    }

    private void sort() {
        Collections.sort(waves, new Comparator<Wave>() {
            @Override
            public int compare(Wave wave1, Wave wave2) {
                return wave1.getId() - wave2.getId();
            }
        });
    }

    public boolean scenarioCompleted() {
        return waves.isEmpty();
    }

    public List<Wave> getWaves() { return waves; }


    public static Scenario getTestScenario() {
        Scenario scenario = new Scenario();

        Wave wave = new Wave.Builder()
            .withId(0)
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
            .withId(1)
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
