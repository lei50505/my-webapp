package cn.springmvc.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsUtils {

    private static void createFile(String filePath) throws IOException {
        String folderPath = filePath.substring(0,
                filePath.lastIndexOf(File.separatorChar));
        File folder = new File(folderPath);
        folder.mkdirs();
        File file = new File(filePath);
        file.createNewFile();
    }

    public static void writeArray(String filePath, String[][] strArray)
            throws Exception {
        if (strArray == null || strArray.length == 0) {
            return;
        }
        try {
            createFile(filePath);
        } catch (IOException e2) {
            throw new Exception("创建文件失败", e2);
        }
        Workbook workbook = null;
        if (filePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (filePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            return;
        }
        Sheet sheet = workbook.createSheet("data");

        int index = 0;
        for (String[] strs : strArray) {
            Row row = sheet.createRow(index++);
            for (int i = 0; i < strs.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(strs[i]);
            }
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e1) {
            throw new Exception("创建文件输出流失败", e1);
        } catch (IOException e) {
            throw new Exception("写入数据失败", e);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {

            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {

                }
            }
        }
    }

    public static void writeList(String filePath, List<String[]> strList)
            throws Exception {
        if (strList == null || strList.size() == 0) {
            return;
        }
        try {
            createFile(filePath);
        } catch (IOException e2) {
            throw new Exception("创建文件失败", e2);
        }
        Workbook workbook = null;
        if (filePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook();
        } else if (filePath.endsWith("xls")) {
            workbook = new HSSFWorkbook();
        } else {
            return;
        }
        Sheet sheet = workbook.createSheet("data");

        int index = 0;
        for (String[] strs : strList) {
            Row row = sheet.createRow(index++);
            for (int i = 0; i < strs.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(strs[i]);
            }
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
        } catch (FileNotFoundException e1) {
            throw new Exception("创建文件输出流失败", e1);
        } catch (IOException e) {
            throw new Exception("写入数据失败", e);
        } finally {
            try {
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {

            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {

                }
            }
        }
    }
}
