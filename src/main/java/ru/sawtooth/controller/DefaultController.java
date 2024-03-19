package ru.sawtooth.controller;

import ru.sawtooth.controller.endpoint.list.EndpointsList;
import ru.sawtooth.model.Model;
import ru.sawtooth.util.safetyscanner.SafetyScanner;
import ru.sawtooth.view.ViewStorage;

import java.io.IOException;

public final class DefaultController implements Controller {
    private final ViewStorage view;
    private final Model model;
    private final EndpointsList endpointsList;
    private final SafetyScanner scanner;

    public DefaultController(ViewStorage view, Model model, EndpointsList endpointsList, SafetyScanner scanner) {
        this.view = view;
        this.model = model;
        this.endpointsList = endpointsList;
        this.scanner = scanner;
    }

    private void displayView(String view) {
        System.out.println(view);
    }

    @Override
    public void run() {
        int key = 0;

        endpointsList.get(0).handle(view, model, this::displayView);
        do {
            try {
                key = scanner.intInRange(0, 8);
                endpointsList.get(key).handle(view, model, this::displayView);
            }
            catch (IOException e) {
                endpointsList.get(9).handle(view, model, this::displayView);
            }
        }
        while (key != 8);
    }
}
