package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.model.entities.TaskGroup;
import ru.sawtooth.view.loader.annotation.PageBean;

import java.util.List;

@PageBean(name = "taskGroupsList")
public class TaskGroupsListPage implements Page {
    @Override
    public String render(ViewModel model) {
        StringBuilder builder = new StringBuilder();
        List<TaskGroup> groups = model.getGroups();

        builder.append("Список групп задач:");
        if (!groups.isEmpty())
            for (int i = 0; i < groups.size(); i++)
                builder.append(String.join("", "\n\t", Integer.toString(i + 1), ". ",
                        groups.get(i).getName()));
        else
            builder.append("\nСписок пуст!");
        return builder.toString();
    }
}
