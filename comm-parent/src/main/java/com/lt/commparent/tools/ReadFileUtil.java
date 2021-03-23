package com.lt.commparent.tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadFileUtil {
    private static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * @Title: readFile 从properties文件中读取url的配置信息
     * @Description:
     * @author Administrator
     */
    public static String readFile(String proper) {
        try {
            // 获取文件流（方法1或2均可）
            //InputStream inputStream = new BufferedInputStream(
            //new FileInputStream(new File("/src/main/resources/url.properties"))); // 方法1
            InputStream inputStream =
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("url.properties");
            // //方法2
            Properties prop = new Properties();

            prop.load(new InputStreamReader(inputStream, DEFAULT_ENCODING)); // 加载格式化后的流

            String driverClassName = prop.getProperty(proper);
            return driverClassName;

        } catch (FileNotFoundException e) {
            System.out.println("properties文件路径有误！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return proper;
    }
}
