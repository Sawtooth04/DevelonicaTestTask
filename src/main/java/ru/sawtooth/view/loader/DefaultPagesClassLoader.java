package ru.sawtooth.view.loader;

import ru.sawtooth.view.loader.annotation.PageBean;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.*;
import java.util.stream.Collectors;

public final class DefaultPagesClassLoader implements PagesClassLoader {
    private List<String> getClassesNames(String pagesPackage) {
        String packagePath = pagesPackage.replace('.', '/');
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File[] files = new File(Objects.requireNonNull(classLoader.getResource(packagePath)).getPath()).listFiles();
        ArrayList<String> result = new ArrayList<>();

        if (files != null)
            for (File file : files)
                result.add(file.getName().replaceAll("\\..*", ""));
        return result;
    }

    private boolean isClassAnnotated(Class<?> pageClass) {
        Annotation[] annotations = pageClass.getAnnotations();

        for (Annotation annotation : annotations)
            if (annotation.annotationType() == PageBean.class)
                return true;
        return false;
    }

    @Override
    public Set<Class<?>> getPages(String pagesPackage) {
        Set<Class<?>> result = new LinkedHashSet<>();
        List<String> classesNames = getClassesNames(pagesPackage);

        for (String name : classesNames)
            try {
                result.add(Class.forName(String.join(".", pagesPackage, name)));
            }
            catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        return result.stream().filter(this::isClassAnnotated).collect(Collectors.toSet());
    }
}
