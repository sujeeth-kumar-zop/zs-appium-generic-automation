package com.zs.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file and select sheet
    public static void loadExcel(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Fetch credentials based on appName
    public static String[] getCredentialsForApp(String appName) {

        loadExcel("src/main/resources/login_details.xlsx");
        DataFormatter dataFormatter = new DataFormatter();

        // Iterate through each row to fetch credentials for the given app
        for (Row row : sheet) {
            String appNameInExcel = dataFormatter.formatCellValue(row.getCell(0)); // First column should be appName
            String username = dataFormatter.formatCellValue(row.getCell(1)); // Second column should be username
            String password = dataFormatter.formatCellValue(row.getCell(2)); // Third column should be password

            if (appNameInExcel.equals(appName)) {
                return new String[]{username, password};
            }
        }
        return null;
    }
}
