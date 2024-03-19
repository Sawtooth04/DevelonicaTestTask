package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "success")
public class SuccessPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Операция завершена успешно";
    }
}
