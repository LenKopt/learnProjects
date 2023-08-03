package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {

    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        setDependencies(dependsOn);
    }

    private void setDependencies(UserStory[] dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public void complete() {
        if (isCompleted() == false) {
            boolean allComlete = true;
            for (UserStory item : getDependencies()) {
                if (item==null){
                    continue;
                }
                if (item.isCompleted() == false) {
                    allComlete = false;
                }
            }
            if (allComlete) {
                super.complete();
            }
        }
    }

    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    @Override
    public String toString() {
        return "[US " + this.getId() + "] " + this.getName();
    }
}
