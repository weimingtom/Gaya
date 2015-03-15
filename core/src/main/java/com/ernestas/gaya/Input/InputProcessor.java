package com.ernestas.gaya.Input;

import com.badlogic.gdx.Input;
import com.ernestas.gaya.Util.Settings.Settings;

public class InputProcessor implements com.badlogic.gdx.InputProcessor {

    public static final int KEY_UP = 0;
    public static final int KEY_PRESSED = 1;
    public static final int KEY_HOLD = 2;

    private int keys[] = new int[256];

    boolean isAndroid = false;

    public InputProcessor(boolean isAndroid) {
        this.isAndroid = isAndroid;
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
        if (isAndroid) {
            if (screenX < Settings.getInstance().getWidth() / 2) {
                if (keys[Input.Keys.A] == KEY_UP) {
                    keys[Input.Keys.A] = KEY_PRESSED;
                } else {
                    keys[Input.Keys.A] = KEY_HOLD;
                }
                keys[Input.Keys.D] = KEY_UP;
            } else {
                if (keys[Input.Keys.D] == KEY_UP) {
                    keys[Input.Keys.D] = KEY_PRESSED;
                } else {
                    keys[Input.Keys.D] = KEY_HOLD;
                }
                keys[Input.Keys.A] = KEY_UP;
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (isAndroid) {
            keys[Input.Keys.A] = KEY_UP;
            keys[Input.Keys.D] = KEY_UP;
            return true;
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (isAndroid) {
            if (screenX < Settings.getInstance().getWidth() / 2) {
                if (keys[Input.Keys.A] == KEY_UP) {
                    keys[Input.Keys.A] = KEY_PRESSED;
                } else {
                    keys[Input.Keys.A] = KEY_HOLD;
                }
                keys[Input.Keys.D] = KEY_UP;
            } else {
                if (keys[Input.Keys.D] == KEY_UP) {
                    keys[Input.Keys.D] = KEY_PRESSED;
                } else {
                    keys[Input.Keys.D] = KEY_HOLD;
                }
                keys[Input.Keys.A] = KEY_UP;
            }

            return true;
        }

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
