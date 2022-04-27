package managers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties proprietatiDeTestare;
    private static String pathToProeprties = "src/main/resources/configuration.properties";

    public static void initializeProperties() {
        proprietatiDeTestare = new Properties();
        try {
            proprietatiDeTestare.load(new FileReader(pathToProeprties));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getBrowserType() {
        if (proprietatiDeTestare == null) initializeProperties();
        String collectedBrowserType = proprietatiDeTestare.getProperty("browserType");
        if (collectedBrowserType != null) {
            return collectedBrowserType;
        } else {
            throw new RuntimeException("The browser type was not defined in configuration. Please, take a look at it!");
        }
    }

    public static String getBaseUrl() {
        if (proprietatiDeTestare == null) initializeProperties();
        String collectdBaseUrl = proprietatiDeTestare.getProperty("Base_URL");
        if (collectdBaseUrl != null) {
            return collectdBaseUrl;
        } else {
            throw new RuntimeException("The Base URL was not defined in configuration. Please, take a look at it!");
        }
    }
}
