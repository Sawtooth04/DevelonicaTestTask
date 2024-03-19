package ru.sawtooth.view.page;

import ru.sawtooth.model.ViewModel;

public interface Page {
    public String render(ViewModel model);
}
