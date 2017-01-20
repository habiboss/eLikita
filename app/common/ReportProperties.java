/**
 *
 */
package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;


/**
 * @author Aboubacar GAGERE
 */
public class ReportProperties {

    private static ReportProperties INSTANCE = new ReportProperties();
    private static HashMap<String, String> propertiesContainer;


    private ReportProperties() {
        propertiesContainer = new HashMap<String, String>();
        loadProperties();

    }

    public static ReportProperties getProperties() {
        return INSTANCE;

    }

    public String getValueByKey(String key) {
        return propertiesContainer.get(key);
    }

    private void loadProperties() {
        File file = new File("conf/conf.properties");
        try {
            FileInputStream fileInput = new FileInputStream(file);
            System.out.println(file.getName());
            Properties properties = new Properties();
            try {
                properties.load(fileInput);
                fileInput.close();
                for (Iterator<?> iterator = properties.keySet().iterator(); iterator.hasNext(); ) {
                    String key = (String) iterator.next();
                    String value = properties.getProperty(key);
                    propertiesContainer.put(key, value);

                }
            } catch (IOException e) {
                System.err.println("impossible de trouver le fichier");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

    }
}
