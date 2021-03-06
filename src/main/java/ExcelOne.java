import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class ExcelOne {
    public static void main(String[] args) throws IOException {
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
        SomeTest someTest = new SomeTest();
        List<Address> adl = new ArrayList<>();
        Address address;
        List<Abonent> abonents = list.stream().filter(e -> (e.getTp().equals("10"))).toList();  //выборка
        for (Abonent a : abonents) {
            address = addressFromAbonent(a);
            if (address != null) {
                adl.add(address);
            }
        }
        WordProbe wordProbe = new WordProbe();
        wordProbe.writeToFile(someTest.createOffHomeFromAddress(adl));
        workbook.close();
        file.close();
    }

    public static Address addressFromAbonent(Abonent abonent) {
        String[] splitAddres;
        String stringAddress = abonent.getAddress();
        splitAddres = stringAddress.split(", ");
        Address address = null;
        if (abonent.getTypeAbonent().contains("Население") && !stringAddress.contains("араж") && !stringAddress.contains("освещение") && !abonent.getPointDelivery().contains("араж") && !abonent.getPointDelivery().contains("ветофор")) {
            if (splitAddres.length == 2)
                address = new Address(splitAddres[0], "", splitAddres[1].replace(" ", "").split("д.")[1]);
            else
                address = new Address(splitAddres[0], "", splitAddres[1].replace(" ", ""));

            if (splitAddres.length == 3) {
                address = new Address(splitAddres[0], splitAddres[1].replace("ул ", ""), splitAddres[2].replace("д. ", ""));
            }
            if (splitAddres.length == 4) {
                address = new Address(splitAddres[0], splitAddres[1].replace("ул ", ""), splitAddres[2].replace("д. ", "") + " " + splitAddres[3]);
            }
        }
        if (abonent.getTypeAbonent().equals("Юридические лица") && !abonent.getPointDelivery().contains("араж") && !abonent.getPointDelivery().contains("освещение")) {
            address = new Address(splitAddres[0], "", abonent.getPointDelivery());
        }
        return address;
    }
}