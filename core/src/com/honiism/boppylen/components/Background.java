package com.honiism.boppylen.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.math.Vector2;

public class Background {

    private final Vector2 position;
    private Texture bg;

    public Background() {
        this.bg = new Texture("gfx/bg.png");
        this.position = new Vector2();
    }

    public void setBg(float hue) {
        Pixmap bgPixmap = this.bg.getTextureData().consumePixmap();
        Color color = new Color().fromHsv(hue, 1, 1);

        color.r *= 255;
        color.g *= 255;
        color.b *= 255;

        bgPixmap.setBlending(Blending.SourceOver);
        bgPixmap.setColor(color);

        bg = new Texture(bgPixmap);
    }

    public Texture getBg() {
        return bg;
    }

    public Vector2 getPos() {
        return position;
    }
}