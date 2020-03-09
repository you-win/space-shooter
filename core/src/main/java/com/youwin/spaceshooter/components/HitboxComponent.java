package com.youwin.spaceshooter.components;

import java.util.ArrayList;
import java.util.List;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;
import com.youwin.spaceshooter.systems.CollisionSystem;
import com.youwin.spaceshooter.utils.CollisionLayerEnum.Layer;

import org.mini2Dx.core.engine.geom.CollisionBox;

public class HitboxComponent extends Component {
    private CollisionBox collisionBox;
    private List<Layer> listenLayers;
    private List<Layer> searchLayers;

    public HitboxComponent() {

    }

    public HitboxComponent(int entityId, Vector2 position, float width, float height, List<Layer> listenLayers,
            List<Layer> searchLayers) {
        collisionBox = new CollisionBox(entityId, position.x, position.y, width, height);
        CollisionSystem.getCollisions().add(collisionBox);
        this.listenLayers = listenLayers;
        this.searchLayers = searchLayers;
    }

    public void cleanup() {
        CollisionSystem.getCollisions().remove(collisionBox);
    }

    public CollisionBox getCollisionBox() {
        return collisionBox;
    }

    public List<Layer> getListenLayers() {
        return listenLayers;
    }

    public List<Layer> getSearchLayers() {
        return searchLayers;
    }
}