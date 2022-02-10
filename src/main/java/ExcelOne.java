import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class ExcelOne {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        long start = System.currentTimeMillis();
        MakeStringFromList mks = new MakeStringFromList();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("1a");
        list1.add("3");
        list1.add("5");
        list1.add("5b");



        list1.forEach(e -> {
            System.out.println(String.format("%s is number %s", e, mks.isNumber(e)));
        });

        list1.stream().filter(e-> !mks.isNumber(e)).toList().forEach(System.out::println);


        String fileStr = "D:\\Java\\001.xlsx";
        FileInputStream file = new FileInputStream(new File(fileStr));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<Abonent> list = new ArrayList<>();
        Iterator<Row> rows = sheet.iterator();
        Iterator<Cell> cells;
        rows.next();
        while (rows.hasNext()) {
            cells = rows.next().iterator();
            Integer nomer = (int) Float.parseFloat(cells.next().toString());
            String station = cells.next().toString();
            String fider10 = cells.next().toString();
            String tp = cells.next().toString();
            String fider04 = cells.next().toString();
            String pointDelivery = cells.next().toString();
            String dogovor = cells.next().toString();
            String typeAbonent = cells.next().toString();
            String address = cells.next().toString();
            String district = cells.next().toString();
            String numberCount = cells.next().toString();
            Abonent abonent = new Abonent(nomer, station, fider10, tp, fider04, pointDelivery, dogovor, typeAbonent, address, district, numberCount);
            list.add(abonent);
        }
        System.out.println(list.size());
        System.out.println(list.get(2).getAddress());
        String str = list.get(2).getAddress();
        String[] ss = str.split(", ");

//        Address address = new Address(ss[0], ss[1], Integer.parseInt(ss[2].split(". ")[1]));
//        System.out.println(address);


//        String numDog, typePeople;
//        rows.next();
//        rows.next();
//        cells = rows.next().iterator();
//        for (int k = 0; k < 8; k++) {
//            cells.next();
//        }
//        numDog = cells.next().toString();
//        typePeople = cells.next().toString();
//        if (typePeople.equals("Население")) {
//            System.out.println(numDog.substring(0, 10));
//            System.out.println(numDog.substring(11));
//            System.out.println(typePeople);
//        }

//        System.out.println(String.format("rows = %s,  cells = %s", i, j));
        workbook.close();
        file.close();
//        long end = System.currentTimeMillis();
//        System.out.println(String.format("start = %s, end = %s, e-s = %s, time work = %s", start, end, end - start, (end - start) / 1000));
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
