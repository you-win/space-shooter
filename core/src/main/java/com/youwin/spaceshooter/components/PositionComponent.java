package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

import org.mini2Dx.core.engine.geom.CollisionPoint;

public class PositionComponent extends Component {
    private CollisionPoint point;
    private CollisionPoint previousPoint;

    public PositionComponent() {
        point = new CollisionPoint();
        previousPoint = new CollisionPoint();
    }

    public PositionComponent(float x, float y) {
        point = new CollisionPoint(x, y);
        previousPoint = new CollisionPoint(x, y);
    }

    public PositionComponent(Vector2 position) {
        point = new CollisionPoint(position.x, position.y);
        previousPoint = new CollisionPoint(position.x, position.y);
    }

    public CollisionPoint getPoint() {
        return point;
    }

    public void setPoint(CollisionPoint collisionPoint) {
        point = collisionPoint;
    }

    public CollisionPoint getPreviousPoint() {
        return previousPoint;
    }

    public void setPreviousPoint(CollisionPoint collisionPoint) {
        previousPoint = collisionPoint;
    }
}