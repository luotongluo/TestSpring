package com.lt.commonutils.utils.file;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tong.luo
 * @description ExclUtils
 * @date 2021/5/26 16:37
 */
public class ExclUtils {
    private Workbook workbook;
    List<String[]> dataList = new ArrayList<>(100);

    /**
     * 取Excel所有数据，包含header
     *
     * @return List<String[]>
     */
    public List<String[]> getAllData(int sheetIndex) {
        if (!dataList.isEmpty()) {
            return dataList;
        }
        int columnNum = 0;
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        if (sheet.getRow(0) != null) {
            columnNum = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
        }
        if (columnNum > 0) {
            for (Row row : sheet) {
                String[] singleRow = new String[columnNum];
                for (int i = 0; i < columnNum; i++) {
                    Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BLANK:
                            singleRow[i] = "";
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            singleRow[i] = Boolean.toString(cell.getBooleanCellValue());
                            break;
                        // 数值
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                singleRow[i] = String.valueOf(cell.getDateCellValue());
                            } else {
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String temp = cell.getStringCellValue();
                                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                singleRow[i] = new BigDecimal(temp).toPlainString();
                                    /*if (temp.contains(".")) {
                                        singleRow[i] = String.valueOf(new Double(temp)).trim();
                                    } else {
                                        singleRow[i] = temp.trim();
                                    }*/
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:
                            singleRow[i] = cell.getStringCellValue().trim();
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            singleRow[i] = "";
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            singleRow[i] = cell.getStringCellValue();
                            if (singleRow[i] != null) {
                                singleRow[i] = singleRow[i].replaceAll("#N/A", "").trim();
                            }
                            break;
                        default:
                            singleRow[i] = "";
                            break;
                    }
                }
                dataList.add(singleRow);
            }
        }
        return dataList;
    }

    /**
     *
     * @param cellNum 行数
     * @param row 需要处理的行
     * @return
     */
    public String[] getRowData(Integer cellNum, Row row){
        String[] retRowData = null;
        if(row != null && cellNum > 0){
            for (int i = 0; i < cellNum; i++) {
                Cell cell = row.getCell(i,Row.CREATE_NULL_AS_BLANK);
                switch (cell.getCellType()){
                    case Cell.CELL_TYPE_NUMERIC:
                        if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                            retRowData[i] = String.valueOf(cell.getDateCellValue());
                        } else {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            String temp = cell.getStringCellValue();
                            // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                            retRowData[i]  = new BigDecimal(temp).toPlainString();
                        }
                        break;
                    case Cell.CELL_TYPE_STRING:
                        retRowData[i]  = cell.getStringCellValue();
                        break;
                    default:
                        retRowData[i]  = cell.getStringCellValue();
                        break;
                }
            }
        }
        return  retRowData;
    }

    public static void main(String[] args) throws Exception{
        String fileName = "templates/test-import.xls";
        //InputStream resourceAsStream = this.getClass().getResourceAsStream(fileName);
        InputStream resourceAsStream = Thread.currentThread().getClass().getClassLoader().getResourceAsStream(fileName);
        XSSFWorkbook wb = new XSSFWorkbook(resourceAsStream);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row = sheet.getRow(0);
        XSSFCell cell = row.getCell(0);
        row = sheet.getRow(1);
        row = sheet.getRow(2);
        row = sheet.getRow(3);
    }
}
