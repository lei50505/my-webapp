package cn.springmvc.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsUtils {
    public static void main(String[] args) throws Exception {
        List<String[]> strList = new ArrayList<String[]>();
        String filePath = "/Users/admin/Desktop/file/aa.xls";
        String[] s1={"wqe","eqw","ewq"};
        String[] s2={"das"};
        String[] s3={"张三","sda"};
        strList.add(s1);
        strList.add(s2);
        strList.add(s3);
        writeList(filePath, strList);
    }
    public static void writeArray(String filePath, String[][] strArray)
            throws Exception {
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
            throw new Exception("文件创建失败", e1);
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
            throw new Exception("文件创建失败", e1);
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
