package ru.sawtooth.view.page;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "typeTaskName")
public class TypeTaskNamePage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Введите название задачи:";
    }
}
