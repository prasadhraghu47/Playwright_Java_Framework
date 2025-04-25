package Config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }




}
