package lr8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class Example8 {

    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream("src/lr8/example.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Товары");
            System.out.println("Лист: " + sheet.getSheetName());
            System.out.println();

            for (Row row : sheet) {
                StringBuilder sb = new StringBuilder();
                for (Cell cell : row) {
                    if (!sb.isEmpty()) sb.append(" | ");
                    sb.append(getCellValue(cell));
                }
                System.out.println(sb);
            }
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return cell.toString();
    }
}
