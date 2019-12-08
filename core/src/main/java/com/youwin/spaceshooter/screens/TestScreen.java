package com.youwin.spaceshooter.screens;

import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.entities.EnemyBuilder;
import com.youwin.spaceshooter.entities.PlayerBuilder;
import com.youwin.spaceshooter.systems.CollisionSystem;
import com.youwin.spaceshooter.systems.MoveEntitySystem;
import com.youwin.spaceshooter.systems.PlayerControllerSystem;
import com.youwin.spaceshooter.systems.RenderEntitySystem;

public class TestScreen extends BaseScreen {
    private static final Logger LOG = new Logger("[TestScreen]", Logger.INFO);

    public TestScreen() {
        super();
    }

    @Override
    protected void initialize() {
        WorldConfiguration worldConfiguration = new WorldConfiguration();
        worldConfiguration //
                .setSystem(new MoveEntitySystem()) //
                .setSystem(new PlayerControllerSystem()) //
                .setSystem(new CollisionSystem()) //
                .setSystem(new RenderEntitySystem());

        world = new MdxWorld(worldConfiguration);

        PlayerBuilder.createPlayer(world, new Vector2(0f, 0f));
        EnemyBuilder.createEnemy(world, new Vector2(25f, 25f));
        EnemyBuilder.createEnemy(world, new Vector2(50f, 100f));

        LOG.info("Finished initialization");
    }

    @Override
    public MdxWorld getWorld() {
        return world;
    }
}