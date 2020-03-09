package com.youwin.spaceshooter.components;

import com.badlogic.gdx.math.Vector2;

public interface GenericController {
    public Vector2 getTargetDirection();

    public void setTargetDirection(Vector2 targetDirection);

    public float getSpeed();

    public void setSpeed(float speed);
}