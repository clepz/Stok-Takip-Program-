package main;

import Database.Kullanicilar;
import StokProgrami.SatisBilgiForm;
import StokProgrami.StokProgram;

public class main {

    public static void main(String[] args) {
        Kullanicilar kisi = new Kullanicilar();
        kisi.setYetki(3);
        new UserConnection().setVisible(true);
    }
}
