package ru.sawtooth.view.page;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "exit")
public class ExitPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Хорошего дня! :)";
    }
}
