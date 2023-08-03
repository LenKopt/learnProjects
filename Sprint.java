package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {

    public int capacity, ticketsLimit;
    public int capacityReal = 0, ticketsLimitReal = 0;
    public Ticket[] array;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.array = new Ticket[ticketsLimitReal];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null) {
            return false;
        }
        if (userStory.isCompleted() == false && ticketsLimitReal + 1 <= ticketsLimit && capacityReal + userStory.getEstimate() <= capacity) {
            UserStory[] userStoriesDependencies = userStory.getDependencies();
            int index;
            for (UserStory item : userStoriesDependencies) {
                index = Arrays.asList(array).indexOf(item);
                if (index != -1) {
                    if (array[index].isCompleted()) {
                        return false;
                    }
                }else {
                    return false;
                }

            }
            array = append(array, userStory);
            ticketsLimitReal++;
            capacityReal = capacityReal + userStory.getEstimate();
            return true;
        } else {
            return false;
        }
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null) {
            return false;
        }
        if (bugReport.isCompleted() == false && ticketsLimitReal + 1 <= ticketsLimit && capacityReal + bugReport.getEstimate() <= capacity) {
            array = append(array, bugReport);
            ticketsLimitReal++;
            capacityReal = capacityReal + bugReport.getEstimate();
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] getTickets() {
        return array.clone();
    }

    public int getTotalEstimate() {
        return capacityReal;
    }

    private static Ticket[] append(Ticket[] arr, Ticket element) {
        Ticket[] arrayNew = new Ticket[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arrayNew[i] = arr[i];
        }
        arrayNew[arr.length] = element;
        return arrayNew;
    }
}
