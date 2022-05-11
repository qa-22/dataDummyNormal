package formatFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVFileName {

    public void parseData(String case1, String case2, String case3, String nomor_aplikasi, String kode_produk, String tanggal) {

        try {
            File fileApp = new File(".//resultDataDummyFile//APPFILE.csv");
            File fileRea = new File(".//resultDataDummyFile//REAFILE.csv");

            fileApp.renameTo(new File(".//resultDataDummyFile//APPFILE_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + ".csv"));
            fileRea.renameTo(new File(".//resultDataDummyFile//REAFILE_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + ".csv"));

            try {
                String fileExcel = null;
                File folder = new File(".//resultDataDummyFile");
                File[] listOfFiles = folder.listFiles();

                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {

                        if (listOfFiles[i].getName().contains("APPFILE")) {
                            fileExcel = listOfFiles[i].getName();

                            String csvFileAddress = ".//resultDataDummyFile//" + fileExcel; //csv file address
                            String xlsxFileAddress = ".//fileValidation//" + fileExcel; //xlsx file address

                            XSSFWorkbook workBook = new XSSFWorkbook();
                            XSSFSheet sheet = workBook.createSheet("Approval");
                            String currentLine;
                            int RowNum = 0;
                            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
                            while ((currentLine = br.readLine()) != null) {
                                String str1[] = currentLine.split("\\|");

                                XSSFRow currentRow = sheet.createRow(RowNum);
                                RowNum++;
                                for (int ix = 0; ix < str1.length; ix++) {
                                    currentRow.createCell(ix).setCellValue(str1[ix]);
                                }
                            }

                            FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress.replace(".csv", ".xlsx"));
                            workBook.write(fileOutputStream);
                            fileOutputStream.close();
                        } else if (listOfFiles[i].getName().contains("REAFILE")) {
                            fileExcel = listOfFiles[i].getName();

                            String csvFileAddress = ".//resultDataDummyFile//" + fileExcel; //csv file address
                            String xlsxFileAddress = ".//fileValidation//" + fileExcel; //xlsx file address

                            XSSFWorkbook workBook = new XSSFWorkbook();
                            XSSFSheet sheet = workBook.createSheet("Realisasi");
                            String currentLine;
                            int RowNum = 0;
                            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
                            while ((currentLine = br.readLine()) != null) {
                                String str1[] = currentLine.split("\\|");

                                XSSFRow currentRow = sheet.createRow(RowNum);
                                RowNum++;
                                for (int ix = 0; ix < str1.length; ix++) {
                                    currentRow.createCell(ix).setCellValue(str1[ix]);
                                }
                            }

                            FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress.replace(".csv", ".xlsx"));
                            workBook.write(fileOutputStream);
                            fileOutputStream.close();
                        }

                    } else if (listOfFiles[i].isDirectory()) {
                        System.out.println("Directory " + listOfFiles[i].getName());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + "Exception in try");
            }
            System.out.println("Success");

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }

    public void parseDataPengurus(String case3, String nomor_aplikasi, String kode_produk,String na, String tanggal) {

        try {
//            new File(".//resultDataDummyFile//PENGURUS.csv").renameTo(new File(".//resultDataDummyFile//PENGURUS_" + nomor_aplikasi + "_" + kode_produk + "_" +na+"_"+ tanggal + ".csv"));
//            fileApp.deleteOnExit();
            try {
                String fileExcel = null;
                File folder = new File(".//resultDataDummyFile");
                File[] listOfFiles = folder.listFiles();

                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {

                        if (listOfFiles[i].getName().contains("PENGURUS_" + nomor_aplikasi + "_" + kode_produk + "_" +na+"_"+ tanggal + ".csv")) {
                            fileExcel = listOfFiles[i].getName();

                            String csvFileAddress = ".//resultDataDummyFile//" + fileExcel; //csv file address
                            String xlsxFileAddress = ".//fileValidation//" + fileExcel; //xlsx file address

                            XSSFWorkbook workBook = new XSSFWorkbook();
                            XSSFSheet sheet = workBook.createSheet("Pengurus");
                            String currentLine;
                            int RowNum = 0;
                            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
                            while ((currentLine = br.readLine()) != null) {
                                String str1[] = currentLine.split("\\|");

                                XSSFRow currentRow = sheet.createRow(RowNum);
                                RowNum++;
                                for (int ix = 0; ix < str1.length; ix++) {
                                    currentRow.createCell(ix).setCellValue(str1[ix]);
                                }
                            }

                            FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress.replace(".csv", ".xlsx"));
                            workBook.write(fileOutputStream);
                            fileOutputStream.close();
                        }

                    } else if (listOfFiles[i].isDirectory()) {
                        System.out.println("Directory " + listOfFiles[i].getName());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage() + "Exception in try");
            }
            System.out.println("Success");

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }
}



