package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "typeTaskIndex")
public class TypeTaskIndexPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Выберите задачу (введите номер):";
    }
}
