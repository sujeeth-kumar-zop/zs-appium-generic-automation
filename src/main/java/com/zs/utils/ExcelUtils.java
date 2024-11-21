package com.zs.utils;

import com.zs.constants.Constants;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Utility class for handling Excel file operations.
 */
public class ExcelUtils {


    private static Workbook workbook;
    private static Sheet sheet;

    /**
     * Loads an Excel file and selects the first sheet.
     *
     * @param filePath the path to the Excel file
     */
    public static void loadExcel(String filePath) {
        try {
            FileInputStream file = new FileInputStream(new File(filePath));
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Retrieves credentials (username and password) for a given app from the Excel file.
     *
     * @param appName the name of the application for which credentials are needed
     * @return an array containing the username and password, or null if not found
     */
    public static String[] getCredentialsForApp(String appName) {

        loadExcel(Constants.LOGIN_DETAILS_PATH);
        DataFormatter dataFormatter = new DataFormatter();

        // Iterate through each row to find the matching appName
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
