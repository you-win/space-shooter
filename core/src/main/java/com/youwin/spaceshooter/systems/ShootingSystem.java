package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.PlayerControllerComponent;

@Wire
public class ShootingSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[ShootingSystem]", Logger.INFO);

    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;

    public ShootingSystem() {
        super(Aspect.all(PlayerControllerComponent.class));
    }

    @Override
    protected void process(int entityId) {
        PlayerControllerComponent playerController = playerControllerMapper.get(entityId);

        if (playerController.getIsShooting()) {
            LOG.info("Shooting!");
        }
    }
}