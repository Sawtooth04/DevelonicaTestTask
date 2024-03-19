package ru.sawtooth.view.page;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "menu")
public final class MenuPage implements Page {
    @Override
    public String render(ViewModel model) {
        StringBuilder builder = new StringBuilder();
        builder.append("Главное меню:\n");
        builder.append("0. Показать меню\n");
        builder.append("1. Добавить группу задач\n");
        builder.append("2. Добавить задачу\n");
        builder.append("3. Просмотреть список групп\n");
        builder.append("4. Просмотреть список задач\n");
        builder.append("5. Удалить задачу\n");
        builder.append("6. Удалить группу\n");
        builder.append("7. Пометить задачу выполненной\n");
        builder.append("8. Выход");
        return builder.toString();
    }
}
