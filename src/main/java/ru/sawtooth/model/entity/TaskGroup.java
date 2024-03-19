package ru.sawtooth.model.entity;

import java.util.ArrayList;
import java.util.List;

public final class TaskGroup {
    private String name;
    private final List<Task> tasks;

    public TaskGroup(String name) {
        this.name = name;
        tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}
