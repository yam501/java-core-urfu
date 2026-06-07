package lr8;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Задание 2.5: доработка Excel парсера.
 * Улучшенная обработка ошибок с подробными сообщениями.
 */
public class Task4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите путь к Excel файлу (.xlsx): ");
        String filePath = sc.nextLine().trim();
        sc.close();

        readExcel(filePath);
    }

    private static void readExcel(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("Ошибка: файл не найден — " + filePath);
            System.err.println("Убедитесь, что путь указан правильно.");
            return;
        }

        if (!file.getName().endsWith(".xlsx") && !file.getName().endsWith(".xls")) {
            System.err.println("Ошибка: неподдерживаемый формат файла.");
            System.err.println("Поддерживаются форматы: .xlsx, .xls");
            return;
        }

        if (!file.canRead()) {
            System.err.println("Ошибка: нет прав на чтение файла — " + filePath);
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            int sheetCount = workbook.getNumberOfSheets();
            System.out.println("Листов в файле: " + sheetCount);

            for (int s = 0; s < sheetCount; s++) {
                Sheet sheet = workbook.getSheetAt(s);
                if (sheet == null) {
                    System.out.println("Лист " + s + ": пустой, пропускаем.");
                    continue;
                }

                System.out.println("\n--- Лист: " + sheet.getSheetName() + " ---");

                int rowCount = sheet.getPhysicalNumberOfRows();
                if (rowCount == 0) {
                    System.out.println("Лист пустой.");
                    continue;
                }

                for (Row row : sheet) {
                    StringBuilder sb = new StringBuilder();
                    for (Cell cell : row) {
                        if (!sb.isEmpty()) sb.append(" | ");
                        sb.append(getCellValueSafe(cell));
                    }
                    System.out.println(sb);
                }
            }

        } catch (EncryptedDocumentException e) {
            System.err.println("Ошибка: файл защищён паролем.");
            System.err.println("Откройте файл в Excel и снимите защиту, затем повторите.");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            System.err.println("Возможно файл повреждён или открыт в другой программе.");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage());
            System.err.println("Убедитесь, что файл является корректным Excel документом.");
        }
    }

    private static String getCellValueSafe(Cell cell) {
        if (cell == null) return "";
        try {
            return switch (cell.getCellType()) {
                case STRING -> cell.getStringCellValue();
                case NUMERIC -> {
                    double val = cell.getNumericCellValue();
                    yield val == Math.floor(val) ? String.valueOf((long) val) : String.valueOf(val);
                }
                case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
                case FORMULA -> cell.getCellFormula();
                case BLANK -> "";
                default -> "";
            };
        } catch (Exception e) {
            return "[ошибка чтения ячейки]";
        }
    }
}
