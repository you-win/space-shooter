package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class EnemyControllerComponent extends Component implements GenericController {
    private Vector2 targetDirection;
    private float speed = 1f;

    public EnemyControllerComponent() {
        targetDirection = new Vector2(Vector2.Zero);
    }

    public EnemyControllerComponent(float speed) {
        targetDirection = new Vector2(Vector2.Zero);
        this.speed = speed;
    }

    @Override
    public Vector2 getTargetDirection() {
        return targetDirection;
    }

    @Override
    public void setTargetDirection(Vector2 newTargetDirection) {
        targetDirection = newTargetDirection;
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