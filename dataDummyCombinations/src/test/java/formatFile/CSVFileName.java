package formatFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVFileName {

    public void parseData(String nama_file, String nomor_aplikasi, String kode_produk, String tanggal) {

        try {
            if (nama_file.contains("APPFILE")) {
                File file = new File(".//resultDataDummyFile//APPFILE.csv");
                if (file.renameTo(new File(".//resultDataDummyFile//APPFILE_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + ".csv")))

                    try {
                        String fileExcel = null;
                        File folder = new File(".//resultDataDummyFile");
                        File[] listOfFiles = folder.listFiles();

                        for (int i = 0; i < listOfFiles.length; i++) {
                            if (listOfFiles[i].isFile()) {

                                if (listOfFiles[i].getName().contains("APPFILE")) {
                                    fileExcel = listOfFiles[i].getName();
                                }

                            } else if (listOfFiles[i].isDirectory()) {
                                System.out.println("Directory " + listOfFiles[i].getName());
                            }
                        }

                        String csvFileAddress = ".//resultDataDummyFile//" +fileExcel; //csv file address
                        String xlsxFileAddress = ".//fileValidation//" +fileExcel; //xlsx file address

                        XSSFWorkbook workBook = new XSSFWorkbook();
                        XSSFSheet sheet = workBook.createSheet("Approval");
                        String currentLine;
                        int RowNum = 0;
                        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
                        while ((currentLine = br.readLine()) != null) {
                            String str1[] = currentLine.split("\\|");

                            XSSFRow currentRow = sheet.createRow(RowNum);
                            RowNum++;
                            for (int i = 0; i < str1.length; i++) {
                                currentRow.createCell(i).setCellValue(str1[i]);
                            }
                        }

                        FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress.replace(".csv",".xlsx"));
                        workBook.write(fileOutputStream);
                        fileOutputStream.close();

                        //System.out.println("Done");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage() + "Exception in try");
                    }

                System.out.println("Success");


            } else if (nama_file.contains("REAFILE")) {
                File file = new File(".//resultDataDummyFile//REAFILE.csv");
                if (file.renameTo(new File(".//resultDataDummyFile//REAFILE" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + ".csv")))

                    try {

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

                        String csvFileAddress = ".//resultDataDummyFile//" +fileExcel; //csv file address
                        String xlsxFileAddress = ".//fileValidation//" +fileExcel; //xlsx file address

                        XSSFWorkbook workBook = new XSSFWorkbook();
                        XSSFSheet sheet = workBook.createSheet("Realisasi");
                        String currentLine;
                        int RowNum = 0;
                        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
                        while ((currentLine = br.readLine()) != null) {
                            String str1[] = currentLine.split("\\|");

                            XSSFRow currentRow = sheet.createRow(RowNum);
                            RowNum++;
                            for (int i = 0; i < str1.length; i++) {
                                currentRow.createCell(i).setCellValue(str1[i]);
                            }
                        }

                        FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress.replace(".csv",".xlsx"));
                        workBook.write(fileOutputStream);
                        fileOutputStream.close();
                        br.close();

                        //System.out.println("Done");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage() + "Exception in try");
                    }

                System.out.println("success");


            } else if (nama_file.contains("PENGURUS")) {
                File file = new File(".//resultDataDummyFile//PENGURUS.csv");
                if (file.renameTo(new File(".//resultDataDummyFile//PENGURUS" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + ".csv")))

                    try {

                        String fileExcel = null;
                        File folder = new File(".//fileValidation");
                        File[] listOfFiles = folder.listFiles();

                        for (int i = 0; i < listOfFiles.length; i++) {
                            if (listOfFiles[i].isFile()) {

                                if (listOfFiles[i].getName().contains("PENGURUS")) {
                                    fileExcel = listOfFiles[i].getName();
                                    //System.out.println(fileExcel);
                                }

                            } else if (listOfFiles[i].isDirectory()) {
                                System.out.println("Directory " + listOfFiles[i].getName());
                            }
                        }

                        String csvFileAddress = ".//resultDataDummyFile//" +fileExcel; //csv file address
                        String xlsxFileAddress = ".//fileValidation//" +fileExcel; //xlsx file address

                        XSSFWorkbook workBook = new XSSFWorkbook();
                        XSSFSheet sheet = workBook.createSheet("Pengurus");
                        String currentLine;
                        int RowNum = 0;
                        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
                        while ((currentLine = br.readLine()) != null) {
                            String str1[] = currentLine.split("\\|");

                            XSSFRow currentRow = sheet.createRow(RowNum);
                            RowNum++;
                            for (int i = 0; i < str1.length; i++) {
                                currentRow.createCell(i).setCellValue(str1[i]);
                            }
                        }

                        FileOutputStream fileOutputStream = new FileOutputStream(xlsxFileAddress.replace(".csv",".xlsx"));
                        workBook.write(fileOutputStream);
                        fileOutputStream.close();
                        br.close();

                        //System.out.println("Done");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage() + "Exception in try");
                    }
                System.out.println("success");
            }

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }

}



