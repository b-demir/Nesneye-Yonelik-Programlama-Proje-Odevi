# Akıllı Kampüs Ders Planlama Sistemi

Bu proje, derslik ve öğretim elemanlarının çakışma olmadan otomatik planlanmasını sağlayan Java tabanlı bir sistemdir. Uygulama konsol üzerinden çalışmakta olup, üretilen ders programı verileri kalıcı olarak txt dosyasına saklanmaktadır.

## Temel Özellikler
* **Çakışma Kontrolü:** Öğretim elemanlarının müsaitlik saatleri ve mekanların doluluk durumları algoritmik olarak denetlenerek çifte rezervasyonlar önlenir.
* **Kapasite ve Donanım Doğrulaması:** Dersin öğrenci sayısına ve ihtiyaç duyduğu donanıma göre uygun mekan ataması yapılır.
* **Kalıcı Veri Saklama:** Kesinleşen ve onaylanan ders programı `program.txt` dosyasına kalıcı olarak kaydedilir.

## Mimari ve Nesneye Yönelik Programlama (OOP)
Projede en az 8 anlamlı sınıf (Ders, OgretimElemani, Mekan, Derslik, Laboratuvar, ZamanDilimi, Planlayici, VeriYoneticisi) bulunmakta olup temel OOP prensipleri aktif olarak kullanılmıştır:
* **Kapsülleme (Encapsulation):** `OgretimElemani` sınıfındaki müsait saatler listesi `private` yapılarak dış müdahaleye kapatılmıştır.
* **Soyutlama (Abstraction):** Sistemdeki odalar için `Mekan` adında ortak özellikler taşıyan soyut (abstract) bir ana sınıf tasarlanmıştır.
* **Kalıtım (Inheritance):** `Derslik` ve `Laboratuvar` sınıfları, özelliklerini ana `Mekan` sınıfından miras almaktadır.
* **Çok Biçimlilik (Polymorphism):** `Mekan` sınıfındaki `derseUygunMu()` metodu, `Derslik` ve `Laboratuvar` alt sınıflarında kapasite ve donanım gereksinimlerine göre farklı davranışlar sergileyecek şekilde ezilmiştir (override).

## SOLID Prensipleri
Projede 4 adet SOLID prensibi uygulanmıştır:
1. **Single Responsibility:** Sınıflar tek bir amaca hizmet eder (Örn: `VeriYoneticisi` sınıfı sadece dosya işlemlerini yapar).
2. **Open/Closed:** Fabrika tasarımı sayesinde mevcut algoritmalar değiştirilmeden yeni mekan türleri eklenmeye açıktır.
3. **Liskov Substitution:** Alt sınıflar (`Derslik`, `Laboratuvar`), ana sınıfın (`Mekan`) yerine algoritmayı bozmadan kullanılabilir.
4. **Dependency Inversion:** Planlayıcı sınıf, doğrudan dosya işlemleri yapmak yerine bağımsız bir yönetici arayüzü ile haberleşir.

## Tasarım Kalıpları
Sistem mimarisinde 2 tasarım kalıbı (Design Pattern) uygulanmıştır:
* **Singleton Pattern:** `VeriYoneticisi` sınıfı, eşzamanlı dosya okuma/yazma çakışmalarını önlemek için bellekte tekil bir nesne olarak tasarlanmıştır.
* **Factory Pattern:** `MekanFabrikasi` sınıfı, `Derslik` ve `Laboratuvar` nesnelerinin dinamik olarak oluşturulmasını üstlenir.

## Birim Testleri (Unit Tests)
Sistemin doğruluğunu kanıtlamak amacıyla JUnit kütüphanesi kullanılarak en az 8 birim testi yazılmıştır. Bu testler kapasite kontrollerini, Singleton tekilliğini, sınıf özellikleri atamalarını ve Fabrika kalıbının nesne üretim süreçlerini otomatik olarak denetler.

## Kurulum ve Çalıştırma
1. Projeyi yerel makinenize klonlayın: `git clone https://github.com/b-demir/Nesneye-Yonelik-Programlama-Proje-Odevi`
2. Bağımlılıkların (JUnit vb.) yüklenmesi için proje dizininde Maven komutunu çalıştırın: `mvn clean install`
3. Birim testlerini başlatmak ve sistem doğrulamalarını görmek için: `mvn test`
4. Ana uygulamayı başlatmak ve ders programını oluşturmak için `src/main/java` dizinindeki `Main.java` dosyasını çalıştırın.