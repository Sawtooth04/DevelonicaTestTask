package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "typeTaskGroupIndex")
public class TypeTaskGroupIndex implements Page {
    @Override
    public String render(ViewModel model) {
        return "Выберите группу для задачи (введите номер): ";
    }
}
