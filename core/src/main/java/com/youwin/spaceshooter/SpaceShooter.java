package com.youwin.spaceshooter;

import com.artemis.MdxWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.screens.BaseScreen;
import com.youwin.spaceshooter.screens.TestScreen;

import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class SpaceShooter extends BasicGame {
    public static final String GAME_IDENTIFIER = "com.youwin.spaceshooter";
    private static final Logger LOG = new Logger("[Main]", Logger.INFO);

    private MdxWorld world;

    private BaseScreen currentScreen;

    @Override
    public void initialise() {
        Gdx.app.setLogLevel(Logger.INFO);

        currentScreen = new TestScreen();
        world = currentScreen.getWorld();

        LOG.info("Finished base initialization");
    }

    @Override
    public void update(float delta) {
        world.setDelta(delta);
        world.process();

        // TODO debug only
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void interpolate(float alpha) {
        world.setAlpha(alpha);
        world.interpolate();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}