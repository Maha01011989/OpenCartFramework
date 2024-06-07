package com.qa.opencart.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static final String TEST_DATA_SHEET_PATH = "./src/test/resources/testdata/testdata.xlsx";

    private static Workbook wb;
    private static Sheet sheet;

    public static Object[][] getTestData(String sheetName) throws IOException, InvalidFormatException {
        Object[][] data = null;
        FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
        wb = WorkbookFactory.create(fis);
        sheet = wb.getSheet(sheetName);

        data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

}
