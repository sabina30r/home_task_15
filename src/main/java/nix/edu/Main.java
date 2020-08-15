package nix.edu;

import nix.edu.config.PropertiesReader;
import nix.edu.data.AppProperties;
import nix.edu.factory.impl.PropertiesFactory;

public class Main {
    private static String propertyFile = "app.properties";

    public static void main(String[] args) {
        PropertiesReader propertiesReader = new PropertiesReader();
        AppProperties appProperties = new PropertiesFactory(propertiesReader, propertyFile).getObjectInstance(AppProperties.class);
        System.out.println("url  = " + appProperties.url);
        System.out.println("user = " + appProperties.user);
        System.out.println("password = " + appProperties.password);

    }
}
