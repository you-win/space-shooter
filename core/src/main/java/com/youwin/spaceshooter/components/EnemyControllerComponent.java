package com.youwin.spaceshooter.components;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class EnemyControllerComponent extends Component {
    private Vector2 targetDirection;
    private float enemySpeed = 1f;

    public EnemyControllerComponent() {
        targetDirection = new Vector2(Vector2.Zero);
    }

    public EnemyControllerComponent(float speed) {
        targetDirection = new Vector2(Vector2.Zero);
        enemySpeed = speed;
    }

    public Vector2 getTargetDirection() {
        return targetDirection;
    }

    public void setTargetDirection(Vector2 newTargetDirection) {
        targetDirection = newTargetDirection;
    }
}