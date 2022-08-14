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

package com.honiism.boppylen.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.honiism.boppylen.BoppyLen;
import com.honiism.boppylen.components.Bomb;
import com.honiism.boppylen.components.GiftBox;
import com.honiism.boppylen.components.Player;
import com.honiism.boppylen.tools.GameState;

public class GameScreen implements Screen {

    private final BoppyLen game;
	
    private SpriteBatch batch;
    private Stage stage;
    private OrthographicCamera camera;
    private Viewport viewport;

    // fonts
    private FreeTypeFontGenerator fontGenerator;
    private FreeTypeFontParameter fontParameter;
    private BitmapFont font;
    private BitmapFont fontSmall;
    private BitmapFont font20;

    // sprites + textures
    private Sprite gameUI;
    private Sprite barBg;
    private Sprite retryButton;

    // components
    private Player player;
    private GiftBox giftBox;
    private Bomb bomb;

    // Others
    private GameState gameState;

    public GameScreen(BoppyLen game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        stage = new Stage(viewport, batch);
        
        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/toon_around.otf"));
        fontParameter = new FreeTypeFontParameter();
        
        fontParameter.size = 100;
        font = fontGenerator.generateFont(fontParameter);
        fontParameter.size = 38;
        fontSmall = fontGenerator.generateFont(fontParameter);
        fontParameter.size = 20;
        font20 = fontGenerator.generateFont(fontParameter);

        gameUI = new Sprite(new Texture("gfx/game_ui.png"));
        barBg = new Sprite(new Texture("gfx/bar_bg.png"));
        retryButton = new Sprite(new Texture("gfx/retry_button.png"));

        player = new Player(295f, 100f, 3f, 0f, 0.1f,new Texture("gfx/len_def.png"));
        giftBox = new GiftBox(new Texture("gfx/gift_blue.png"),
                new Texture("gfx/gift_pink.png"),
                new Texture("gfx/gift_purple.png"));
        bomb = new Bomb(new Texture("gfx/bomb.png"));

        gameState = GameState.START;
    }

	@Override
	public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        gameUI.draw(batch);
        batch.end();
	}

    @Override
	public void dispose() {
		font.dispose();
        fontSmall.dispose();
        font20.dispose();
        fontGenerator.dispose();
        gameUI.getTexture().dispose();
        barBg.getTexture().dispose();
        retryButton.getTexture().dispose();
        player.getCurrentSprite().getTexture().dispose();
        bomb.getSprite().getTexture().dispose();

        for (Sprite sprite : giftBox.getSprites()) {
            sprite.getTexture().dispose();
        }

        batch.dispose();
        stage.dispose();
	}

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }
}
