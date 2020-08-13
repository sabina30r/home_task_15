package nix.edu.factory.impl;

import nix.edu.annotation.PropertyKey;
import nix.edu.config.PropertiesReader;
import nix.edu.factory.ObjectFactory;
import nix.edu.data.AppProperties;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class PropertiesFactory implements ObjectFactory<AppProperties> {

    private static AppProperties instance;
    private static PropertiesReader reader;
    private String path;

    public PropertiesFactory(PropertiesReader reader, String path) {
        this.reader = reader;
        this.path = path;
    }

    @Override
    public AppProperties getObjectInstance() {
        try {
            instance = AppProperties.class.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        initFields(path);
        return instance;
    }

    private void initFields(String path) {
        Map<String, String> map = reader.readProperties(path);
        Field[] declaredFields = AppProperties.class.getDeclaredFields();
        for (Field field : declaredFields) {
            PropertyKey annotation = field.getAnnotation(PropertyKey.class);
            if (annotation != null) {
                String value = annotation.value().isEmpty() ? map.get(field.getName()) : map.get(annotation.value());
                field.setAccessible(true);
                try {
                    field.set(instance, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Having problems with field initialization. " + e.getMessage());
                }
            }
        }
    }

}
