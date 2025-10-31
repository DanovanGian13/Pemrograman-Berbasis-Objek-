import java.util.Scanner;

public class StudiKasus3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matriks = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matriks[i][j] = sc.nextInt();

        String nilaiLStr = "Tidak Ada";
        String nilaiKebalikanStr = "Tidak Ada";
        String nilaiTengahStr = "Tidak Ada";
        String perbedaanStr = "Tidak Ada";
        int dominan = 0;

        // Nilai tengah (umum)
        if (n == 1) {
            int center = matriks[0][0];
            nilaiTengahStr = String.valueOf(center);
            dominan = center;
        } else {
            if (n % 2 == 1) {
                int center = matriks[n / 2][n / 2];
                nilaiTengahStr = String.valueOf(center);
            } else {
                int mid = n / 2;
                int centerSum = matriks[mid - 1][mid - 1] + matriks[mid - 1][mid] + matriks[mid][mid - 1] + matriks[mid][mid];
                nilaiTengahStr = String.valueOf(centerSum);
            }
        }

        // Khusus n == 2: Nilai L dan Kebalikan = Tidak Ada, dominan = nilaiTengah
        if (n == 2) {
            dominan = Integer.parseInt(nilaiTengahStr);
        }

        // Kasus n >= 3: hitung L dan kebalikannya
        if (n >= 3) {
            int nilaiL = 0;
            // semua elemen kolom pertama
            for (int i = 0; i < n; i++) nilaiL += matriks[i][0];
            // tambah elemen baris terakhir kecuali pojok (j = 1 .. n-2)
            for (int j = 1; j <= n - 2; j++) nilaiL += matriks[n - 1][j];
            nilaiLStr = String.valueOf(nilaiL);

            int nilaiKebalikan = 0;
            // semua elemen kolom terakhir
            for (int i = 0; i < n; i++) nilaiKebalikan += matriks[i][n - 1];
            // tambah elemen baris pertama kecuali pojok (j = 1 .. n-2)
            for (int j = 1; j <= n - 2; j++) nilaiKebalikan += matriks[0][j];
            nilaiKebalikanStr = String.valueOf(nilaiKebalikan);

            // perbedaan (pakai nilai absolut agar tidak negatif)
            int perbedaan = Math.abs(nilaiL - nilaiKebalikan);
            perbedaanStr = String.valueOf(perbedaan);

            // dominan
            if (nilaiL > nilaiKebalikan) dominan = nilaiL;
            else if (nilaiKebalikan > nilaiL) dominan = nilaiKebalikan;
            else {
                // sama -> dominan = nilai tengah
                dominan = Integer.parseInt(nilaiTengahStr);
            }
        }

        // Output sesuai format expected
        if (nilaiLStr.equals("Tidak Ada")) {
            System.out.println("Nilai L: " + nilaiLStr);
        } else {
            System.out.println("Nilai L: " + nilaiLStr + ":");
        }
        System.out.println("Nilai Kebalikan L: " + nilaiKebalikanStr);
        System.out.println("Nilai Tengah: " + nilaiTengahStr);
        System.out.println("Perbedaan: " + perbedaanStr);
        System.out.println("Dominan: " + dominan);

        sc.close();
    }
}
