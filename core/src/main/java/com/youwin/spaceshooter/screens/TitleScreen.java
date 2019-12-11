package com.youwin.spaceshooter.screens;

import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Logger;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;

public class TitleScreen extends BasicGameScreen {
    public static int Id = 0;

    private static final Logger LOG = new Logger("[TestScreen]", Logger.INFO);

    private MdxWorld world;
    private Viewport viewport;
    private float gameWidth = 800;
    private float gameHeight = 600;

    @Override
    public void initialise(GameContainer gc) {
        Gdx.app.setLogLevel(Logger.INFO);

        viewport = new FitViewport(gameWidth, gameHeight);

        WorldConfiguration worldConfiguration = new WorldConfiguration();

        world = new MdxWorld(worldConfiguration);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        world.setDelta(delta);
        world.process();

        // TODO debug only
        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
        world.setAlpha(alpha);
        world.interpolate();
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
        viewport.apply(g);

        world.render(g);
    }

    @Override
    public void postTransitionOut(Transition transitionOut) {
        world.dispose();
    }

    @Override
    public int getId() {
        return Id;
    }

    public MdxWorld getWorld() {
        return world;
    }
}