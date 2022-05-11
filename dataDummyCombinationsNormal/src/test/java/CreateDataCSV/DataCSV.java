package CreateDataCSV;


import RandomValue.GenerateRandomDataApp;
import RandomValue.GenerateRandomDataRea;
import TestData.ReadTestData;
import com.opencsv.CSVWriter;
import formatFile.CSVFileName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataCSV {
    ArrayList<String[]> arrayData = new ArrayList<>();
    ArrayList<String[]> dp = new ArrayList<>();
//    ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();

    public void dataDummy(String case1, String case2, String case3) throws InterruptedException {

        String nama_file = null, nomor_aplikasi = null, kode_produk = null, tanggal = null;

        // first create file object for file placed at location
        // specified by filepath
        File fileApp = new File(".//resultDataDummyFile//APPFILE.csv");
        File fileRea = new File(".//resultDataDummyFile//REAFILE.csv");

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfileApp = new FileWriter(fileApp);
            FileWriter outputfileRea = new FileWriter(fileRea);

            // create CSVWriter with '|' as separator
            CSVWriter writerApp = new CSVWriter(outputfileApp, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            CSVWriter writerRea = new CSVWriter(outputfileRea, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
            List<String[]> dataApp = new ArrayList<String[]>();
            dataApp.add(new String[]{"Nomor_Aplikasi", "NIK", "NPWP", "Jenis_Debitur", "Nama_Debitur", "Jangka_Waktu", "Interest_Rate", "Plafon_Kredit"});

            List<String[]> dataRea = new ArrayList<String[]>();
            dataRea.add(new String[]{"Nomor_Aplikasi", "Nama_Debitur", "Jenis_Debitur", "Alamat", "Alamat_Kelurahan", "Alamat_Kecamatan",
                    "Alamat_Kode_Pos", "Alamat_KODE_DATI_II", "No_Telepon", "No_Akte", "Tanggal_Berdiri", "No_Akte_Terakhir",
                    "Tanggal_Akte_Terakhir", "Bidang_Usaha", "Nomor_NPWP", "Jangka_Waktu", "Jenis_Kredit", "Plafon", "Interest_Rate",
                    "Nomor_PK", "Tanggal_Akad", "Tanggal_Angsuran_1", "Jenis_Penggunaan", "Sektor_Ekonomi", "Omzet", "Go_Public",
                    "Sandi_Golongan_Debitur", "Penghasilan_Kotor_Per_Tahun", "Bentuk_Badan_Usaha", "Tempat_berdiri_badan_usaha"});

            List<String[]> dataPengurus = new ArrayList<String[]>();
            dataPengurus.add(new String[]{"Nomor_Aplikasi", "Nomor_Urut_Pengurus", "Jumlah_Pengrus", "Sandi_Jabatan_BI", "Pangsa_Kepemilikan",
                    "Bentuk_Pengurus", "Modal_Dasar", "Modal_Disetor", "Modal_Ditempatkan", "NPWP_Pengurus", "Nama_Pengurus", "Alamat_Pengurus",
                    "Alamat_Kelurahan", "Alamat_Kecamatan", "Alamat_Dati_11", "No_KTP", "No_Akte", "Tanggal_Lahir", "Tanggal_Akte",
                    "Dati_11_Tempat_Lahir", "Jenis_Kelamin"});

            // call class generate random data
            GenerateRandomDataApp generateRandomDataApp = new GenerateRandomDataApp();

            // call class read excel
            ReadTestData readTestData = new ReadTestData();
            readTestData.testDataApp();

            //value array
            //nama_file = String.valueOf(readTestData.cellDataValue[0]);
            nomor_aplikasi = String.valueOf(readTestData.cellDataValue[1]);
            kode_produk = String.valueOf(readTestData.cellDataValue[2]);
            tanggal = String.valueOf(readTestData.cellDataValue[3]);

            // write data csv approval
            for (int idxApp = 1; idxApp < 11; idxApp++) {
                dataApp.add(new String[]{nomor_aplikasi + generateRandomDataApp.nomorAplikasi(), generateRandomDataApp.nik(), generateRandomDataApp.npwp()
                        , generateRandomDataApp.jenisDebitur(), "Winter " + generateRandomDataApp.namaDebitur(), "00" + generateRandomDataApp.jangkaWaktu()
                        , "015" + generateRandomDataApp.interestRate(), "00000" + generateRandomDataApp.plafonKredit() + "000000000"});

            }
            // write data csv realisi
            arrayData = (ArrayList<String[]>) dataApp;
            int ix = 1;
            for (String[] reaData : arrayData) {
                //System.out.println(reaData[ix]);
                if (reaData[0] != "Nomor_Aplikasi" && reaData[1] != "NIK" && reaData[2] != "NPWP" && reaData[3] != "Jenis_Debitur" && reaData[4] != "Nama_Debitur" && reaData[5] != "Jangka_Waktu" && reaData[6] != "Interest_Rate" && reaData[7] != "Plafon_Kredit") {
                    dataRea.add(new String[]{reaData[0], reaData[4], reaData[3], "Jalan Bahyang " + ix, "Kelurahan Bahyang " + ix, "Kecamatan Bahyang " + ix,
                            "100050", "0112", "0813410090050", "11-AKTA PERUSAHAAN-0000000119" + ix, "08281992", "11-AKTA PERUSAHAAN-0000000119" + ix,
                            "08281992", "550000", reaData[2], reaData[5], "P01", reaData[7], reaData[6], "00000000000000090051", "05092022",
                            "05102022", "2", "31400", "00000010000000099", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});
                }
                ix++;
            }
            ix = 1;
            //write data csv pengurus
            for (String[] pengurusData : dataRea) {
                if (pengurusData[0] != "Nomor_Aplikasi") {
                    Thread.sleep(50);
                    File filePengurus = new File(".//resultDataDummyFile//PENGURUS_" + nomor_aplikasi + "_" + kode_produk + "_" + pengurusData[0] + "_" + tanggal + ".csv");
                    FileWriter outputfilePengurus = new FileWriter(filePengurus);

                    CSVWriter writerPengurus = new CSVWriter(outputfilePengurus, '|',
                            CSVWriter.NO_QUOTE_CHARACTER,
                            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                            CSVWriter.DEFAULT_LINE_END);

                    dataPengurus.add(new String[]{pengurusData[0], "pengurusData[4]", "pengurusData[3]", "Jalan Bahyang " + ix, "Kelurahan Bahyang " + ix, "Kecamatan Bahyang " + ix,
                            "100050", "0112", "0813410090050", "11-AKTA PERUSAHAAN-0000000119" + ix, "08281992", "11-AKTA PERUSAHAAN-0000000119" + ix,
                            "08281992", "550000", "pengurusData[2]", "pengurusData[5]", "P01", "pengurusData[7]", "pengurusData[6]", "00000000000000090051", "05092022",
                            "05102022", "2", "31400", "00000010000000099", "1", "S125012529L", "000002300000000", "18", "Jakarta Selatan"});


                    writerPengurus.writeAll(dataPengurus);
                    writerPengurus.close();

                    CSVFileName csvFileName = new CSVFileName();
                    csvFileName.parseDataPengurus(case3, nomor_aplikasi, kode_produk, pengurusData[0], tanggal);
                }
                ix++;
            }


            writerApp.writeAll(dataApp);
            writerRea.writeAll(dataRea);
            // closing writer connection
            writerApp.close();
            writerRea.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }

        // call class format file
        CSVFileName csvFileName = new CSVFileName();
        csvFileName.parseData(case1, case2, case3, nomor_aplikasi, kode_produk, tanggal);

    }
}


