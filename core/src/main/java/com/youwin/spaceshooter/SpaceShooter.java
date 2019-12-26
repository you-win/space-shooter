package com.youwin.spaceshooter;

import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.screens.TestScreen;
import com.youwin.spaceshooter.screens.TitleScreen;
import com.youwin.spaceshooter.utils.GameManager;

import org.mini2Dx.core.game.ScreenBasedGame;

public class SpaceShooter extends ScreenBasedGame {
    public static final String GAME_IDENTIFIER = "com.youwin.spaceshooter";
    public static final GameManager gameManager = new GameManager();
    private static final Logger LOG = new Logger("[Main]", Logger.INFO);

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