package ru.sawtooth.view;

import ru.sawtooth.model.ViewModel;

public interface ViewStorage {
    public String get(String name, ViewModel model);
}
