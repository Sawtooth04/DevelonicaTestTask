package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.model.entities.TaskGroup;
import ru.sawtooth.util.dateformatter.DateFormatter;
import ru.sawtooth.view.loader.annotation.PageBean;

import java.util.List;

@PageBean(name = "tasksList")
public class TasksListPage implements Page {
    @Override
    public String render(ViewModel model) {
        StringBuilder builder = new StringBuilder();
        List<TaskGroup> groups = model.getGroups();
        DateFormatter formatter = new DateFormatter();

        builder.append("Список задач:");
        if (!groups.isEmpty())
            for (int i = 0; i < groups.size(); i++) {
                builder.append(String.join("", "\n\t", Integer.toString(i + 1), ". ",
                        groups.get(i).getName()));
                if (!groups.get(i).getTasks().isEmpty())
                    for (int j = 0; j < groups.get(i).getTasks().size(); j++)
                        builder.append(String.join("", "\n\t\t", Integer.toString(j + 1), ". ",
                                groups.get(i).getTask(j).getName(), "\n\t\t\t", groups.get(i).getTask(j).getDescription(),
                                "\n\t\t\tКрайний срок: ", formatter.get().format(groups.get(i).getTask(j).getPlannedFor()),
                                "\n\t\t\tЗадача ", groups.get(i).getTask(j).isCompleted() ? "выполнена" : "не выполнена"));
                else
                    builder.append("\n\t\tСписок задач пуст!");
            }
        else
            builder.append("\nСписок пуст!");
        return builder.toString();
    }
}
