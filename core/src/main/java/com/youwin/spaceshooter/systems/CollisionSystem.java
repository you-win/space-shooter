package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;

import org.mini2Dx.core.engine.geom.CollisionBox;

public class CollisionSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[CollisionSystem]", Logger.INFO);

    ComponentMapper<HitboxComponent> hitboxMapper;
    ComponentMapper<NameComponent> nameMapper;

    public CollisionSystem() {
        super(Aspect.all(HitboxComponent.class));
    }

    @Override
    protected void process(int entityId) {
        HitboxComponent hitbox = hitboxMapper.get(entityId);

        // TODO will need to add the other hitboxes to this thingy somehow
        // Probably use some big static manager
        Array<CollisionBox> collisions = hitbox.getCollisions().getElementsWithinArea(hitbox.getCollisionBox());

        if (nameMapper.has(entityId) && nameMapper.get(entityId).getName().equals("Player")) {
            LOG.info("Player pos: " + Float.toString(hitbox.getCollisionBox().getCenterX()) + ", "
                    + Float.toString(hitbox.getCollisionBox().getCenterY()));
        }

        if (collisions.size > 0) {
            LOG.info(collisions.toString());
        }
    }

}