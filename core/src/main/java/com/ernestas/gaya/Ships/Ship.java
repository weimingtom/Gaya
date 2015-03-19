package com.ernestas.gaya.Ships;

import com.badlogic.gdx.math.Rectangle;
import com.ernestas.gaya.Game.Level;
import com.ernestas.gaya.Util.Printable;
import com.ernestas.gaya.Util.Vectors.Vector2f;

public abstract class Ship implements Printable {

    protected Vector2f position;
    protected Rectangle bounds;

    protected boolean exploding = false;

    protected Level level;

    /*
    *   Position    - position of the ship's center
    *   Bounds      - ship's bounding rectangle
    */

    public Ship() { this(null); }

    public Ship(Level level) {
        this(level, new Vector2f());
    }

    public Ship(Level level, Vector2f position) {
        this.level = level;
        this.position = position;
        this.bounds = new Rectangle(0, 0, 0, 0);
    }

    public void setPosition(float x, float y) {
        setPosition(new Vector2f(x, y));
    }

    public void setPosition(Vector2f position) {
        this.position = position;
        setBounds(position.x - bounds.width / 2, position.y - bounds.height / 2, bounds.width, bounds.height);
    }

    public void setBounds(float x, float y, float width, float height) {
        setBounds(new Rectangle(x, y, width, height));
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void explode() {
        exploding = true;
    }

    public Vector2f getPosition() { return position; }
    public Rectangle getBounds() { return bounds; }

    public void setLevel(Level level) { this.level = level; }
    public Level getLevel() { return level; }

    public boolean collidesWith(Ship ship) {
        if (this.getBounds().overlaps(ship.getBounds())) {
            if (!this.exploding && !ship.exploding) {
                return true;
            }
        }
        return false;
    }

    // Final, because we don't want out children to override this method
    public final void println() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return this.getClass() + " position:["  + position.toString() + "] bounds:[" + bounds.toString() + "]";
    }

    public boolean isExploding() {
        return exploding;
    }
}
