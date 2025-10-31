import java.util.Scanner;

public class StudiKasus1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Langsung baca input NIM
        String nim = input.nextLine();

        // Ekstrak bagian NIM
        String prefix = nim.substring(0, 3);   // 3 digit pertama
        String angkatan = nim.substring(3, 5); // digit ke-4 & ke-5
        String nomorUrut = nim.substring(5);   // sisanya untuk nomor urut

        // Hilangkan leading zero (nol di depan)
        int urutan = Integer.parseInt(nomorUrut);

        // Tentukan program studi dari prefix
        String prodi;
        switch (prefix) {
            case "11S": prodi = "Sarjana Informatika"; break;
            case "12S": prodi = "Sarjana Sistem Informasi"; break;
            case "14S": prodi = "Sarjana Teknik Elektro"; break;
            case "21S": prodi = "Sarjana Manajemen Rekayasa"; break;
            case "22S": prodi = "Sarjana Teknik Metalurgi"; break;
            case "31S": prodi = "Sarjana Teknik Bioproses"; break;
            case "114": prodi = "Diploma 4 Teknologi Rekasaya Perangkat Lunak"; break;
            case "113": prodi = "Diploma 3 Teknologi Informasi"; break;
            case "133": prodi = "Diploma 3 Teknologi Komputer"; break;
            default: prodi = "Program studi tidak diketahui"; break;
        }

        // Cetak hasil sesuai format
        System.out.println("Inforamsi NIM " + nim + ": ");
        System.out.println(">> Program Studi: " + prodi);
        System.out.println(">> Angkatan: 20" + angkatan);
        System.out.println(">> Urutan: " + urutan);
    }
}
