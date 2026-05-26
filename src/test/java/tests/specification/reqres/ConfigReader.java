package tests.specification.reqres;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("Файл config.properties не найден в resources!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApiKey() {
        String systemKey = System.getProperty("api.key");

        if (systemKey != null && !systemKey.isEmpty()) {
            return systemKey;
        }

        return properties.getProperty("api.key", "default_apiKey_if_needed");
    }
}