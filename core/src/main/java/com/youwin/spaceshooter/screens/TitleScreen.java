package com.youwin.spaceshooter.screens;

import com.artemis.MdxWorld;
import com.artemis.WorldConfiguration;
import com.badlogic.gdx.utils.Logger;

public class TitleScreen extends BaseScreen {
    private static final Logger LOG = new Logger("[TestScreen]", Logger.INFO);

    public TitleScreen() {
        super();
    }

    @Override
    protected void initialize() {
        WorldConfiguration worldConfiguration = new WorldConfiguration();

        world = new MdxWorld(worldConfiguration);
    }

    @Override
    public MdxWorld getWorld() {
        return world;
    }
}