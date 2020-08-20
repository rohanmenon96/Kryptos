package com.chainanalysis.kryptos.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {

    private static final Map<String, Properties> propertiesMap = new HashMap<>();

    public static Properties getProperties(String fileName) throws IOException {

        if (!propertiesMap.containsKey(fileName)) {
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
            Properties properties = new Properties();
            properties.load(inputStream);
            propertiesMap.put(fileName, properties);
        }
        return propertiesMap.get(fileName);

    }

}
