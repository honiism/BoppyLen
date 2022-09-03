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
    
    private Vector2 position = new Vector2();
    private final Sprite rightSprite;
    private final Sprite leftSprite;

    private float acceleration;
    private float velocity;
    private Sprite currentSprite;

    public Player(float x, float y, float velocity, float acceleration, Texture playerTex) {
        position.x = x;
        position.y = y;
        this.velocity = velocity;
        this.acceleration = acceleration;
        rightSprite = new Sprite(playerTex);
        currentSprite = rightSprite;
        leftSprite = new Sprite(playerTex);

        leftSprite.flip(true, false);
    }

    public Vector2 getPos() {
        return position;
    }

    public void setPos(float x, float y) {
        getPos().set(x, y);
    }

    public void setPosX(float x) {
        getPos().x = x;
    }

    public void setPosY(float y) {
        getPos().y = y;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public Sprite getCurrentSprite() {
        return currentSprite;
    }
}
