package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.systems.CollisionSystem;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;

import org.mini2Dx.core.engine.geom.CollisionBox;

public class HitboxComponent extends Component {
    private CollisionBox collisionBox;
    private Layer listenLayer;
    private Layer searchLayer;

    public HitboxComponent() {
        collisionBox = new CollisionBox();
        CollisionSystem.getCollisions().add(collisionBox);
        listenLayer = Layer.ALL;
        searchLayer = Layer.ALL;
    }

    public HitboxComponent(int entityId, Vector2 position, float width, float height) {
        collisionBox = new CollisionBox(entityId, position.x, position.y, width, height);
        CollisionSystem.getCollisions().add(collisionBox);
        listenLayer = Layer.ALL;
        searchLayer = Layer.ALL;
    }

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    public Layer getListenLayer() {
        return listenLayer;
    }

    public Layer getSearchLayer() {
        return searchLayer;
    }
}