package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class ShootingComponent extends Component {
    private Vector2 shotSpeed;

    public ShootingComponent() {
        shotSpeed = Vector2.Zero;
    }

    public ShootingComponent(Vector2 shotSpeed) {
        this.shotSpeed = shotSpeed;
    }

    public Vector2 getShotSpeed() {
        return shotSpeed;
    }

    public void setShotSpeed(Vector2 shotSpeed) {
        this.shotSpeed = shotSpeed;
    }
}