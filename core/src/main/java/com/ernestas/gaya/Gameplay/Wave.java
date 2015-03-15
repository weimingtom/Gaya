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

        public Builder withOffset(float offset) {
            wave.setOffset(offset);
            return this;
        }

        public Builder withEnemy(EnemyWithOffset enemy) {
            wave.addEnemy(enemy);
            return this;
        }

        public Wave build() {
            prepareEnemies();
            return wave;
        }

        private void prepareEnemies() {
            for (int i = 0; i < wave.enemyList.size(); ++i) {
                EnemyWithOffset enemy = wave.enemyList.get(i);
                enemy.offsetY += wave.offset + Settings.getInstance().getHeight();
                enemy.offsetX += Settings.getInstance().getWidth() / 2;

                enemy.ship.setPosition(enemy.offsetX, enemy.offsetY);
            }
        }

    }

    private float offset;
    private List<EnemyWithOffset> enemyList = new LinkedList<EnemyWithOffset>();


    private Wave() {
    }

    private void setOffset(float offset) { this.offset = offset; }
    private void addEnemy(EnemyWithOffset enemy) {
        if (!enemyList.contains(enemy)) {
            enemyList.add(enemy);
        }
    }

    public float getOffset() {return offset;}
    public List<EnemyWithOffset> getEnemyList() {return enemyList;}

    public boolean waveCompleted() {
        return enemyList.isEmpty();
    }

}
