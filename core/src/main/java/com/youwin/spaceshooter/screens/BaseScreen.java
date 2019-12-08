package com.youwin.spaceshooter.screens;

import com.artemis.MdxWorld;

public abstract class BaseScreen {
    MdxWorld world;

    public BaseScreen() {
        initialize();
    }

    protected abstract void initialize();

    public abstract MdxWorld getWorld();
}