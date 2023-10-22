package com.example.lib_common.unit;


import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

public class PropUnit {

//    private final Properties properties;

    private PropUnit() throws IOException {
//
//        properties = new Properties();
//
//        FileInputStream is = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
//
//        properties.load(is);
//
//        is.close();

    }

    public static String getProperty(final String name, final String defaultValue) throws IOException {
        Properties properties = new Properties();

        FileInputStream is = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));

        properties.load(is);

        is.close();
        return properties.getProperty(name, defaultValue);

    }



    /**
     * 设置属性值
     *
     * @param key   长度不能超过31，key.length <= 30
     * @param value 长度不能超过91，value.length<=90
     */
    public static void set(String key, String value) {
        // android.os.SystemProperties
        // public static void set(String key, String val)
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("set", String.class, String.class);
            method.invoke(null, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取属性值
     *
     * @param key 长度不能超过31，key.length <= 30
     * @param defValue
     * @return
     */
    public static String get(String key, String defValue) {
        // android.os.SystemProperties
        // public static String get(String key, String def)
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", String.class, String.class);
            return (String) method.invoke(null, key, defValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defValue;
    }
}