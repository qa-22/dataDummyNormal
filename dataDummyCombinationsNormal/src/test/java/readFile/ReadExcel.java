package readFile;

import writeFile.ValidationResult;

import java.io.File;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
    // AppFile Case
    String[] collectDataApp;
    public void caseReadExcelApp() {

        int idxNomorAplikasi = 0;
        int idxStatus = 2;
        int iCollect = 1;
        try {
            ZipSecureFile.setMinInflateRatio(0);
            //get file name
            String fileExcel = null;
            File folder = new File(".//fileValidation");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains("APPFILE")) {
                        fileExcel = listOfFiles[i].getName();
                        //System.out.println(fileExcel);
                    }

                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }

            XSSFWorkbook workbook = new XSSFWorkbook(".//fileValidation//"+fileExcel);
            XSSFSheet sheet = workbook.getSheet("Approval");

            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) {
                String cellData = sheet.getRow(i).getCell(1).getStringCellValue();

                // Call Class Read text file
                ReadAppTXT toTXT = new ReadAppTXT();
                toTXT.textFile(idxNomorAplikasi, idxStatus, cellData);
                this.collectDataApp = toTXT.value2;

                idxNomorAplikasi = idxNomorAplikasi + 3;
                idxStatus = idxStatus + 3;

                //call class
                ValidationResult inDataExcel = new ValidationResult();
                inDataExcel.excelResultApp(iCollect, this.collectDataApp[0], this.collectDataApp[1]);

                iCollect = iCollect + 1;

            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    // ReaFile Case
    String[] collectDataRea;

    public void caseReadExcelRea() {

        int idxNomorAplikasi = 0;
        int idxStatus = 2;
        int iCollect = 1;
        try {
            ZipSecureFile.setMinInflateRatio(0);
            //get file name
            String fileExcel = null;
            File folder = new File(".//fileValidation");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains("REAFILE")) {
                        fileExcel = listOfFiles[i].getName();
                        //System.out.println(fileExcel);
                    }

                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
            XSSFWorkbook workbook = new XSSFWorkbook(".//fileValidation//"+fileExcel);
            XSSFSheet sheet = workbook.getSheet("Realisasi");

            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) {
                String cellData = sheet.getRow(i).getCell(1).getStringCellValue();

                // Call Class Read text file
                ReadReaTXT toTXT = new ReadReaTXT();
                toTXT.textFile(idxNomorAplikasi, idxStatus, cellData);
                this.collectDataRea = toTXT.value2;

                idxNomorAplikasi = idxNomorAplikasi + 3;
                idxStatus = idxStatus + 3;

                //call class
                ValidationResult inDataExcel = new ValidationResult();
                inDataExcel.excelResultRea(iCollect, this.collectDataRea[0], this.collectDataRea[1]);

                iCollect = iCollect + 1;
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}