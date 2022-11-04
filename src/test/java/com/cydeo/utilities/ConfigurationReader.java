package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1--> create the object of Properties
    private static Properties properties = new Properties();

    static {
        try {
            //2--> we need to open the file in java memory : FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");
            //3--> load the properties object
            properties.load(file);
            //4--> close the file
            file.close();
        } catch (IOException e) {
            System.out.println("File not found in the ConfigurationReader class.");
            e.printStackTrace();
        }
    }


    public static String getProperty(String keyword)  {
        String value = properties.getProperty(keyword);
        return value;
    }
}
