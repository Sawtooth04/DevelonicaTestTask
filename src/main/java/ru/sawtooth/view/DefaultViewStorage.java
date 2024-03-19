package ru.sawtooth.view;

import ru.sawtooth.model.ViewModel;
import ru.sawtooth.view.loader.PagesClassLoader;
import ru.sawtooth.view.loader.annotation.PageBean;
import ru.sawtooth.view.page.Page;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class DefaultViewStorage implements ViewStorage {
    private final Map<String, Page> pagesMap;

    public DefaultViewStorage(PagesClassLoader pagesLoader, String pagesPackage) {
        pagesMap = new HashMap<>();
        fillPagesMap(pagesLoader, pagesPackage);
    }

    private void fillPagesMap(PagesClassLoader pagesLoader, String pagesPackage) {
        Set<Class<?>> pages = pagesLoader.getPages(pagesPackage);

        for (Class<?> page : pages)
            try {
                pagesMap.put(page.getAnnotation(PageBean.class).name(), (Page) page.getDeclaredConstructor().newInstance());
            }
            catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.err.println(e.getMessage());
            }
    }

    @Override
    public String get(String name, ViewModel model) {
        return pagesMap.get(name).render(model);
    }
}
