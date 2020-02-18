package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.BodyLinkComponent;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;

@Wire
public class PlayerControllerSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[PlayerControllerSystem]", Logger.INFO);

    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;

    // TODO refactor this out to a different system maybe
    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<BodyLinkComponent> bodyLinkMapper;

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

        // TODO refactor this to maybe queue actions into the playercontroller?
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            LOG.info("Creating body link!");
            BodyLinkComponent bodyLinkComponent = bodyLinkMapper.get(entityId);
            PositionComponent position = positionMapper.get(entityId);
            bodyLinkComponent.addBodyLink(world, position.getPoint());
        }
    }

}