package com.ernestas.gaya.Gameplay;

import com.ernestas.gaya.Ships.EnemyShip;
import com.ernestas.gaya.Ships.Ship;
import com.ernestas.gaya.Util.Settings.Settings;

import java.util.LinkedList;
import java.util.List;

public class Wave {

    public static class EnemyWithOffset {
        public float offsetX;
        public float offsetY;
        public EnemyShip ship;

        public EnemyWithOffset(float offsetX, float offsetY, EnemyShip ship) {
            this.offsetX = offsetX * Settings.getInstance().getScale();
            this.offsetY = offsetY * Settings.getInstance().getScale();
            this.ship = ship;
        }

    }

    public static class Builder {
        private Wave wave;

        public Builder() {
            wave = new Wave();
        }

        public Builder withEnemy(EnemyWithOffset enemy) {
            wave.addEnemy(enemy);
            return this;
        }

        public Builder withId(int id) {
            wave.id = id;
            return this;
        }

        public Wave build() {
            prepareEnemies();
            return wave;
        }

        private void prepareEnemies() {
            for (int i = 0; i < wave.enemyList.size(); ++i) {
                EnemyWithOffset enemy = wave.enemyList.get(i);
                enemy.offsetY += Settings.getInstance().getHeight();
                enemy.offsetX += Settings.getInstance().getWidth() / 2;

                enemy.ship.setPosition(enemy.offsetX, enemy.offsetY);
            }
        }

    }

    private List<EnemyWithOffset> enemyList = new LinkedList<EnemyWithOffset>();
    private int id;

    public static final Wave EMPTY_WAVE = new Wave.Builder()
                                                .withId(-1)
                                                .build();

    private Wave() {
    }

    private void addEnemy(EnemyWithOffset enemy) {
        if (!enemyList.contains(enemy)) {
            enemyList.add(enemy);
        }
    }

    public List<EnemyWithOffset> getEnemyList() { return enemyList; }
    public int getId() { return id; }

    public boolean waveCompleted() {
        return enemyList.isEmpty();
    }

}
