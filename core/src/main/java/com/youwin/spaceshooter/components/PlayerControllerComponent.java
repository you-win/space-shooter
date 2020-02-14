package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class PlayerControllerComponent extends Component {
    private Vector2 targetDirection;
    private float playerSpeed;
    private boolean isShooting;

    public PlayerControllerComponent() {
        targetDirection = new Vector2(Vector2.Zero);
        playerSpeed = 1f;
        isShooting = false;
    }

    public PlayerControllerComponent(float speed) {
        targetDirection = new Vector2(Vector2.Zero);
        playerSpeed = speed;
        isShooting = false;
    }

    public Vector2 getTargetDirection() {
        return targetDirection;
    }

    public void setTargetDirection(Vector2 newTargetDirection) {
        targetDirection = newTargetDirection;
    }

    public float getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(float speed) {
        playerSpeed = speed;
    }

    public boolean getIsShooting() {
        return isShooting;
    }

    public void setIsShooting(boolean isShooting) {
        this.isShooting = isShooting;
    }
}