package nesne_proje_odevi;

import java.util.ArrayList;
import java.util.List;

public class OgretimElemani {
    public String adSoyad;
    public List<String> uzmanlikAlanlari;
    private List<ZamanDilimi> musaitSaatler;

    public OgretimElemani(String adSoyad, List<String> uzmanlikAlanlari) {
        this.adSoyad = adSoyad;
        this.uzmanlikAlanlari = uzmanlikAlanlari;
        this.musaitSaatler = new ArrayList<>();
    }

    public void musaitSaatEkle(ZamanDilimi zaman) {
        this.musaitSaatler.add(zaman);
    }
    public List<ZamanDilimi> getMusaitSaatler() {
        return this.musaitSaatler;
    }
}
