package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.EnemyControllerComponent;
import com.youwin.spaceshooter.components.PlayerControllerComponent;
import com.youwin.spaceshooter.components.PositionComponent;
import com.youwin.spaceshooter.components.ShootingComponent;
import com.youwin.spaceshooter.components.TimerComponent;
import com.youwin.spaceshooter.entities.BulletBuilder;

@Wire
public class ShootingSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[ShootingSystem]", Logger.INFO);

    private ComponentMapper<PlayerControllerComponent> playerControllerMapper;
    private ComponentMapper<EnemyControllerComponent> enemyControllerMapper;
    private ComponentMapper<ShootingComponent> shootingMapper;
    private ComponentMapper<PositionComponent> positionMapper;
    private ComponentMapper<TimerComponent> timerMapper;

    public ShootingSystem() {
        super(Aspect.all(ShootingComponent.class, PositionComponent.class, TimerComponent.class));
    }

    @Override
    protected void process(int entityId) {
        ShootingComponent shootingComponent = shootingMapper.get(entityId);
        PositionComponent position = positionMapper.get(entityId);
        TimerComponent.Timer timer = timerMapper.get(entityId).getTimer("ShootingComponent");

        if (playerControllerMapper.has(entityId)) {
            PlayerControllerComponent controller = playerControllerMapper.get(entityId);
            if (controller.getShouldShoot()) {
                if (timer.getIsReady()) {
                    timer.setShouldStart(true);
                    fire(shootingComponent.getShotSpeed(), position.getPoint());
                }
                controller.setShouldShoot(false);
            }
        }
        if (enemyControllerMapper.has(entityId)) {
            EnemyControllerComponent controller = enemyControllerMapper.get(entityId);
            // TODO add enemy shooting logic here
        }
    }

    private void fire(Vector2 shotSpeed, Vector2 position) {
        // TODO change this to something more generic
        BulletBuilder.createBullet(world, position, 2f, shotSpeed);
    }
}