package ru.sawtooth.controller.endpoint.endpoint;

import ru.sawtooth.model.Model;
import ru.sawtooth.util.safetyscanner.SafetyScanner;
import ru.sawtooth.view.ViewStorage;

import java.io.IOException;
import java.util.Date;
import java.util.function.Consumer;

public final class AddTaskEndpoint implements Endpoint {
    private final SafetyScanner scanner;

    public AddTaskEndpoint(SafetyScanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void handle(ViewStorage view, Model model, Consumer<String> displayView) {
        String name, description;
        Date plannedFor;
        int taskGroupIndex;

        try {
            displayView.accept(view.get("typeTaskName", model));
            name = scanner.notEmptyString();
            displayView.accept(view.get("typeTaskDescription", model));
            description = scanner.notEmptyString();
            displayView.accept(view.get("typeTaskPlannedFor", model));
            plannedFor = scanner.futureDate();
            displayView.accept(view.get("typeTaskGroupIndex", model));
            taskGroupIndex = scanner.intInRange(1, model.getGroups().size());
            if (model.addTask(taskGroupIndex - 1, name, description, plannedFor))
                displayView.accept(view.get("success", model));
            else
                displayView.accept(view.get("incorrectInput", model));
        }
        catch (IOException e) {
            displayView.accept(view.get("incorrectInput", model));
        }
    }
}
