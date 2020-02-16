package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class BulletControllerComponent extends Component {
    private Vector2 targetDirection;
    private float speed;

    public BulletControllerComponent() {
        targetDirection = new Vector2(Vector2.Zero);
        speed = 1f;
    }

    public BulletControllerComponent(float speed, Vector2 targetDirection) {
        this.speed = speed;
        this.targetDirection = targetDirection;
    }

    public Vector2 getTargetDirection() {
        return targetDirection;
    }

    public void setTargetDirection(Vector2 targetDirection) {
        this.targetDirection = targetDirection;
    }

    public float speed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}