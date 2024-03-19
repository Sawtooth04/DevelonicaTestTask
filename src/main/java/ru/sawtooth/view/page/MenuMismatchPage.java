package ru.sawtooth.view.page;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.annotation.PageBean;

@PageBean(name = "menuMismatch")
public class MenuMismatchPage implements Page {
    @Override
    public String render(ViewModel model) {
        return "Выбран несуществующий пункт меню. Повторите ввод!";
    }
}
