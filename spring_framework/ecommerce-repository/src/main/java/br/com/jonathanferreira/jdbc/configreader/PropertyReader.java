package br.com.jonathanferreira.jdbc.configreader;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {


    static public Properties getProperties() {
        try {
            InputStream inputStream;
            Properties prop = new Properties();
            var filePropName = "database.properties";

            inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(filePropName);

            prop.load(inputStream);
            return prop;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
