package ru.sawtooth;

import ru.sawtooth.controller.Controller;
import ru.sawtooth.controller.DefaultController;
import ru.sawtooth.controller.endpoint.list.DefaultEndpointsList;
import ru.sawtooth.controller.endpoint.list.EndpointsList;
import ru.sawtooth.model.DefaultModel;
import ru.sawtooth.model.Model;
import ru.sawtooth.util.safetyscanner.DefaultSafetyScanner;
import ru.sawtooth.util.safetyscanner.SafetyScanner;
import ru.sawtooth.view.loader.DefaultPagesClassLoader;
import ru.sawtooth.view.DefaultViewStorage;
import ru.sawtooth.view.ViewStorage;

public class Main {
    public static void main(String[] args) {
        ViewStorage view = new DefaultViewStorage(new DefaultPagesClassLoader(), "ru.sawtooth.view.page");
        Model model = new DefaultModel();
        SafetyScanner scanner = new DefaultSafetyScanner(System.in);
        EndpointsList endpointsList = new DefaultEndpointsList(scanner);
        Controller controller = new DefaultController(view, model, endpointsList, scanner);

        controller.run();
    }
}