package cn.springmvc.util;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvUtils {
    public static void write() throws IOException{
        CSVFormat csvFormat = CSVFormat.EXCEL;
        String fileName ="/Users/admin/Desktop/file/a.csv";
        FileWriter fileWriter = new FileWriter(fileName);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, csvFormat);
        
        Object[] header = {"姓名","年龄"};
        Object[] body = {"张三","20"};
        csvPrinter.printRecord(header);
        csvPrinter.printRecord(body);
        
        fileWriter.flush();
        fileWriter.close();
        csvPrinter.close();
    }
    
    public static void main(String[] args) throws IOException {
        write();
    }
}
