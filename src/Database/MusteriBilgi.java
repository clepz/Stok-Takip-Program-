package Database;

public class MusteriBilgi {
    private int ID;
    private String adSoyad;
    private String telefon;
    private String adres;
    private String aldigiUrun;
    private double fiyat;
    private String satan;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAldigiUrun() {
        return aldigiUrun;
    }

    public void setAldigiUrun(String aldigiUrun) {
        this.aldigiUrun = aldigiUrun;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getSatan() {
        return satan;
    }

    public void setSatan(String satan) {
        this.satan = satan;
    }
}
