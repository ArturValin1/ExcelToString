import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WordProbe {
    public void writeToFile(Map<String, Map<String, List<String>>> map) {
        XWPFDocument document = new XWPFDocument();
        MakeStringFromList mstr = new MakeStringFromList();
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText("Отключения на 2022 create automation");
        titleRun.setColor("000000");
        titleRun.setBold(true);
        titleRun.setFontFamily("Times New Roman");
        titleRun.setFontSize(12);
        for (String s : map.keySet()) {
            XWPFParagraph subTitle = document.createParagraph();
            subTitle.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun subTitleRun = subTitle.createRun();
            subTitleRun.setText(s);
            subTitleRun.setColor("000000");
            subTitleRun.setFontFamily("Times New Roman");
            subTitleRun.setFontSize(12);
            subTitleRun.addBreak();
            for (String a : map.get(s).keySet()) {
                XWPFParagraph subTitle1 = document.createParagraph();
                subTitle1.setAlignment(ParagraphAlignment.LEFT);
                XWPFRun subTitleRun1 = subTitle.createRun();
                subTitleRun1.setText("улица ");
                subTitleRun1.setText(a);
                subTitleRun1.setColor("000000");
                subTitleRun1.setFontFamily("Times New Roman");
                subTitleRun1.setFontSize(12);
                subTitleRun1.setText(" ");
                subTitleRun1.setText(mstr.resultString(map.get(s).get(a)));
                subTitleRun1.addBreak();
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(new File("D:\\Java\\004.docx"));
            try {
                document.write(out);
            } catch (IOException e) {
                System.out.println("Закройте открытый документ ворд.");
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("---=== Закройте открытый документ ворд. ===---");
        }
    }
}