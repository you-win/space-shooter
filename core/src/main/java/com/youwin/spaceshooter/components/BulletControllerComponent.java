package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class BulletControllerComponent extends Component implements GenericController {
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

    @Override
    public Vector2 getTargetDirection() {
        return targetDirection;
    }

    @Override
    public void setTargetDirection(Vector2 targetDirection) {
        this.targetDirection = targetDirection;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}