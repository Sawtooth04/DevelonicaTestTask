package ru.sawtooth.controller.endpoint.endpoint;

import ru.sawtooth.model.Model;
import ru.sawtooth.util.safetyscanner.SafetyScanner;
import ru.sawtooth.view.ViewStorage;

import java.io.IOException;
import java.util.function.Consumer;

public final class DeleteTaskGroupEndpoint implements Endpoint {
    private final SafetyScanner scanner;

    public DeleteTaskGroupEndpoint(SafetyScanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(ViewStorage view, Model model, Consumer<String> displayView) {
        int taskGroupIndex;

        try {
            displayView.accept(view.get("typeTaskGroupIndex", model));
            taskGroupIndex = scanner.intInRange(1, model.getGroups().size()) - 1;
            model.deleteTaskGroup(taskGroupIndex);
            displayView.accept(view.get("success", model));
        }
        catch (IOException e) {
            displayView.accept(view.get("incorrectInput", model));
        }
    }
}
