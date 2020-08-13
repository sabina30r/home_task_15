package nix.edu.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class ResourceUtil {
    public static Map<String, String> getResource(String resource) {
        String path = ClassLoader.getSystemResource(resource).getPath();
        try {
            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            return lines.map(line -> line.split("=")).collect(toMap(arr -> arr[0], arr -> arr[1]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file: " + e.getMessage());
        }
    }
}
