package com.lt.commonutils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;

@SpringBootTest
public class CommonUtilsApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void contextLoads() throws Exception {
    }

    @Test
    public void testExcl() throws Exception {
        String fileName = "/template/test-import.xlsx";
        InputStream resourceAsStream;
         resourceAsStream = this.getClass().getResourceAsStream(fileName);
         resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
         //resourceAsStream = Thread.currentThread().getClass().getClassLoader().getResourceAsStream(fileName);
        if (null == resourceAsStream) {
            logger.error("读取文件失败,path[{}]", fileName);
            //return;
        }
        fileName = "/template/test-import.xls";
        resourceAsStream = this.getClass().getResourceAsStream(fileName);
        resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        if (null == resourceAsStream) {
            logger.error("读取文件失败,path[{}]", fileName);
            return;
        }
        XSSFWorkbook wb = new XSSFWorkbook(resourceAsStream);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        row = sheet.getRow(1);
    }

}
