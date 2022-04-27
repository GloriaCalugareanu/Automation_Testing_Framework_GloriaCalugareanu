package managers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static Properties testingProperties;
    private static String pathToProperties = "src/main/resources/configuration.properties";

    public static void initializeProperties() {
        testingProperties = new Properties();
        try {
            testingProperties.load(new FileReader(pathToProperties));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static String getBrowserType() {
        if (testingProperties == null) initializeProperties();
        String collectedBrowserType = testingProperties.getProperty("browserType");
        if (collectedBrowserType != null) {
            return collectedBrowserType;
        } else {
            throw new RuntimeException("The browser type was not defined in configuration.Please take a look");
        }
    }
    public static String getBaseURL(){
        if(testingProperties==null)
            initializeProperties();
        String collectedBaseURL=testingProperties.getProperty("Base_URL");
        if (collectedBaseURL != null) {
            return collectedBaseURL;
        } else {
            throw new RuntimeException("The base URL was not defined in configuration.Please take a look");
        }
    }
}
