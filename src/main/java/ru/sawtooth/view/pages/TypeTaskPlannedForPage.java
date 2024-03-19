package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "typeTaskPlannedFor")
public class TypeTaskPlannedForPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Введите дату, до которой должна быть выполнена задача (yyyy-MM-dd hh:mm:ss):";
    }
}
