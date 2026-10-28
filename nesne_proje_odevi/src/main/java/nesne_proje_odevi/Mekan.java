package nesne_proje_odevi;

public abstract class Mekan {
    public String odaNo;
    public int kapasite;

    public Mekan(String odaNo, int kapasite) {
        this.odaNo = odaNo;
        this.kapasite = kapasite;
    }

    public abstract boolean derseUygunMu(Ders d, ZamanDilimi z);
}
