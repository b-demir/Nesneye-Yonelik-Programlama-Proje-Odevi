package nesne_proje_odevi;

import java.util.List;

// (Factory Design Pattern & Open/Closed Prensibi)
// Yeni mekan türleri eklendiğinde mevcut kodları bozmadan buradan üretilebilir.
public class MekanFactory {
    public static Mekan mekanOlustur(String tip, String odaNo, int kapasite, List<String> ekipmanlar) {
        if (tip.equalsIgnoreCase("Derslik")) {
            return new Derslik(odaNo, kapasite);
        } else if (tip.equalsIgnoreCase("Laboratuvar")) {
            return new Laboratuvar(odaNo, kapasite, ekipmanlar);
        }
        return null;
    }
}
