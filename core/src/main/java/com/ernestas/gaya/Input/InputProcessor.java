package com.ernestas.gaya.Input;

import com.badlogic.gdx.Input;

public class InputProcessor implements com.badlogic.gdx.InputProcessor {

    public static final int KEY_UP = 0;
    public static final int KEY_PRESSED = 1;
    public static final int KEY_HOLD = 2;

    private int keys[] = new int[256];

    public InputProcessor() {
        for (int i = 0; i < keys.length; ++i) {
            keys[i] = KEY_UP;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        keys[keycode] = KEY_PRESSED;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        keys[keycode] = KEY_UP;
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public int getKeyStatus(int keycode) {
        return keys[keycode];
    }

    public boolean isPressed(int keycode) {
        return keys[keycode] == KEY_PRESSED;
    }

    public boolean isHold(int keycode) {
        return keys[keycode] == KEY_HOLD;
    }

    public boolean isPressedAdvanced(int keycode) {
        boolean result = isPressed(keycode);
        keys[keycode] = KEY_HOLD;
        return result;
    }

}
