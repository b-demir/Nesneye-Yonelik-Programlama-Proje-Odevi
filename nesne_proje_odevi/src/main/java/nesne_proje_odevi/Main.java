package nesne_proje_odevi;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Akilli Kampus Ders Planlama Sistemi Baslatiliyor...\n");

        // 1. Mekanları oluştur (Factory Pattern kullanımı)
        Mekan derslik1 = MekanFactory.mekanOlustur("Derslik", "D-101", 40, null);
        Mekan lab1 = MekanFactory.mekanOlustur("Laboratuvar", "L-201", 30, Arrays.asList("Bilgisayar", "Projeksiyon"));
        List<Mekan> mekanlar = Arrays.asList(derslik1, lab1);

        // 2. Zaman Dilimlerini oluştur
        ZamanDilimi z1 = new ZamanDilimi("Pazartesi", "09:00", "10:45");
        ZamanDilimi z2 = new ZamanDilimi("Sali", "13:00", "14:45");

        // 3. Öğretim Elemanlarını oluştur ve kapsüllenmiş listeye zaman ekle
        OgretimElemani hoca1 = new OgretimElemani("Ahmet Yilmaz", Arrays.asList("Yazilim", "Algoritma"));
        hoca1.musaitSaatEkle(z1);
        
        OgretimElemani hoca2 = new OgretimElemani("Ayse Demir", Arrays.asList("Veritabani"));
        hoca2.musaitSaatEkle(z2);
        
        List<OgretimElemani> hocalar = Arrays.asList(hoca1, hoca2);

        // 4. Dersleri oluştur
        Ders ders1 = new Ders("NYP101", "Nesneye Yonelik Programlama", 4, 35);
        Ders ders2 = new Ders("VT101", "Veritabani Yonetim Sistemleri", 3, 25);
        List<Ders> dersler = Arrays.asList(ders1, ders2);

        // 5. Planlayıcıyı çalıştır
        Planlayici planlayici = new Planlayici();
        planlayici.dersProgramiOlustur(dersler, hocalar, mekanlar);
    }
}