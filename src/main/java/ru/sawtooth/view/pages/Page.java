package ru.sawtooth.view.pages;

import ru.sawtooth.model.ViewModel;

public interface Page {
    public String render(ViewModel model);
}
