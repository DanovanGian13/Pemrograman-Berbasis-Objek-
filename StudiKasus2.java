import java.util.*;
import java.util.Locale;

public class StudiKasus2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pakai locale US agar desimal pakai titik
        Locale.setDefault(Locale.US);

        // Bobot komponen sesuai urutan input
        int bobotPA = sc.nextInt();
        int bobotT = sc.nextInt();
        int bobotK = sc.nextInt();
        int bobotP = sc.nextInt();
        int bobotUTS = sc.nextInt();
        int bobotUAS = sc.nextInt();
        sc.nextLine(); // buang newline

        // Simpan total skor & total maksimal per kategori
        int totalPA = 0, maxPA = 0;
        int totalT = 0, maxT = 0;
        int totalK = 0, maxK = 0;
        int totalP = 0, maxP = 0;
        int totalUTS = 0, maxUTS = 0;
        int totalUAS = 0, maxUAS = 0;

        // Baca input nilai sampai ketemu "---"
        while (true) {
            String line = sc.nextLine().trim();
            if (line.equals("---")) break;

            String[] parts = line.split("\\|");
            String simbol = parts[0];
            int maks = Integer.parseInt(parts[1]);
            int nilai = Integer.parseInt(parts[2]);

            switch (simbol) {
                case "PA":
                    maxPA += maks;
                    totalPA += nilai;
                    break;
                case "T":
                    maxT += maks;
                    totalT += nilai;
                    break;
                case "K":
                    maxK += maks;
                    totalK += nilai;
                    break;
                case "P":
                    maxP += maks;
                    totalP += nilai;
                    break;
                case "UTS":
                    maxUTS += maks;
                    totalUTS += nilai;
                    break;
                case "UAS":
                    maxUAS += maks;
                    totalUAS += nilai;
                    break;
            }
        }

        // Hitung rata-rata (dalam persen)
        double rataPA = (maxPA == 0) ? 0 : (totalPA * 100.0 / maxPA);
        double rataT = (maxT == 0) ? 0 : (totalT * 100.0 / maxT);
        double rataK = (maxK == 0) ? 0 : (totalK * 100.0 / maxK);
        double rataP = (maxP == 0) ? 0 : (totalP * 100.0 / maxP);
        double rataUTS = (maxUTS == 0) ? 0 : (totalUTS * 100.0 / maxUTS);
        double rataUAS = (maxUAS == 0) ? 0 : (totalUAS * 100.0 / maxUAS);

        //Pembulatan
        int bulatPA = (int)Math.floor(rataPA);
        int bulatT = (int)Math.floor(rataT);
        int bulatK = (int)Math.floor(rataK);
        int bulatP = (int)Math.floor(rataP);
        int bulatUTS = (int)Math.floor(rataUTS);
        int bulatUAS = (int)Math.floor(rataUAS);

        // Kontribusi nilai akhir
        double nilaiPA = (bulatPA / 100.0) * bobotPA;
        double nilaiT = (bulatT / 100.0) * bobotT;
        double nilaiK = (bulatK / 100.0) * bobotK;
        double nilaiP = (bulatP / 100.0) * bobotP;
        double nilaiUTS = (bulatUTS / 100.0) * bobotUTS;
        double nilaiUAS = (bulatUAS / 100.0) * bobotUAS;

        double totalNilai = nilaiPA + nilaiT + nilaiK + nilaiP + nilaiUTS + nilaiUAS;

        // Cetak hasil
        System.out.println("Perolehan Nilai:");
        System.out.printf(">> Partisipatif: %d/100 (%.2f/%d)\n", bulatPA, nilaiPA, bobotPA);
        System.out.printf(">> Tugas: %d/100 (%.2f/%d)\n", bulatT, nilaiT, bobotT);
        System.out.printf(">> Kuis: %d/100 (%.2f/%d)\n", bulatK, nilaiK, bobotK);
        System.out.printf(">> Proyek: %d/100 (%.2f/%d)\n", bulatP, nilaiP, bobotP);
        System.out.printf(">> UTS: %d/100 (%.2f/%d)\n", bulatUTS, nilaiUTS, bobotUTS);
        System.out.printf(">> UAS: %d/100 (%.2f/%d)\n", bulatUAS, nilaiUAS, bobotUAS);

        System.out.println();
        System.out.printf(">> Nilai Akhir: %.2f\n", totalNilai);
        System.out.printf(">> Grade: %s\n", getGrade(totalNilai));
    }

    // Fungsi konversi grade
    private static String getGrade(double nilai) {
        if (nilai >= 79.5) return "A";
        else if (nilai >= 72) return "AB";
        else if (nilai >= 64.5) return "B";
        else if (nilai >= 57) return "BC";
        else if (nilai >= 49.5) return "C";
        else if (nilai >= 34) return "D";
        else return "E";
    }
}
