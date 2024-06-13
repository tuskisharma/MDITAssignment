package dev.selenium.Pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DataProviderWithExcel {

    public static void main(String[] args) throws IOException {


        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet
                = workbook.createSheet(" Invalid crdentials ");

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> MDITCredentials
                = new TreeMap<String, Object[]>();

        MDITCredentials.put(
                "1",
                new Object[]{ "username", "password"});

        MDITCredentials.put("2", new Object[]{ "12345",
                "qweert"});

        MDITCredentials.put(
                "3",
                new Object[]{ "12536", "23456"});
        MDITCredentials.put(
                "4",
                new Object[]{ "5678", "23456"});


        Set<String> keyid = MDITCredentials.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = MDITCredentials.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String) obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File("savedexcel/excelsheet.xlsx"));

        workbook.write(out);
        out.close();
    }
}