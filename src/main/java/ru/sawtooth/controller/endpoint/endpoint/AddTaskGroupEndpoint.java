package ru.sawtooth.controller.endpoint.endpoint;

import ru.sawtooth.model.Model;
import ru.sawtooth.util.safetyscanner.SafetyScanner;
import ru.sawtooth.view.ViewStorage;

import java.io.IOException;
import java.util.function.Consumer;

public final class AddTaskGroupEndpoint implements Endpoint {
    private final SafetyScanner scanner;

    public AddTaskGroupEndpoint(SafetyScanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(ViewStorage view, Model model, Consumer<String> displayView) {
        String name;

        try {
            displayView.accept(view.get("typeGroupName", model));
            name = scanner.notEmptyString();
            displayView.accept(view.get("success", model));
            model.addTaskGroup(name);
        }
        catch (IOException e) {
            displayView.accept(view.get("incorrectInput", model));
        }
    }
}
