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

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player {
    
    private final Vector2 position = new Vector2();
    private final Vector2 velocity = new Vector2();;
    private final Sprite rightSprite;
    private final Sprite leftSprite;

    private float acceleration;
    private Sprite currentSprite;

    public Player(float x, float y, float veloX, float veloY, float acceleration, Texture playerTex) {
        position.x = x;
        position.y = y;
        velocity.x = veloX;
        velocity.y = veloY;
        this.acceleration = acceleration;
        rightSprite = new Sprite(playerTex);
        currentSprite = rightSprite;
        leftSprite = new Sprite(playerTex);

        leftSprite.flip(true, false);
    }

    public Vector2 getPos() {
        return position;
    }

    public Vector2 getVelocit() {
        return velocity;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public Sprite getCurrentSprite() {
        return currentSprite;
    }
}
