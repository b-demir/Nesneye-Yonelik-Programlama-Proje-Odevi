package nesne_proje_odevi;

import java.util.List;

public class Laboratuvar extends Mekan {
    public List<String> ekipmanlar;

    public Laboratuvar(String odaNo, int kapasite, List<String> ekipmanlar) {
        super(odaNo, kapasite);
        this.ekipmanlar = ekipmanlar;
    }

    @Override
    public boolean derseUygunMu(Ders d, ZamanDilimi z) {
        return d.ogrenciSayisi <= this.kapasite; 
    }
}
