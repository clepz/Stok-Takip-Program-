package StokProgrami;

import Database.Kullanicilar;
import Database.MusteriBilgi;
import Database.Urun;

import java.util.ArrayList;

public interface UrunIslemleri {
    boolean urunEkle(Urun urun,String kisi);
    boolean urunGuncelle(Urun urun);
    boolean urunSat(Urun urun, float adet, Kullanicilar kisi, MusteriBilgi musteri);
    ArrayList<Urun> urunListele();
    Urun urunBilgiAl(String barkod);
    boolean urunSil(String barkod);

    boolean urunVarmi(String barkod);
}
