package com.ernestas.gaya.Validator;

import com.ernestas.gaya.Exceptions.InvalidFileException;
import com.ernestas.gaya.Gameplay.Scenario;
import com.ernestas.gaya.ResourceLoaders.ResourceLoader;
import com.ernestas.gaya.ResourceLoaders.ResourcesPather;
import com.ernestas.gaya.Util.IntWrapper;
import com.ernestas.gaya.Util.Settings.GameSettings;
import com.ernestas.gaya.Util.Settings.Settings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JSONToScenarioConverterTest {

    @Before
    public void before() {
        Settings.reset();
    }

    @After
    public void after() {
        Settings.reset();
        GameSettings.reset();
    }

    @Test
    public void testConvert() throws Exception {
        String result = null;
        String path = "../android/assets/Scenarios/scenario1.json";
        File file = new File(path);
        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = reader.readLine()) != null) {
            sb.append(line);
        }

        result = sb.toString();

        assertNotNull(result);

        Scenario scenario = JSONToScenarioConverter.convert(result);
    }

    @Test
    public void testEvaluateExpression() throws Exception {
        assertThat(JSONToScenarioConverter.evaluateExpression("1 + 2", null), is(3f));
        assertThat(JSONToScenarioConverter.evaluateExpression("2 - 1", null), is(1f));
        assertThat(JSONToScenarioConverter.evaluateExpression("0 - 14", null), is(-14f));
        assertThat(JSONToScenarioConverter.evaluateExpression("1 * 2", null), is(2f));
        assertThat(JSONToScenarioConverter.evaluateExpression("0 * 16", null), is(0f));

        assertThat(JSONToScenarioConverter.evaluateExpression("0.0 * 16", null), is(0f));
        assertThat(JSONToScenarioConverter.evaluateExpression("12.5 * 14.5", null), is(181.25f));
        assertThat(JSONToScenarioConverter.evaluateExpression("2 + 3 * 4", null), is(14f));

        assertThat(JSONToScenarioConverter.evaluateExpression("1000.0 + 3.0 * 1000.0", null), is(4000f));
        assertThat(JSONToScenarioConverter.evaluateExpression("123456.0 + 111111.1", null), is(234567.1f));

        assertThat(JSONToScenarioConverter.evaluateExpression("MIDDLE * 2", null), is(Settings.DEFAULT_WIDTH * 1f));
        assertThat(JSONToScenarioConverter.evaluateExpression("RIGHT * 2", null), is(Settings.DEFAULT_WIDTH * 2f));

        assertThat(JSONToScenarioConverter.evaluateExpression("MIDDLE + RIGHT * 3", null), is(Settings.DEFAULT_WIDTH * 3.5f));
    }

    @Test
    public void testGetNumber() throws Exception {
        IntWrapper temp = new IntWrapper();
        assertThat(JSONToScenarioConverter.getNumberFromIndex("160 * 32", 4, temp, true), is(160f));
        assertThat(temp.integer, is(0));
        assertThat(JSONToScenarioConverter.getNumberFromIndex("160.0 * 32", 4, temp, true), is(160f));
        assertThat(temp.integer, is(0));
        assertThat(JSONToScenarioConverter.getNumberFromIndex("12 160 * 32", 7, temp, true), is(160f));
        assertThat(temp.integer, is(3));
        assertThat(JSONToScenarioConverter.getNumberFromIndex("123.456 * 32", 8, temp, true), is(123.456f));
        assertThat(temp.integer, is(0));


        assertThat(JSONToScenarioConverter.getNumberFromIndex("160 * 32", 4, temp, false), is(32f));
        assertThat(temp.integer, is(7));
        assertThat(JSONToScenarioConverter.getNumberFromIndex("160.0 * 32.0", 6, temp, false), is(32f));
        assertThat(temp.integer, is(11));
        assertThat(JSONToScenarioConverter.getNumberFromIndex("12 160 * 32 154", 7, temp, false), is(32f));
        assertThat(temp.integer, is(10));
        assertThat(JSONToScenarioConverter.getNumberFromIndex("123.456 * 32.5", 8, temp, false), is(32.5f));
        assertThat(temp.integer, is(13));

        assertThat(JSONToScenarioConverter.getNumberFromIndex("10 + 990.0", 3, temp, false), is(990.0f));
    }
}