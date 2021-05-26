package com.lt.commonutils.utils.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;


/**
 * csv导入的时候用到的工具类
 *
 * @author LT
 * @date 3.14
 */
public class CsvUtill {

    private static final String UTF8 = "utf-8";
    private static final String GBK = "GBK";


    public static HashSet<String> importCsv(MultipartFile picFile) throws Exception {
        int a = 0;

        HashSet<String> objects = new HashSet<>();
        // 判断是否为空
        if (picFile.isEmpty()) {
            return null;
        }
//        csv文件默认编码为ANSI，这里出现乱码主要是编码不一致问题 参考博课
//        DataInputStream in = new DataInputStream(new FileInputStream(new File("d:\\*.csv")));
//        BufferedReader br= new BufferedReader(new InputStreamReader(in,"GBK"));

        DataInputStream dataInputStream = new DataInputStream(picFile.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(dataInputStream, UTF8));
//        InputStreamReader ins = new InputStreamReader(inputStream);
//        BufferedReader br = new BufferedReader(ins);

        String line = "";
        while ((line = br.readLine()) != null) {
            //将第一行的数据不进行导入
            if (a == 0) {
                a = a + 1;
            } else {
                //转成流文件后，就可以自己处理了
                objects.add(line);
            }
        }
        return objects;
    }
}


