package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "typeTaskDescription")
public class TypeTaskDescriptionPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Введите описание задачи:";
    }
}
