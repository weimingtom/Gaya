package com.ernestas.gaya.Ships;

import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Util.Vectors.Vector2f;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlayerShipTest {

    @Test
    public void testShip() {
        PlayerShip player = new PlayerShip(null, new Vector2f(100f, 50f));

        assertThat(player.getPosition().x, is(100f));
        assertThat(player.getPosition().y, is(50f));
        assertNull(player.getSprite());
        assertThat(player.getBounds().x, is(0f));
        assertThat(player.getBounds().y, is(0f));
        assertThat(player.getBounds().width, is(0f));
        assertThat(player.getBounds().height, is(0f));
    }

}