package com.youwin.spaceshooter.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.annotations.Wire;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.utils.Logger;
import com.youwin.spaceshooter.components.TimerComponent;

@Wire
public class TimerSystem extends IteratingSystem {
    private static final Logger LOG = new Logger("[TimerSystem]", Logger.INFO);

    private ComponentMapper<TimerComponent> timerMapper;

    public TimerSystem() {
        super(Aspect.all(TimerComponent.class));
    }

    @Override
    protected void process(int entityId) {
        TimerComponent timerComponent = timerMapper.get(entityId);

        for (TimerComponent.Timer timer : timerComponent.getTimers().values()) {
            if (timer.getShouldStart() && timer.getIsReady()) {
                startTimer(timer);
            }

            if (timer.getIsStarted()) {
                tickTimer(timer);
            }

            // If a timer is finished, it needs to be reset from whatever
            // instance is using the timer
        }
    }

    private void startTimer(TimerComponent.Timer timer) {
        timer.setShouldStart(false);
        timer.setIsReady(false);
        timer.setIsStarted(true);
    }

    private void tickTimer(TimerComponent.Timer timer) {
        if (timer.getRemainingTime() > 0) {
            timer.setRemainingTime(timer.getRemainingTime() - world.getDelta());
        } else {
            timer.setIsReady(true);
            timer.setIsStarted(false);
            timer.setIsFinished(true);
            timer.setRemainingTime(timer.getInitialTime());
        }
    }
}