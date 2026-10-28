package nesne_proje_odevi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// (Singleton Pattern & Single Responsibility)
// Sistemde sadece tek bir dosya yöneticisi olmasını garanti eder.
public class VeriYoneticisi {
    private static VeriYoneticisi instance;

    private VeriYoneticisi() {}

    public static VeriYoneticisi getInstance() {
        if (instance == null) {
            instance = new VeriYoneticisi();
        }
        return instance;
    }

    public void verileriKaydet(List<String> olusturulanProgram) {
        try (FileWriter writer = new FileWriter("program.txt")) {
            for (String satir : olusturulanProgram) {
                writer.write(satir + "\n");
            }
            System.out.println("Başarılı: Ders programı 'program.txt' dosyasına kalıcı olarak kaydedildi.");
        } catch (IOException e) {
            System.out.println("Hata: Dosya kaydedilemedi. " + e.getMessage());
        }
    }
}