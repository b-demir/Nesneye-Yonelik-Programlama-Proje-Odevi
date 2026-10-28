package nesne_proje_odevi;

public class Derslik extends Mekan {
    public Derslik(String odaNo, int kapasite) {
        super(odaNo, kapasite);
    }

    @Override
    public boolean derseUygunMu(Ders d, ZamanDilimi z) {
        return d.ogrenciSayisi <= this.kapasite;
    }
}
