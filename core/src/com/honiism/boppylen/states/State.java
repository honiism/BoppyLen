package com.honiism.boppylen.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    
    protected GameStateManager gsm;
    protected OrthographicCamera cam;
    protected Vector3 mouse;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        
        cam.setToOrtho(false, 640, 480);
    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render();
    public abstract void dispose();
}
