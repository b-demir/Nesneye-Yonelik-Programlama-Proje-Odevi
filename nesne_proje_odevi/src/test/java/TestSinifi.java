

import org.junit.jupiter.api.Test;

import nesne_proje_odevi.Ders;
import nesne_proje_odevi.Derslik;
import nesne_proje_odevi.Laboratuvar;
import nesne_proje_odevi.Mekan;
import nesne_proje_odevi.MekanFactory;
import nesne_proje_odevi.OgretimElemani;
import nesne_proje_odevi.VeriYoneticisi;
import nesne_proje_odevi.ZamanDilimi;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TestSinifi {

    @Test
    public void test1_KapasiteKontrolu() {
        // Derslik kapasitesi 40, öğrenci 50. Atama reddedilmeli (False dönmeli).
        Mekan derslik = MekanFactory.mekanOlustur("Derslik", "D-101", 40, null);
        Ders kalabalikDers = new Ders("MAT101", "Matematik", 3, 50);
        ZamanDilimi zaman = new ZamanDilimi("Pazartesi", "09:00", "10:00");
        
        assertFalse(derslik.derseUygunMu(kalabalikDers, zaman));
    }

    @Test
    public void test2_UygunKapasiteKontrolu() {
        // Derslik kapasitesi 40, öğrenci 30. Atama onaylanmalı (True dönmeli).
        Mekan derslik = MekanFactory.mekanOlustur("Derslik", "D-102", 40, null);
        Ders normalDers = new Ders("FIZ101", "Fizik", 3, 30);
        ZamanDilimi zaman = new ZamanDilimi("Sali", "10:00", "11:00");
        
        assertTrue(derslik.derseUygunMu(normalDers, zaman));
    }

    @Test
    public void test3_SingletonVeriYoneticisi() {
        // VeriYoneticisi'nden iki kere nesne istendiğinde bellekteki aynı nesneyi (tekilliği) vermelidir.
        VeriYoneticisi yonetici1 = VeriYoneticisi.getInstance();
        VeriYoneticisi yonetici2 = VeriYoneticisi.getInstance();
        
        assertSame(yonetici1, yonetici2);
    }

    @Test
    public void test4_MekanFactoryDerslikUretimi() {
        // Fabrika kalıbı doğru tipte (Derslik) nesne üretmeli.
        Mekan uretilen = MekanFactory.mekanOlustur("Derslik", "D-200", 50, null);
        assertTrue(uretilen instanceof Derslik);
    }

    @Test
    public void test5_MekanFactoryLaboratuvarUretimi() {
        // Fabrika kalıbı doğru tipte (Laboratuvar) nesne üretmeli.
        Mekan uretilen = MekanFactory.mekanOlustur("Laboratuvar", "L-100", 30, Arrays.asList("PC"));
        assertTrue(uretilen instanceof Laboratuvar);
    }

    @Test
    public void test6_HocaMusaitlikEkleme() {
        // Kapsülleme ile gizlenen listeye başarıyla zaman eklenebilmeli.
        OgretimElemani hoca = new OgretimElemani("Ali Yilmaz", Arrays.asList("Tarih"));
        ZamanDilimi zaman = new ZamanDilimi("Carsamba", "13:00", "15:00");
        hoca.musaitSaatEkle(zaman);
        
        assertEquals(1, hoca.getMusaitSaatler().size());
    }

    @Test
    public void test7_ZamanDilimiDegerAtamasi() {
        // Zaman dilimi nesnesi verileri doğru tutmalı.
        ZamanDilimi zaman = new ZamanDilimi("Cuma", "15:00", "17:00");
        assertEquals("Cuma", zaman.gun);
    }

    @Test
    public void test8_DersDegerAtamasi() {
        // Ders nesnesi başlangıç değerlerini eksiksiz tutmalı.
        Ders ders = new Ders("KIM101", "Kimya", 4, 20);
        assertEquals("KIM101", ders.dersKodu);
        assertEquals(4, ders.kredi);
    }
}