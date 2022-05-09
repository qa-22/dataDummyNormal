package CreateDataCSV;


import RandomValue.GenerateRandomData;
import TestData.ReadTestData;
import com.opencsv.CSVWriter;
import formatFile.CSVFileName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataCSV {
    public void dataDummy() throws InterruptedException {
        String nama_file = null, nomor_aplikasi = null, kode_produk = null, tanggal = null;

        // first create file object for file placed at location
        // specified by filepath
        File file = new File(".//resultDataDummyFile//APPFILE.csv");

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter with '|' as separator
            CSVWriter writer = new CSVWriter(outputfile, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"Nomor_Aplikasi", "NIK", "NPWP", "Jenis_Debitur", "Nama_Debitur", "Jangka_Waktu", "Interest_Rate", "Plafon_Kredit"});

            // call class generate random data
            GenerateRandomData generateRandomData = new GenerateRandomData();

            // call class read excel
            ReadTestData readTestData = new ReadTestData();
            readTestData.testData();

            //value array
            nama_file = String.valueOf(readTestData.cellDataValue[0]);
            nomor_aplikasi = String.valueOf(readTestData.cellDataValue[1]);
            kode_produk = String.valueOf(readTestData.cellDataValue[2]);
            tanggal = String.valueOf(readTestData.cellDataValue[3]);

            // write data csv
            for (int idx = 1; idx < 10; idx++)
                data.add(new String[]{nomor_aplikasi + generateRandomData.nomorAplikasi(), generateRandomData.nik(), generateRandomData.npwp()
                        , generateRandomData.jenisDebitur(), "Winter "+generateRandomData.namaDebitur(), "00"+generateRandomData.jangkaWaktu()
                        , "015"+generateRandomData.interestRate(), "000000"+generateRandomData.plafonKredit()+"00"});


            writer.writeAll(data);
            // closing writer connection
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // call class format file
        CSVFileName csvFileName = new CSVFileName();
        csvFileName.parseData(nama_file, nomor_aplikasi, kode_produk, tanggal);

    }
}


