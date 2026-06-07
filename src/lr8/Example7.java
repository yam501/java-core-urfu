package lr8;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

public class Example7 {

    public static void main(String[] args) throws Exception {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Товары");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Название");
            header.createCell(1).setCellValue("Характеристики");
            header.createCell(2).setCellValue("Стоимость");

            Row row1 = sheet.createRow(1);
            row1.createCell(0).setCellValue("Книга");
            row1.createCell(1).setCellValue("Java Programming, 5th Edition");
            row1.createCell(2).setCellValue(1500.0);

            Row row2 = sheet.createRow(2);
            row2.createCell(0).setCellValue("Компьютер");
            row2.createCell(1).setCellValue("Intel Core i7, 16GB RAM, 512GB SSD");
            row2.createCell(2).setCellValue(75000.0);

            Row row3 = sheet.createRow(3);
            row3.createCell(0).setCellValue("Монитор");
            row3.createCell(1).setCellValue("27 дюймов, 4K, IPS");
            row3.createCell(2).setCellValue(35000.0);

            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream out = new FileOutputStream("src/lr8/example.xlsx")) {
                workbook.write(out);
            }

            System.out.println("Excel файл создан: src/lr8/example.xlsx");
        }
    }
}
