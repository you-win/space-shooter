package com.youwin.spaceshooter.screens;

import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.entities.PlayerBuilder;
import com.youwin.spaceshooter.systems.MoveEntitySystem;
import com.youwin.spaceshooter.systems.PlayerControllerSystem;
import com.youwin.spaceshooter.systems.RenderEntitySystem;

public class TestScreen extends BaseScreen {
    public static final Logger LOG = new Logger("[TestScreen]", Logger.INFO);

    public TestScreen() {
        super();
    }

    @Override
    public void initialize() {
        WorldConfiguration worldConfiguration = new WorldConfiguration();
        worldConfiguration //
                .setSystem(new MoveEntitySystem()) //
                .setSystem(new PlayerControllerSystem()) //
                .setSystem(new RenderEntitySystem());

        world = new MdxWorld(worldConfiguration);

        PlayerBuilder.createPlayer(world);
    }

    @Override
    public MdxWorld getWorld() {
        return world;
    }
}