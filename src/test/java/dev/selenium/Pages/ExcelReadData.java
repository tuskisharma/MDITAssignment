package dev.selenium.Pages;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReadData {
    public void ExcelReadData() throws IOException {
            String excelFilePath = "savedexcel/excelsheet.xlsx";
        XSSFWorkbook workbook;
        try (FileInputStream fis = new FileInputStream(excelFilePath)) {
            workbook = new XSSFWorkbook(fis);
        }
        XSSFSheet sheet = workbook.getSheetAt(0);

            System.out.println(sheet.getLastRowNum());
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(1).getLastCellNum();
            for (int r = 0; r < rowNum; r++) {
                XSSFRow row = sheet.getRow(r);
                for (int c = 0; c < colNum; c++) {
                    XSSFCell cell = row.getCell(c);
                    switch (cell.getCellType()) {
                        case STRING -> {
                            System.out.print(cell.getStringCellValue());
                        }
                        case NUMERIC -> {
                            System.out.print(cell.getNumericCellValue());
                        }

                    }
                    System.out.print(" | ");
                }
                System.out.println();
            }
    }

    public static void main(String[] args) throws IOException {
        ExcelReadData ed=new ExcelReadData();
        ed.ExcelReadData();
    }
}

