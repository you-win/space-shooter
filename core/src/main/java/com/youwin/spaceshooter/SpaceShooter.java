package com.youwin.spaceshooter;

import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.entities.PlayerBuilder;
import com.youwin.spaceshooter.screens.BaseScreen;
import com.youwin.spaceshooter.screens.TestScreen;
import com.youwin.spaceshooter.systems.MoveEntitySystem;
import com.youwin.spaceshooter.systems.PlayerControllerSystem;
import com.youwin.spaceshooter.systems.RenderEntitySystem;

import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class SpaceShooter extends BasicGame {
    public static final String GAME_IDENTIFIER = "com.youwin.spaceshooter";
    public static final Logger LOG = new Logger("[Main]", Logger.INFO);

    private Texture texture;

    private MdxWorld world;

    private BaseScreen currentScreen;

    @Override
    public void initialise() {
        Gdx.app.setLogLevel(Logger.INFO);
        texture = new Texture("mini2Dx.png");

        // TODO ECS test
        currentScreen = new TestScreen();
        world = currentScreen.getWorld();

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

        // g.drawTexture(texture, 0f, 0f);
    }
}