package nesne_proje_odevi;

import java.util.ArrayList;
import java.util.List;

public class Planlayici {    
    private List<String> kesinlesenProgram = new ArrayList<>();
    
    private List<String> doluMekanZamanlari = new ArrayList<>();
    private List<String> doluHocaZamanlari = new ArrayList<>();

    public void dersProgramiOlustur(List<Ders> dersler, List<OgretimElemani> hocalar, List<Mekan> mekanlar) {
        for (Ders ders : dersler) {
            boolean atandi = false;
            
            for (OgretimElemani hoca : hocalar) {
                if (atandi) break;
                
                for (ZamanDilimi zaman : hoca.getMusaitSaatler()) {
                    if (atandi) break;
                    
                    String hocaZamanAnahtari = hoca.adSoyad + "-" + zaman.gun + "-" + zaman.baslangicSaati;
                    if (doluHocaZamanlari.contains(hocaZamanAnahtari)) {
                        continue;
                    }
                    
                    for (Mekan mekan : mekanlar) {
                        if (mekan.derseUygunMu(ders, zaman)) {
                            
                            String mekanZamanAnahtari = mekan.odaNo + "-" + zaman.gun + "-" + zaman.baslangicSaati;
                            
                            if (!doluMekanZamanlari.contains(mekanZamanAnahtari)) {
                                doluMekanZamanlari.add(mekanZamanAnahtari);
                                doluHocaZamanlari.add(hocaZamanAnahtari);
                                
                                String kayit = ders.dersAdi + " dersi, " + hoca.adSoyad + " tarafindan " + 
                                               mekan.odaNo + " nolu mekanda " + zaman.gun + " " + 
                                               zaman.baslangicSaati + "-" + zaman.bitisSaati + " arasinda verilecektir.";
                                kesinlesenProgram.add(kayit);
                                System.out.println("Atama yapildi: " + kayit);
                                atandi = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        VeriYoneticisi.getInstance().verileriKaydet(kesinlesenProgram);
    }
}