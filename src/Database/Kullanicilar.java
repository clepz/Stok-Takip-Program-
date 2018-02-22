package Database;

public class Kullanicilar {
    private int id;
    private String kullaniciAdi;
    private String parola;
    private int yetki;
    private String ad;
    private String soyad;


    public Kullanicilar(){}

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    private String telefon;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getYetki() {
        if(yetki == 1)
            return "Admin";
        else if (yetki == 2)
            return "Kullanıcı";
        return "Yönetici";
    }
    public int getYetkiSayi(){
        return yetki;
    }

    public void setYetki(int yetki) {
        this.yetki = yetki;
    }
}
