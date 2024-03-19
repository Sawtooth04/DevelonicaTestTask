package ru.sawtooth.model;

import java.util.Date;

public interface Model extends ViewModel {
    public boolean addTask(int groupIndex, String name, String description, Date plannedFor);

    public void addTaskGroup(String name);
    public void deleteTaskGroup(int taskGroupIndex);

    public void deleteTask(int taskGroupIndex, int taskIndex);
}
