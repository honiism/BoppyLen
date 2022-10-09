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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Player {
    
    private static final int GRAVITY = -15;

    private final Vector3 position;
    private final Vector3 velocity;

    private Sprite playerSprite;
    private Rectangle bounds;
    private int veloX = 100;

    public Player(float x, float y, Texture playerTex) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        playerSprite = new Sprite(playerTex);

        bounds = new Rectangle(x, y, playerTex.getWidth() / 3, playerTex.getHeight());
    }

    public void update(float dt) {
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        
        velocity.scl(dt);

        position.add(velocity.x, velocity.y, 0);

        if (position.y < 0) {
            position.y = 0;
            velocity.x = 0;
        }
        
        velocity.scl(1 / dt);
    }

    public void jump() {
        velocity.y = 250;

        if (getLeft() <= 0 || getRight() >= Gdx.graphics.getWidth()) {
            veloX *= -1;
        }

        velocity.x = veloX;
    }

    public Vector3 getPos() {
        return position;
    }

    public void setPos(float x, float y, float z) {
        getPos().set(x, y, z);
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public void setVelocity(float veloX, float veloY, float veloZ) {
        this.velocity.set(veloX, veloY, veloZ);
    }

    public Sprite getSprite() {
        return playerSprite;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public float getLeft() {
        return position.x;
    }

    public float getRight() {
        return position.x + playerSprite.getWidth();
    }
}
