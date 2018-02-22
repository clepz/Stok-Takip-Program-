package Database;

public class Urun {
    private String urunAdi;
    private int barkod;
    private String urunSayi;
    private String birim;
    private float taneFiyati;
    private float satisFiyati;
    private double toplamFiyat;
    private String stokGrubu;
    private String rafNo;

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public int getBarkod() {
        return barkod;
    }

    public void setBarkod(int barkod) {
        this.barkod = barkod;
    }

    public String getUrunSayi() {
        return urunSayi;
    }

    public void setUrunSayi(String urunSayi) {
        this.urunSayi = urunSayi;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public float getTaneFiyati() {
        return taneFiyati;
    }

    public void setTaneFiyati(float taneFiyati) {
        this.taneFiyati = taneFiyati;
    }

    public float getSatisFiyati() {
        return satisFiyati;
    }

    public void setSatisFiyati(float satisFiyati) {
        this.satisFiyati = satisFiyati;
    }

    public double getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(double toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public String getStokGrubu() {
        return stokGrubu;
    }

    public void setStokGrubu(String stokGrubu) {
        this.stokGrubu = stokGrubu;
    }

    public String getRafNo() {
        return rafNo;
    }

    public void setRafNo(String rafNo) {
        this.rafNo = rafNo;
    }
}
