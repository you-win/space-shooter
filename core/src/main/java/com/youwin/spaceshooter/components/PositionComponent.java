package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

import org.mini2Dx.core.engine.geom.CollisionPoint;

public class PositionComponent extends Component {
    private CollisionPoint point;

    public PositionComponent() {
        point = new CollisionPoint();
    }

    public PositionComponent(float x, float y) {
        point = new CollisionPoint(x, y);
    }

    public PositionComponent(Vector2 position) {
        point = new CollisionPoint(position.x, position.y);
    }

    public CollisionPoint getPoint() {
        return point;
    }
}