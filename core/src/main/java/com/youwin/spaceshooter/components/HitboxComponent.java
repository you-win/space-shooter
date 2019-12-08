package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

import org.mini2Dx.core.collisions.RegionQuadTree;
import org.mini2Dx.core.engine.geom.CollisionBox;

public class HitboxComponent extends Component {
    private CollisionBox collisionBox;
    private RegionQuadTree<CollisionBox> collisions;

    public HitboxComponent() {
        collisionBox = new CollisionBox();
        collisions = new RegionQuadTree<CollisionBox>(1, 0f, 0f, 0f, 0f);
    }

    public HitboxComponent(int entityId, Vector2 position, float width, float height) {
        collisionBox = new CollisionBox(entityId, position.x, position.y, width, height);
        collisions = new RegionQuadTree<CollisionBox>(9, 4, position.x, position.y, width, height);
    }

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    public RegionQuadTree<CollisionBox> getCollisions() {
        return collisions;
    }
}