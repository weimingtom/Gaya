package com.ernestas.gaya.Gameplay;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ScenarioTest {

    @Test
    public void testScenario() throws Exception {
        Scenario scenario = new Scenario();
        scenario.addWave(new Wave.Builder()
                .withId(0)
                .build()
        );
        scenario.addWave(new Wave.Builder()
                .withId(5)
                .build()
        );
        scenario.addWave(new Wave.Builder()
                .withId(3)
                .build()
        );
        scenario.addWave(new Wave.Builder()
                .withId(7)
                .build()
        );

        List<Wave> waves = scenario.getWaves();
        for (int i = 1; i < waves.size(); ++i) {
            assertThat(waves.get(i - 1).getId() < waves.get(i).getId(), is(true));
        }
    }
}