import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ExcelOne {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File("D:\\Java_project\\001.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getSheetName());
        Iterator<Row> rows = sheet.iterator();
        Iterator<Cell> cells;
        List<String> list = new ArrayList<>();
        int i=0;
        while(i++<10){
            cells=rows.next().iterator();
            int j=0;
            while(cells.hasNext()){
                j++;
                if(j==13){
                    list.add( cells.next().toString());
                    break;
                } else{
                    cells.next();
                }
            }
        }
        list.forEach(System.out::println);
        List<String[]> list1 = new ArrayList<>();
        list1.add(list.get(1).split(","));
        list1.add(list.get(5).split(","));
        list1.forEach(x->{
            Arrays.stream(x).forEach(System.out::print);
        });
    }
}
