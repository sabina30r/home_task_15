package nix.edu.config;

import nix.edu.util.ResourceUtil;

import java.util.Map;

public class PropertiesReader {

    public Map<String, String> readProperties(String file) {

        return ResourceUtil.getResource(file);
    }
}
