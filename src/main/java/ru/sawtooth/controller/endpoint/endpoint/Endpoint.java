package ru.sawtooth.controller.endpoint.endpoint;

import ru.sawtooth.model.Model;
import ru.sawtooth.view.ViewStorage;

import java.util.function.Consumer;

public interface Endpoint {
    public void handle(ViewStorage view, Model model, Consumer<String> displayView);
}
