/**
 * Copyright (C) 2022 Honiism
 * 
 * This file is part of BoppyLen.
 * 
 * BoppyLen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * BoppyLen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with BoppyLen.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.honiism.boppylen.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.math.Vector2;

public class Background {

    private final Vector2 position = new Vector2();
    private Texture bg;

    public Background() {
        this.bg = new Texture("gfx/bg.png");
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