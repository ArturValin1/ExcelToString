import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelOne {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        long start = System.currentTimeMillis();
        FileInputStream file = new FileInputStream(new File("D:\\Java\\001.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getSheetName());
        Iterator<Row> rows = sheet.iterator();
        Iterator<Cell> cells;
        List<String> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (rows.hasNext()) {
            i++;
            cells = rows.next().iterator();
            while (cells.hasNext()) {
                j++;
                cells.next();
            }
        }
        System.out.println(String.format("rows = %s,  cells = %s", i, j));
//        while (i++ < 13) {
//            cells = rows.next().iterator();
//            int j = 0;
//            while (cells.hasNext()) {
//                if (j++ == 14) {
//                    list.add(cells.next().toString());
//                } else
//                    cells.next();
//            }
//            System.out.println();
//        }

//        String fileToWrite = "D:\\Java\\002.xlsx";
//        writeToExcel(fileToWrite);
//
//        list.forEach(System.out::println);
//        List<String[]> list1 = new ArrayList<>();
//        list1.add(list.get(1).split(","));
//        list1.add(list.get(5).split(","));
//        list1.forEach(x -> {
//            Arrays.stream(x).forEach(System.out::print);
//        });

        workbook.close();
        file.close();
        long end = System.currentTimeMillis();
        System.out.println(String.format("start = %s, end = %s, e-s = %s, time work = %s", start, end, end - start, (end - start) / 1000));
    }

    public static void writeToExcel(String fileString) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(new File(fileString));
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Age");
        headerCell.setCellStyle(headerStyle);
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(2);
        Cell cell = row.createCell(0);
        cell.setCellValue("John Smith");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(20);
        cell.setCellStyle(style);
        workbook.write(outputStream);
        try {
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
