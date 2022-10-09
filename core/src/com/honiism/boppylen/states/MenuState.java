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

package com.honiism.boppylen.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Cursor.SystemCursor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuState extends State {
    
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Stage stage;
    private Viewport viewport;
    private Table menuTable;

    private Sprite title;
    private Sprite lenMenu;
    private Sprite starsMenu;
    private Sprite menuBg;

    private ImageButton playButton;
    private TextureRegionDrawable playButtonTexRegDraw;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        stage = new Stage(viewport, batch);

        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport.apply(true);
        Gdx.input.setInputProcessor(stage);

        title = new Sprite(new Texture("gfx/title.png"));
        lenMenu = new Sprite(new Texture("gfx/len_main_menu.png"));
        starsMenu = new Sprite(new Texture("gfx/stars_main_menu.png"));
        menuBg = new Sprite(new Texture("gfx/bg.png"));
        playButtonTexRegDraw = new TextureRegionDrawable(new Texture("gfx/play_button.png"));

        lenMenu.setPosition(Gdx.graphics.getWidth() / 2 - lenMenu.getWidth() / 2,
            Gdx.graphics.getHeight() / 2 - lenMenu.getHeight() / 2);
            
        starsMenu.setPosition(Gdx.graphics.getWidth() / 2 - starsMenu.getWidth() / 2,
            Gdx.graphics.getHeight() / 2 - starsMenu.getHeight() / 2);

        title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2,
            Gdx.graphics.getHeight() / 2 - title.getHeight() / 2);
    }

    @Override
    public void handleInput() {
        menuTable = new Table();
        playButton = new ImageButton(playButtonTexRegDraw);

        playButton.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                Gdx.graphics.setSystemCursor(SystemCursor.Hand);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                Gdx.graphics.setSystemCursor(SystemCursor.Arrow);
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                gsm.push(new PlayState(gsm));
                dispose();
            }
        });

        menuTable.add(playButton);

        menuTable.setPosition(Gdx.graphics.getWidth() / 2 - menuTable.getWidth() / 2,
            (Gdx.graphics.getHeight() / 2 - menuTable.getHeight() / 2) - (title.getHeight() / 2 + playButton.getHeight() / 2));

        stage.addActor(menuTable);
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);
        
        batch.begin();
        
        menuBg.draw(batch);
        starsMenu.draw(batch);
        lenMenu.draw(batch);
        title.draw(batch);
        
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        lenMenu.getTexture().dispose();
        starsMenu.getTexture().dispose();
        title.getTexture().dispose();
        menuBg.getTexture().dispose();
        batch.dispose();
        stage.dispose();
    }
}