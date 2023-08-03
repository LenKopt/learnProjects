package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean taskComplete;
    private boolean executeComplete = false;

    public CompleteByRequestTask() {
        this.taskComplete = false;
    }

    @Override
    public void execute() {
        if (executeComplete != false){
            taskComplete = true;
        }
    }

    @Override
    public boolean isFinished() {
        return taskComplete;
    }

    public void complete() {
        executeComplete = true;
    }
}
