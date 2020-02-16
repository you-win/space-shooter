package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class PlayerControllerComponent extends Component {
    private Vector2 targetDirection;
    private float playerSpeed;
    private boolean shouldShoot;

    public PlayerControllerComponent() {
        targetDirection = new Vector2(Vector2.Zero);
        playerSpeed = 1f;
        shouldShoot = false;
    }

    public PlayerControllerComponent(float speed) {
        targetDirection = new Vector2(Vector2.Zero);
        playerSpeed = speed;
        shouldShoot = false;
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

    public boolean getShouldShoot() {
        return shouldShoot;
    }

    public void setShouldShoot(boolean shouldShoot) {
        this.shouldShoot = shouldShoot;
    }
}