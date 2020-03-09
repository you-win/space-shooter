package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class SimpleControllerComponent extends Component implements GenericController {
    private Vector2 targetDirection;
    // TODO might not need speed?
    private float speed;

    public SimpleControllerComponent() {
        targetDirection = Vector2.Zero;
        speed = 2f;
    }

    public SimpleControllerComponent(float speed) {
        targetDirection = Vector2.Zero;
        this.speed = speed;
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