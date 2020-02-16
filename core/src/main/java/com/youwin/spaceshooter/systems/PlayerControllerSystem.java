package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.PlayerControllerComponent;

public class PlayerControllerSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[PlayerControllerSystem]", Logger.INFO);

    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;

    public PlayerControllerSystem() {
        super(Aspect.all(PlayerControllerComponent.class));

    }

    @Override
    protected void process(int entityId) {
        PlayerControllerComponent playerController = playerControllerMapper.get(entityId);
        Vector2 targetDirection = playerController.getTargetDirection();

        if (Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Keys.UP)) {
            targetDirection.add(0f, -1f);
        }
        if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Keys.LEFT)) {
            targetDirection.add(-1f, 0f);
        }
        if (Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Keys.DOWN)) {
            targetDirection.add(0f, 1f);
        }
        if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Keys.RIGHT)) {
            targetDirection.add(1f, 0f);
        }
        if (Gdx.input.isButtonPressed(Buttons.LEFT)) {
            System.out.println("REEE");
        }
        if (Gdx.input.isKeyPressed(Keys.Z)) {
            playerController.setShouldShoot(true);
        }
    }

}