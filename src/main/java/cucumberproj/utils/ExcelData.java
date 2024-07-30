package cucumberproj.utils;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelData {

    public static File file;
    public static FileInputStream work_file;
    public static XSSFWorkbook workbook;
    public static XSSFSheet worksheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static FileOutputStream result_file;


    public static String readExcel(String filepath, int rowNum, int colNum) {

        String data = null;
        try {
            file = new File(filepath);
            work_file = new FileInputStream(file);
            workbook = new XSSFWorkbook(work_file);
            worksheet = workbook.getSheet("FieldsData");
            row = worksheet.getRow(rowNum);

            cell = row.getCell(colNum);
            data = cell.getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
