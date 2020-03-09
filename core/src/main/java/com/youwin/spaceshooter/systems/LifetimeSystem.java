package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.HitboxComponent;
import com.youwin.spaceshooter.components.TimerComponent;

@Wire
public class LifetimeSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[LifetimeSystem]", Logger.INFO);

    private ComponentMapper<TimerComponent> timerMapper;
    private ComponentMapper<HitboxComponent> hitboxMapper;

    public LifetimeSystem() {
        super(Aspect.all(TimerComponent.class));
    }

    @Override
    protected void process(int entityId) {
        TimerComponent timerComponent = timerMapper.get(entityId);

        if (timerComponent.doesTimerExist("Lifetime")) {
            TimerComponent.Timer timer = timerComponent.getTimer("Lifetime");
            // TODO refactor to make use of entity pooling
            if (timer.getIsFinished()) {
                HitboxComponent hitbox = hitboxMapper.getSafe(entityId, null);
                if (hitbox != null) {
                    hitbox.cleanup();
                }
                world.delete(entityId);
            }
        }
    }
}