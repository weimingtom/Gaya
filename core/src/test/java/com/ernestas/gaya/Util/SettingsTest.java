package com.ernestas.gaya.Util;

import com.ernestas.gaya.Util.Settings.Settings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SettingsTest {


    @Before
    public void before() {
        Settings.reset();
    }

    @After
    public void after() {
        Settings.reset();
    }

    @Test
    public void testBasicSetters() {
        Settings settings = Settings.getInstance();

        settings.setWidth(100);
        settings.setHeight(200);

        assertThat(settings.getWidth(), is(100));
        assertThat(settings.getHeight(), is(200));

        Settings.reset();
    }
}