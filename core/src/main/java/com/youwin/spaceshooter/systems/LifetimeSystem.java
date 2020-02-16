package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.TimerComponent;

@Wire
public class LifetimeSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[LifetimeSystem]", Logger.INFO);

    private ComponentMapper<TimerComponent> timerMapper;

    public LifetimeSystem() {
        super(Aspect.all(TimerComponent.class));
    }

    @Override
    protected void process(int entityId) {
        TimerComponent timerComponent = timerMapper.get(entityId);

        if (timerComponent.getTimers().containsKey("Lifetime")) {
            TimerComponent.Timer timer = timerComponent.getTimer("Lifetime");
            if (timer.getIsFinished()) {
                LOG.info("Deleting entity");
                world.delete(entityId);
            }
        }
    }
}