package RandomValue;

import java.util.Random;

public class GenerateRandomDataRea {

    public String nomorAplikasi() {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 10;
        Random rnd = new Random();
        StringBuilder nomoraplikasi = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nomoraplikasi.append(chars.charAt(rnd.nextInt(chars.length())));
        return nomoraplikasi.toString();
    }

    public String nik() {
        String chars = "1234567891111213141516171819245";
        int len = 16;
        Random rnd = new Random();
        StringBuilder nik = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nik.append(chars.charAt(rnd.nextInt(chars.length())));
        return nik.toString();
    }

    public String npwp() {
        String chars = "1234567891111213141516171819234";
        int len = 15;
        Random rnd = new Random();
        StringBuilder npwp = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            npwp.append(chars.charAt(rnd.nextInt(chars.length())));
        return npwp.toString();

    }

    public String jenisDebitur() {
        String chars = "ABC";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jenisdebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisdebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisdebitur.toString();
    }

    public String namaDebitur() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 10;
        Random rnd = new Random();
        StringBuilder namadebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            namadebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return namadebitur.toString();
    }

    public String jangkaWaktu() {
        String chars = "3456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jangkawaktu = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jangkawaktu.append(chars.charAt(rnd.nextInt(chars.length())));
        return jangkawaktu.toString();
    }

    public String interestRate() {
        String chars = "01234567891011121314151617181920";
        int len = 2;
        Random rnd = new Random();
        StringBuilder interestrate = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            interestrate.append(chars.charAt(rnd.nextInt(chars.length())));
        return interestrate.toString();
    }

    public String plafonKredit() {
        String chars = "12345678911112131415161718192";
        int len = 7;
        Random rnd = new Random();
        StringBuilder plafonkredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            plafonkredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return plafonkredit.toString();
    }
}
