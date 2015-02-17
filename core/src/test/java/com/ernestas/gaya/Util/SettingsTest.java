package com.ernestas.gaya.Util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SettingsTest {

    @Test
    public void testGetInstance() throws Exception {
        assertThat("2+2=4", 2+2, is(4));
    }
}