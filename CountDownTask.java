package com.epam.rd.autotasks;

public class CountDownTask implements Task {

    private int value;
    private boolean taskComplete = false;

    public CountDownTask(int value) {
        if (value > 0) {
            this.value = value;
        } else {
            this.value = 0;
            this.taskComplete = true;
        }

    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (value >= 1) {
            value--;
        }
        if (value == 0) {
            taskComplete = true;
        }
    }

    @Override
    public boolean isFinished() {
        return taskComplete;
    }
}
