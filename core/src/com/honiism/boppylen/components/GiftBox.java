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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GiftBox {
    
    private final Vector2 position;
    private final List<Sprite> sprites = new ArrayList<>();

    public GiftBox() {
        this.position = new Vector2();

        this.sprites.add(new Sprite(new Texture("gdx/gift_pink.png")));
        this.sprites.add(new Sprite(new Texture("gdx/gift_blue.png")));
        this.sprites.add(new Sprite(new Texture("gdx/gift_purple.png")));
    }

    public Vector2 getPos() {
        return position;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public Sprite getSprite(int index) {
        return sprites.get(index);
    }

    public Sprite getRandomSprite() {
        Random r = new Random();
        return sprites.get(r.nextInt(sprites.size()));
    }
}