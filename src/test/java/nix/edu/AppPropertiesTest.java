package nix.edu;

import nix.edu.config.PropertiesReader;
import nix.edu.data.AppProperties;
import nix.edu.factory.impl.PropertiesFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppPropertiesTest {
    private static AppProperties appProperties;

    @BeforeAll
    public static void initialize() {
        appProperties = new PropertiesFactory(new PropertiesReader(), "app.properties").getObjectInstance(AppProperties.class);
    }

    @Test
    public void getPropertiesTest() {
        assertEquals("jdbc:postgresql://localhost:5432/locations", appProperties.url);
        assertEquals("postgres", appProperties.user);
        assertEquals("change_me", appProperties.password);
    }


}
