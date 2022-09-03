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
 * along with BoppyLen. If not, see <http://www.gnu.org/licenses/>.
 */

package com.honiism.boppylen.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class PowerUp {
    
    private final Vector2 position = new Vector2();
    private final Sprite button;
    private final Sprite indicator;

    private int price;
    private int level;

    public PowerUp(Sprite indicatorTex) {
        this.indicator = new Sprite(indicatorTex);
        this.button = new Sprite(new Texture("gfx/upgr_button.png"));

        price = 3;
        level = 1;
    }

    public Vector2 getPos() {
        return position;
    }

    public Sprite getIndicator() {
        return indicator;
    }

    public Sprite getButton() {
        return button;
    }

    public int getPrice() {
        return price;
    }

    public PowerUp setPrice(int price) {
        this.price = price;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public PowerUp setLevel(int level) {
        this.level = level;
        return this;
    }
}