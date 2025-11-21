package doda25.team12;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VersionUtil {

    public String getVersion() {
        String version = "unknown";

        // load the file from the classpath
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("version.properties")) {

            if (input == null) {
                System.out.println("Sorry, unable to find version.properties");
                return version;
            }

            // Parse the properties
            Properties prop = new Properties();
            prop.load(input);

            // Get the version string
            version = prop.getProperty("version");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return version;
    }
}