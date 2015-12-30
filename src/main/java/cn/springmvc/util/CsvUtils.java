package cn.springmvc.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvUtils {

    public static void printStrList(String fileName, List<String[]> strList) {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        PrintWriter printWriter = null;
        CSVPrinter csvPrinter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(fileName),
                            "GBK")));
            csvPrinter = new CSVPrinter(printWriter, csvFormat);
            for (String[] strs : strList) {
                csvPrinter.printRecord((Object[]) strs);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (csvPrinter != null) {
                    csvPrinter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        }

    }

    public static void printStrArray(String fileName, String[][] values) {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        PrintWriter printWriter = null;
        CSVPrinter csvPrinter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(fileName),
                            "GBK")));
            csvPrinter = new CSVPrinter(printWriter, csvFormat);
            for (int i = 0; i < values.length; i++) {
                csvPrinter.printRecord((Object[]) values[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (csvPrinter != null) {
                    csvPrinter.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        }
    }
}
