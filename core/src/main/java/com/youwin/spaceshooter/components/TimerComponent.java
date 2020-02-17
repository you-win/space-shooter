package com.youwin.spaceshooter.components;

import java.util.HashMap;
import java.util.Map;

import com.artemis.Component;

public class TimerComponent extends Component {
    public class Timer {
        private float initialTime;
        private float remainingTime;
        private boolean isReady;
        private boolean isStarted;
        private boolean isFinished;
        private boolean shouldStart;

        public Timer() {
            initialTime = 0f;
            remainingTime = initialTime;
            isReady = true;
            isStarted = false;
            isFinished = false;
            shouldStart = false;
        }

        public Timer(float initialTime) {
            this.initialTime = initialTime;
            remainingTime = initialTime;
            isReady = true;
            isStarted = false;
            isFinished = false;
            shouldStart = false;
        }

        public Timer(float initialTime, boolean isStarted) {
            this.initialTime = initialTime;
            remainingTime = initialTime;
            isReady = true;
            this.isStarted = isStarted;
            isFinished = false;
            shouldStart = false;
        }

        public float getInitialTime() {
            return initialTime;
        }

        public void setInitialTime(float initialTime) {
            this.initialTime = initialTime;
        }

        public float getRemainingTime() {
            return remainingTime;
        }

        public void setRemainingTime(float remainingTime) {
            this.remainingTime = remainingTime;
        }

        public boolean getIsReady() {
            return isReady;
        }

        public void setIsReady(boolean isReady) {
            this.isReady = isReady;
        }

        public boolean getIsStarted() {
            return isStarted;
        }

        public void setIsStarted(boolean isStarted) {
            this.isStarted = isStarted;
        }

        public boolean getIsFinished() {
            return isFinished;
        }

        public void setIsFinished(boolean isFinished) {
            this.isFinished = isFinished;
        }

        public boolean getShouldStart() {
            return shouldStart;
        }

        public void setShouldStart(boolean shouldStart) {
            this.shouldStart = shouldStart;
        }
    }

    private Map<String, Timer> timers;

    public TimerComponent() {
        timers = new HashMap<String, Timer>();
    }

    public Timer getTimer(String name) {
        return timers.get(name);
    }

    public void addTimer(String name, float duration) {
        timers.put(name, new Timer(duration));
    }

    public void addStartedTimer(String name, float duration) {
        timers.put(name, new Timer(duration, true));
    }

    public void removeTimer(String name) {
        timers.remove(name);
    }

    public boolean doesTimerExist(String name) {
        return timers.containsKey(name);
    }

    public Map<String, Timer> getTimers() {
        return timers;
    }

    public void setTimers(Map<String, Timer> timers) {
        this.timers = timers;
    }
}