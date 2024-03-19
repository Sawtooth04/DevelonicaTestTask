package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "incorrectInput")
public class IncorrectInputPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Введены некорректные данные!";
    }
}
