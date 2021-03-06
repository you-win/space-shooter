package com.youwin.spaceshooter.screens;

import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.entities.EnemyBuilder;
import com.youwin.spaceshooter.entities.PlayerBuilder;
import com.youwin.spaceshooter.systems.BodyLinkSystem;
import com.youwin.spaceshooter.systems.CollisionSystem;
import com.youwin.spaceshooter.systems.LifetimeSystem;
import com.youwin.spaceshooter.systems.MoveEntitySystem;
import com.youwin.spaceshooter.systems.PlayerControllerSystem;
import com.youwin.spaceshooter.systems.RenderEntitySystem;
import com.youwin.spaceshooter.systems.ShootingSystem;
import com.youwin.spaceshooter.systems.TimerSystem;
import com.youwin.spaceshooter.utils.GameManager;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.di.annotation.Autowired;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.graphics.viewport.FitViewport;
import org.mini2Dx.core.graphics.viewport.Viewport;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;

public class TestScreen extends BasicGameScreen {
    public static int Id = 1;

    private static final Logger LOG = new Logger("[TestScreen]", Logger.INFO);

    private MdxWorld world;
    private Viewport viewport;
    private float screenWidth = GameManager.screenWidth;
    private float screenHeight = GameManager.screenHeight;

    @Override
    public void initialise(GameContainer gc) {
        Gdx.app.setLogLevel(Logger.INFO);

        viewport = new FitViewport(screenWidth, screenHeight);

        WorldConfiguration worldConfiguration = new WorldConfiguration();
        worldConfiguration //
                .setSystem(new TimerSystem()) // Must be first so that features that rely on timers work correctly
                .setSystem(new LifetimeSystem()) // Runs right after timers so that expired entities are removed

                // Controllers
                .setSystem(new PlayerControllerSystem()) //
                // .setSystem(new EnemyControllerSystem()) //

                .setSystem(new BodyLinkSystem()) //

                .setSystem(new MoveEntitySystem(true)) //
                .setSystem(new ShootingSystem()) //
                .setSystem(new CollisionSystem()) // Must come after movement and spawning since this adjusts the
                                                  // position of objects
                .setSystem(new RenderEntitySystem()); // Usually last since we redraw things after everything is updated

        world = new MdxWorld(worldConfiguration);

        PlayerBuilder.createPlayer(world, new Vector2(100f, 100f), 5f);
        EnemyBuilder.createEnemy(world, new Vector2(300f, 25f), "test");
        EnemyBuilder.createEnemy(world, new Vector2(50f, 400f), "test2");
        EnemyBuilder.createEnemy(world, new Vector2(300f, 400f), "test3");
        EnemyBuilder.createEnemy(world, new Vector2(600f, 500f), "test4");

        LOG.info("Finished initialization");
    }

    @Override
    public void update(GameContainer gc, ScreenManager screenManager, float delta) {
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
        // TODO possibly not necessary
        // This is only a suggestion to the JVM but hopefully this cleans up references
        // or something
        // JAVA REEEEEEEEEEEEEE
        System.gc();
    }

    @Override
    public void onPause() {
        // TODO come back to this
        LOG.info("OOF");
    }

    @Override
    public int getId() {
        return Id;
    }

    public MdxWorld getWorld() {
        return world;
    }
}