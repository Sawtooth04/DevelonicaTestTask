package ru.sawtooth.view.loader;

import java.util.Set;

public interface PagesClassLoader {
    public Set<Class<?>> getPages(String pagesPackage);
}
