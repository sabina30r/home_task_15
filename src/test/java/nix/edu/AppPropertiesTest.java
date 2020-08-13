package nix.edu;

import nix.edu.config.PropertiesReader;
import nix.edu.data.AppProperties;
import nix.edu.factory.impl.PropertiesFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppPropertiesTest {
    private static AppProperties appProperties;

    @BeforeAll
    public static void initialize() {
        appProperties = new PropertiesFactory(new PropertiesReader(), "app.properties").getObjectInstance();
    }

    @Test
    public void getPropertiesTest() {
        assertTrue(appProperties.url.equals("jdbc:postgresql://localhost:5432/locations") &&
                appProperties.user.equals("postgres") &&
                appProperties.password.equals("change_me"));
    }


}
