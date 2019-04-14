package com.lt.commparent.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class CsvUtill {


    public static List<String> importCsv(MultipartFile picFile) throws Exception {
        List<String> dataList = new ArrayList<String>();
        // 判断是否为空
        if (picFile.isEmpty()) {
            return null;
        }

        InputStream inputStream = picFile.getInputStream();
        InputStreamReader ins = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(ins);

        String line = "";

        while ((line = br.readLine()) != null) {
            //转成流文件后，就可以自己处理了
            dataList.add(line);
        }
        return dataList;

    }


}


