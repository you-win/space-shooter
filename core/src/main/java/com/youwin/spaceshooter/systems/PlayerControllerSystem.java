package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.PlayerControllerComponent;

public class PlayerControllerSystem extends IteratingSystem {
    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;

    public PlayerControllerSystem() {
        super(Aspect.all(PlayerControllerComponent.class));
    }

    @Override
    protected void process(int entityId) {
        PlayerControllerComponent playerController = playerControllerMapper.get(entityId);
        Vector2 targetDirection = playerController.getTargetDirection();

        if (Gdx.input.isKeyPressed(Keys.W)) {
            targetDirection.add(0f, -1f);
        }
        if (Gdx.input.isKeyPressed(Keys.A)) {
            targetDirection.add(-1f, 0f);
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            targetDirection.add(0f, 1f);
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            targetDirection.add(1f, 0f);
        }

    }

}