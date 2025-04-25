package Config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class YamlConfigReader {
    private static Map<String, Object> config;

    static {
        try (InputStream inputStream = YamlConfigReader.class.getClassLoader().getResourceAsStream("config.yaml")) {
            Yaml yaml = new Yaml();
            config = yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load YAML config", e);
        }
    }

    public static String get(String key) {
        return config.getOrDefault(key, "").toString();
    }
}
