package ru.sawtooth.controller.endpoint.list;

import ru.sawtooth.controller.endpoint.endpoint.*;
import ru.sawtooth.util.safetyscanner.SafetyScanner;

import java.util.ArrayList;
import java.util.List;

public final class DefaultEndpointsList implements EndpointsList {
    private final List<Endpoint> endpoints;

    public DefaultEndpointsList(SafetyScanner scanner) {
        endpoints = new ArrayList<>();
        initialize(scanner);
    }

    private void initialize(SafetyScanner scanner) {
        endpoints.add(0, new MenuEndpoint());
        endpoints.add(1, new AddTaskGroupEndpoint(scanner));
        endpoints.add(2, new AddTaskEndpoint(scanner));
        endpoints.add(3, new TaskGroupListEndpoint());
        endpoints.add(4, new TaskListEndpoint());
        endpoints.add(5, new DeleteTaskEndpoint(scanner));
        endpoints.add(6, new DeleteTaskGroupEndpoint(scanner));
        endpoints.add(7, new CompleteTaskEndpoint(scanner));
        endpoints.add(8, new ExitEndpoint());
        endpoints.add(9, new MenuMismatchEndpoint());
    }

    @Override
    public Endpoint get(int index) {
        return endpoints.get(index);
    }
}
