package com.youwin.spaceshooter.systems;

import java.util.ArrayList;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.NameComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;
import com.youwin.spaceshooter.utils.GameManager;

import org.mini2Dx.core.collisions.RegionQuadTree;
import org.mini2Dx.core.engine.geom.CollisionBox;
import org.mini2Dx.core.engine.geom.CollisionShape;

/*
It's most efficient for the collision system to encompass the entire play area, probably.
*/
public class CollisionSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[CollisionSystem]", Logger.INFO);

    private ComponentMapper<HitboxComponent> hitboxMapper;
    private ComponentMapper<PositionComponent> positionMapper;
    // TODO debug only maybe
    private ComponentMapper<NameComponent> nameMapper;

    private static RegionQuadTree<CollisionBox> collisions;

    public CollisionSystem() {
        super(Aspect.all(HitboxComponent.class, PositionComponent.class));
        collisions = new RegionQuadTree<CollisionBox>(9, 4, 0, 0, GameManager.screenWidth, GameManager.screenHeight);
    }

    public CollisionSystem(float width, float height) {
        super(Aspect.all(HitboxComponent.class, PositionComponent.class));
        collisions = new RegionQuadTree<CollisionBox>(9, 4, 0, 0, width, height);
    }

    @Override
    protected void process(int entityId) {
        HitboxComponent hitbox = hitboxMapper.get(entityId);
        NameComponent name = nameMapper.get(entityId);

        Array<CollisionBox> collisionList = collisions.getElementsWithinArea(hitbox.getCollisionBox());

        // An object can collide with itself
        if (collisionList.size > 1) {
            for (CollisionShape collision : collisionList) {
                if (collision.getId() != entityId) {
                    HitboxComponent collisionHitbox = hitboxMapper.get(collision.getId());

                    if (collisionHitbox.getListenLayer().equals(hitbox.getSearchLayer())) {

                    }

                    PositionComponent position = positionMapper.get(entityId);
                    position.setPoint(position.getPreviousPoint());
                    hitbox.getCollisionBox().set(position.getPreviousPoint());
                }
            }

        }

    }

    public static RegionQuadTree<CollisionBox> getCollisions() {
        return collisions;
    }

}