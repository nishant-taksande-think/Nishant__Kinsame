package util;

import java.util.ResourceBundle;

public class TestConfigReader {
    private static ResourceBundle rb = ResourceBundle.getBundle("config");
    public static String read(String key) {
        return rb.containsKey(key)?rb.getString(key):"";
    }
    public static String read(String key,String defaultVal) {
        return rb.containsKey(key)?rb.getString(key):defaultVal;
    }
}
