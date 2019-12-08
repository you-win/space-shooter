package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.InterpolatingEntitySystem;
import com.artemis.annotations.Wire;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;

@Wire
public class MoveEntitySystem extends InterpolatingEntitySystem {
    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<HitboxComponent> hitboxMapper;
    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;

    public MoveEntitySystem() {
        super(Aspect.all(PositionComponent.class));
    }

    @Override
    protected void update(int entityId, float delta) {
        Vector2 targetDirection = new Vector2(Vector2.Zero);
        PositionComponent position = positionMapper.get(entityId);
        if (playerControllerMapper.has(entityId)) {
            Vector2 playerTargetDirection = playerControllerMapper.get(entityId).getTargetDirection();
            targetDirection.set(playerTargetDirection);
            playerTargetDirection.set(Vector2.Zero);
        }

        position.getPoint().preUpdate();
        position.getPoint().add(targetDirection);

        if (hitboxMapper.has(entityId)) {
            HitboxComponent hitbox = hitboxMapper.get(entityId);
            hitbox.getCollisionBox().set(position.getPoint());
            hitbox.getCollisions().set(position.getPoint());
        }
    }

    @Override
    protected void interpolate(int entityId, float alpha) {
        PositionComponent position = positionMapper.get(entityId);
        position.getPoint().interpolate(null, alpha);
    }
}