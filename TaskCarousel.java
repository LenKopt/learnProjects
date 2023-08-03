package com.epam.rd.autotasks;

public class TaskCarousel {
    private int capacity;
    private Task[] arrayTask;
    private int currentTask = 0;
    private int executeTask = 0;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.arrayTask = new Task[capacity];
    }

    public boolean addTask(Task task) {
        if ((isFull() == false) && (task.isFinished() == false)) {

            if ((task instanceof CountDownTask) && (((CountDownTask) task).getValue() == 0)) {
                return false;
            }

            pasteTask(arrayTask, task);
            if (currentTask != (arrayTask.length - 1)) {
                currentTask++;
            } else {
                currentTask = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    void pasteTask(Task[] array, Task curTask) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = curTask;
                break;
            }
        }
    }

    public boolean execute() {
        for (int index = executeTask; index < arrayTask.length; index++) {
            if (arrayTask[executeTask] != null) {
                arrayTask[executeTask].execute();
                if (arrayTask[executeTask].isFinished()) {
                    arrayTask[executeTask] = null;
                }
                if (executeTask != (arrayTask.length - 1)) {
                    executeTask++;
                } else {
                    executeTask = 0;
                }
                return true;
            } else {
                if (executeTask != (arrayTask.length - 1)) {
                    executeTask++;
                } else {
                    executeTask = 0;
                    index = 0;
                }
            }
        }
        executeTask = 0;
        return false;
    }

    public boolean isFull() {
        for (int index = 0; index < arrayTask.length; index++) {
            if (arrayTask[index] == null) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        for (int index = 0; index < arrayTask.length; index++) {
            if (arrayTask[index] == null) {
                continue;
            }
            if (arrayTask[index].isFinished() == false) {
                return false;
            }
        }
        return true;
    }

}
