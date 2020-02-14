package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.InterpolatingEntitySystem;
import com.artemis.annotations.Wire;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.utils.GameManager;

import org.mini2Dx.core.engine.geom.CollisionPoint;

@Wire
public class MoveEntitySystem extends InterpolatingEntitySystem {
    private static final Logger LOG = new Logger("[MoveEntitySystem]", Logger.INFO);

    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<HitboxComponent> hitboxMapper;
    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;
    private ComponentMapper<NameComponent> nameComponentMapper;

    private boolean hasScreenBoundary = Boolean.FALSE;

    public MoveEntitySystem() {
        super(Aspect.all(PositionComponent.class));
    }

    public MoveEntitySystem(boolean hasScreenBoundary) {
        super(Aspect.all(PositionComponent.class));
        this.hasScreenBoundary = hasScreenBoundary;
    }

    @Override
    protected void update(int entityId, float delta) {
        Vector2 targetDirection = new Vector2(Vector2.Zero);
        float targetSpeed = 1f;
        PositionComponent position = positionMapper.get(entityId);
        HitboxComponent hitbox = hitboxMapper.get(entityId);
        PlayerControllerComponent playerController = playerControllerMapper.getSafe(entityId, null);
        // TODO debug only?
        NameComponent name = nameComponentMapper.get(entityId);

        // Store the previous position for use in collisions
        // TODO see if there's a better way of doing this
        position.setPreviousPoint(new CollisionPoint(position.getPoint()));

        if (playerController != null) {
            Vector2 playerTargetDirection = playerController.getTargetDirection();
            targetDirection.set(playerTargetDirection);
            targetSpeed = playerController.getPlayerSpeed();
            playerTargetDirection.set(Vector2.Zero);
        }

        targetDirection.x *= targetSpeed;
        targetDirection.y *= targetSpeed;

        position.getPoint().preUpdate();
        position.getPoint().add(targetDirection);

        // Each entity has its position calculated at the top left corner
        // Check if that entity is outside of the screen bounds
        if (hasScreenBoundary && hitbox != null) {
            int screenWidth = GameManager.screenWidth;
            int screenHeight = GameManager.screenHeight;

            if (position.getPoint().x < 0
                    || (position.getPoint().x + hitbox.getCollisionBox().getWidth()) > screenWidth) {
                position.getPoint().sub(targetDirection.x, 0);
            }
            if (position.getPoint().y < 0
                    || (position.getPoint().y + hitbox.getCollisionBox().getHeight()) > screenHeight) {
                position.getPoint().sub(0, targetDirection.y);
            }
        }

        // Move the hitbox as well
        if (hitbox != null) {
            hitbox.getCollisionBox().set(position.getPoint());
        }
    }

    @Override
    protected void interpolate(int entityId, float alpha) {
        PositionComponent position = positionMapper.get(entityId);
        position.getPoint().interpolate(null, alpha);
    }
}