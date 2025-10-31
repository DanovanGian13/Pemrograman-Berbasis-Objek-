import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class StudiKasus4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Integer> hashMapNilai = new HashMap<>();
        ArrayList<Integer> daftarNilai = new ArrayList<>();
        HashMap<Integer, Integer> hashMapCounter = new HashMap<>();
        HashMap<Integer, Integer> hashMapTotalTerendah = new HashMap<>();
        HashMap<Integer, Integer> hashMapCounterTerbanyak = new HashMap<>();
        
        while (true) {
            String masukan = scanner.nextLine();
            
            if (masukan.equals("---")) {
                break;
            }
            
            int nilai = Integer.parseInt(masukan);
            int count = 1;
            if (hashMapNilai.containsKey(nilai)) {
                count = hashMapNilai.get(nilai) + 1;
            }
            
            hashMapNilai.put(nilai, count);
            daftarNilai.add(nilai);
        }
        
        
        int[] arrayNilai = daftarNilai.stream().mapToInt(Integer::intValue).toArray();
        
        
        int nilaiTertinggi = arrayNilai[0];
        int nilaiTerendah = arrayNilai[0];
        
        for (int i = 1; i < arrayNilai.length; i++) {
            if (nilaiTertinggi < arrayNilai[i]) {
                nilaiTertinggi = arrayNilai[i];
            }
            
            if (nilaiTerendah > arrayNilai[i]) {
                nilaiTerendah = arrayNilai[i];
            }
            
        }
            
        
        int nilaiJumlahTerendah = arrayNilai[0];
        int jumlahTerendah = nilaiJumlahTerendah;
        
        for(int i = 0; i < arrayNilai.length; i++) {
            if (hashMapTotalTerendah.containsKey(arrayNilai[i])) {
                int newTotal = hashMapTotalTerendah.get(arrayNilai[i]) + arrayNilai[i];
                hashMapTotalTerendah.put(arrayNilai[i], newTotal);
            } else {
                hashMapTotalTerendah.put(arrayNilai[i], arrayNilai[i]);
            }

            if (arrayNilai[i] == nilaiJumlahTerendah) {
                jumlahTerendah = hashMapTotalTerendah.get(nilaiJumlahTerendah);
            }
            
            else if (jumlahTerendah > hashMapTotalTerendah.get(arrayNilai[i])) {
                nilaiJumlahTerendah = arrayNilai[i];
                jumlahTerendah = hashMapTotalTerendah.get(arrayNilai[i]);
            }
            
        }

        int nilaiTerbanyak = 0;
        int frekuensiTerbanyak = 0;

        for(int i = 0; i < arrayNilai.length; i++) {
            
            int frekuensiSaatIni = hashMapNilai.get(arrayNilai[i]);
            if(frekuensiSaatIni > frekuensiTerbanyak) {
                frekuensiTerbanyak = frekuensiSaatIni;
            }
            
        }

        for (int i = 0; i < arrayNilai.length; i++) {
            int count = 1;
            if (hashMapCounterTerbanyak.containsKey(arrayNilai[i])) {
                count = hashMapCounterTerbanyak.get(arrayNilai[i]) + 1;
            }

            hashMapCounterTerbanyak.put(arrayNilai[i], count);

            int frekuensiSaatIni = hashMapCounterTerbanyak.get(arrayNilai[i]);
            if (frekuensiSaatIni == frekuensiTerbanyak) {
                nilaiTerbanyak = arrayNilai[i];
                break;
            }
        }


        
        int nilaiTerdikit = arrayNilai[0];
        int frekuensiTerdikit = 1;
        hashMapCounter.put(nilaiTerdikit, 1);

        for(int i = 1; i < arrayNilai.length; i++) {
            
            int count = 1;
            if (hashMapCounter.containsKey(arrayNilai[i])) {
                count = hashMapCounter.get(arrayNilai[i]) + 1;
            }

            hashMapCounter.put(arrayNilai[i], count);
            
            if(arrayNilai[i] != nilaiTerdikit) {
                continue; 
            } else if (arrayNilai[i] == nilaiTerdikit) {
                for (int j = i + 1; j < arrayNilai.length; j++){
                
                    if (hashMapCounter.containsKey(arrayNilai[j])) {
                        continue;
                    }
                    else if(!hashMapCounter.containsKey(arrayNilai[j])) {
                        hashMapCounter.put(arrayNilai[j], 1);
                        nilaiTerdikit = arrayNilai[j];
                        frekuensiTerdikit = hashMapCounter.get(nilaiTerdikit);
                        i = j;
                        break;
                    }

                }
            }
        }
        
        

        // ArrayList<Integer> jumlahSetiapNilai = new ArrayList<>();
        int jumlahTertinggi = arrayNilai[0];
        int nilaiJumlahTertinggi = 0;
        int frekuensiNilaiJumlahTertinggi = 0;
        
        if (!hashMapNilai.isEmpty()) {
            for (HashMap.Entry<Integer, Integer> entry : hashMapNilai.entrySet()) {
                int frekuensiSaatIni = entry.getValue();
                int angkaSaatIni = entry.getKey();
                int jumlah = frekuensiSaatIni * angkaSaatIni;
                if(jumlah >= jumlahTertinggi && angkaSaatIni > nilaiJumlahTertinggi) {
                    jumlahTertinggi = jumlah;
                    nilaiJumlahTertinggi = angkaSaatIni;
                    frekuensiNilaiJumlahTertinggi = frekuensiSaatIni;
                    
                }
            }
        }

        System.out.println("Tertinggi: " + nilaiTertinggi);
        System.out.println("Terendah: " + nilaiTerendah);
        System.out.println("Terbanyak: " + nilaiTerbanyak + " " + "(" + frekuensiTerbanyak + "x)");
        System.out.println("Tersedikit: " + nilaiTerdikit + " " + "(" + frekuensiTerdikit + "x)");
        System.out.println("Jumlah Tertinggi: " + nilaiJumlahTertinggi + " * " + frekuensiNilaiJumlahTertinggi+ " = " + jumlahTertinggi);
        System.out.println("Jumlah Terendah: " + nilaiJumlahTerendah + " * " + hashMapNilai.get(nilaiJumlahTerendah) + " = " +jumlahTerendah);




        scanner.close();
    }
}