package ru.sawtooth.model.entities;

import java.util.Date;

public final class Task {
    private String name;

    private final String description;

    private boolean isCompleted;

    private final Date plannedFor;

    public Task(String name, String description, Date plannedFor) {
        this.name = name;
        this.description = description;
        this.plannedFor = plannedFor;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getPlannedFor() {
        return plannedFor;
    }
}
