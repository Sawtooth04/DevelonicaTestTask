package ru.sawtooth.model;

import ru.sawtooth.model.entities.Task;
import ru.sawtooth.model.entities.TaskGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class DefaultModel implements Model {
    private final List<TaskGroup> groups;

    public DefaultModel() {
        groups = new ArrayList<>();
    }

    @Override
    public boolean addTask(int groupIndex, String name, String description, Date plannedFor) {
        if (groupIndex >= groups.size())
            return false;
        groups.get(groupIndex).addTask(new Task(name, description, plannedFor));
        return true;
    }

    @Override
    public void addTaskGroup(String name) {
        groups.add(new TaskGroup(name));
    }

    @Override
    public void deleteTaskGroup(int taskGroupIndex) {
        groups.get(taskGroupIndex).getTasks().clear();
        groups.remove(taskGroupIndex);
    }

    @Override
    public void deleteTask(int taskGroupIndex, int taskIndex) {
        groups.get(taskGroupIndex).getTasks().remove(taskIndex);
    }

    @Override
    public List<TaskGroup> getGroups() {
        return groups;
    }
}
