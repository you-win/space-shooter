package com.youwin.spaceshooter;

import com.artemis.MdxWorld;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.screens.BaseScreen;
import com.youwin.spaceshooter.screens.TestScreen;
import com.youwin.spaceshooter.screens.TitleScreen;

import org.mini2Dx.core.game.ScreenBasedGame;

public class SpaceShooter extends ScreenBasedGame {
    public static final String GAME_IDENTIFIER = "com.youwin.spaceshooter";
    private static final Logger LOG = new Logger("[Main]", Logger.INFO);

    private MdxWorld world;

    private BaseScreen currentScreen;

    @Override
    public void initialise() {
        this.addScreen(new TestScreen());
        this.addScreen(new TitleScreen());

        LOG.info("Finished base initialization");
    }

    @Override
    public int getInitialScreenId() {
        // TODO testing only, change this to TitleScreen
        return TestScreen.Id;
    }
}