package TestData;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {
    public String[] cellDataValue;


    public String[] testDataApp() {
        System.out.println("reading test data");
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(".//testData.xlsx");
            XSSFSheet sheet = workbook.getSheet("Approval");
//          int colCount = sheet.getRow(0).getLastCellNum();
//          int rowCount = sheet.getPhysicalNumberOfRows();

            String nama_file = sheet.getRow(1).getCell(0).getStringCellValue();
            String nomor_aplikasi = sheet.getRow(1).getCell(1).getStringCellValue();
            String kode_produk = sheet.getRow(1).getCell(2).getStringCellValue();
            String tanggal = sheet.getRow(1).getCell(3).getStringCellValue();
            cellDataValue = new String[]{nama_file, nomor_aplikasi, kode_produk, tanggal};

            workbook.close();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellDataValue;
    }

    public String[] testDataRea() {
        System.out.println("reading test data");
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(".//testData.xlsx");
            XSSFSheet sheet = workbook.getSheet("Realisasi");
//          int colCount = sheet.getRow(0).getLastCellNum();
//          int rowCount = sheet.getPhysicalNumberOfRows();

            String nama_file = sheet.getRow(1).getCell(0).getStringCellValue();
            String nomor_aplikasi = sheet.getRow(1).getCell(1).getStringCellValue();
            String kode_produk = sheet.getRow(1).getCell(2).getStringCellValue();
            String tanggal = sheet.getRow(1).getCell(3).getStringCellValue();
            cellDataValue = new String[]{nama_file, nomor_aplikasi, kode_produk, tanggal};

            workbook.close();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellDataValue;
    }
}
