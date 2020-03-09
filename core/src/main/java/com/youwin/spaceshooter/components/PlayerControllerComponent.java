package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class PlayerControllerComponent extends Component implements GenericController {
    private Vector2 targetDirection;
    private float speed;
    private boolean shouldShoot;

    public PlayerControllerComponent() {
        targetDirection = new Vector2(Vector2.Zero);
        speed = 1f;
        shouldShoot = false;
    }

    public PlayerControllerComponent(float speed) {
        targetDirection = new Vector2(Vector2.Zero);
        this.speed = speed;
        shouldShoot = false;
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

    public boolean getShouldShoot() {
        return shouldShoot;
    }

    public void setShouldShoot(boolean shouldShoot) {
        this.shouldShoot = shouldShoot;
    }
}