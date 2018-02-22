package Database;

import StokProgrami.UrunIslemleri;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class DBoperations implements UrunIslemleri {
    private static DBoperations dBoperations;
    private static final String url = "jdbc:mysql://localhost:3306/stokTakip?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "clepz4141";
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    private DBoperations() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getConnection();
    }

    public static DBoperations createDBoperations() {
        if (dBoperations != null)
            return dBoperations;
        return new DBoperations();
    }

    private void getConnection()  {
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bağlantı Sağlanamadı Tekrar Deneyiniz.");
        }

    }
    public Kullanicilar girisYap(String id , String parola ) {
        Kullanicilar kisi = new Kullanicilar();
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici where yonetici_adi = '"+id+"'");
            if(!resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Hatali Giris Yaptiniz Tekrar Deneyiniz.");
                return null;
            }
            if (!(resultSet.getString("yonetici_sifre").equals(parola))){
                JOptionPane.showMessageDialog(null, "Hatali Giris Yaptiniz Tekrar Deneyiniz.");
                return null;
            }
            kisi.setId(resultSet.getInt(1));
            kisi.setKullaniciAdi(resultSet.getString(2));
            kisi.setParola(resultSet.getString(3));
            kisi.setYetki(resultSet.getInt(4));
            kisi.setAd(resultSet.getString(5));
            kisi.setSoyad(resultSet.getString(6));
            kisi.setTelefon(resultSet.getString(7));



        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir hata oluştu daha sonra tekrar deneyiniz.");
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Bir hata oluştu");
            }
        }
        return kisi;
    }

    public ArrayList<Kullanicilar> kullaniciVeriAl(){
        ArrayList<Kullanicilar> liste = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici");
            while (resultSet.next()){
                Kullanicilar kisi = new Kullanicilar();
                kisi.setId(resultSet.getInt(1));
                kisi.setKullaniciAdi(resultSet.getString(2));
                kisi.setParola(resultSet.getString(3));
                kisi.setYetki(resultSet.getInt(4));
                kisi.setAd(resultSet.getString(5));
                kisi.setSoyad(resultSet.getString(6));
                kisi.setTelefon(resultSet.getString(7));
                liste.add(kisi);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
            }
        }
        return liste;

    }
    public ArrayList<Kullanicilar> kullaniciVeriAl(String bilgi){
        ArrayList<Kullanicilar> liste = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici WHERE yonetici_adi = '"+bilgi+"' or ad = '"+bilgi+"'");
            while (resultSet.next()){
                Kullanicilar kisi = new Kullanicilar();
                kisi.setId(resultSet.getInt(1));
                kisi.setKullaniciAdi(resultSet.getString(2));
                kisi.setParola(resultSet.getString(3));
                kisi.setYetki(resultSet.getInt(4));
                kisi.setAd(resultSet.getString(5));
                kisi.setSoyad(resultSet.getString(6));
                kisi.setTelefon(resultSet.getString(7));
                liste.add(kisi);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
        }
        finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Bir hata oluştu. Daha sonra tekrar deneyiniz.");
            }
        }
        return liste;

    }

    public boolean kullaniciEkle(Kullanicilar kisi){
        try {
            int yetki = 0;
            if ((kisi.getYetki().equals("Admin"))) {
                yetki = 1;
            }
            else if(kisi.getYetki().equals("Kullanıcı")) {
                yetki = 2;
            }
            else
                yetki = 3;
            statement.execute("INSERT INTO yonetici (yonetici_adi,yonetici_sifre,yetki,ad,soyad,telefon) values" +
                    "('" +kisi.getKullaniciAdi()+"','" +kisi.getParola()+"','" +yetki+"'," +
                    "'" +kisi.getAd()+"','" +kisi.getSoyad()+"','" +kisi.getTelefon()+"')");
            close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void close(){
        try {
            if(resultSet != null)
                resultSet.close();
            if(statement != null)
                statement.close();
            if(connection != null)
                connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Veri Tabanına Bağlantı Sağlanamadı Tekrar Deneyiniz.");
            }

    }

    public boolean kullaniciAra(Kullanicilar kisi){
        try {
            resultSet = statement.executeQuery("SELECT * FROM yonetici");

            while (resultSet.next()){
                if(resultSet.getString(2).equals(kisi.getKullaniciAdi()))
                    return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
        }

        return false;
    }

    @Override
    public boolean urunEkle(Urun urun,String kisi) {
        try {
            PreparedStatement statement =  connection.prepareStatement("INSERT INTO stok (urun_adi,urun_sayi,sayi_birim,tane_fiyati,satis_fiyati,toplam_fiyati,stok_grubu,raf_no,ID)" +
                    "values(?,?,?,?,?,?,?,?,?) ");
            statement.setString(1,urun.getUrunAdi());
            statement.setInt(2, Integer.parseInt(urun.getUrunSayi()));
            statement.setString(3,urun.getBirim());
            statement.setFloat(4,urun.getTaneFiyati());
            statement.setFloat(5,urun.getSatisFiyati());
            statement.setDouble(6,urun.getToplamFiyat());
            statement.setString(7,urun.getStokGrubu());
            statement.setString(8,urun.getRafNo());
            statement.setInt(9,urun.getBarkod());
            statement.execute();

            statement = connection.prepareStatement("INSERT INTO girdiler (tarih,satin_alinan_urun,satin_alinan_kisi,miktar,tane_fiyat,toplam_fiyat)" +
                    " values (now(),?,?,?,?,?)");
            statement.setString(1,urun.getUrunAdi());
            statement.setString(2,kisi);
            statement.setString(3,urun.getUrunSayi());
            statement.setFloat(4,urun.getTaneFiyati());
            statement.setDouble(5, urun.getTaneFiyati() * Float.valueOf(urun.getUrunSayi()));
            statement.execute();


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean urunGuncelle(Urun urun) {
        try {
            PreparedStatement statement =  connection.prepareStatement("UPDATE stok SET urun_adi = ? , urun_sayi = ? , sayi_birim = ? , tane_fiyati = ? , " +
                    "satis_fiyati = ? , toplam_fiyati = ? , stok_grubu = ? , raf_no = ? , toplam_fiyati = ? WHERE ID = ?");
            statement.setString(1,urun.getUrunAdi());
            statement.setInt(2, Integer.parseInt(urun.getUrunSayi()));
            statement.setString(3,urun.getBirim());
            statement.setFloat(4,urun.getTaneFiyati());
            statement.setFloat(5,urun.getSatisFiyati());
            statement.setDouble(6,urun.getToplamFiyat());
            statement.setString(7,urun.getStokGrubu());
            statement.setString(8,urun.getRafNo());
            statement.setDouble(9,urun.getToplamFiyat());
            statement.setInt(10,urun.getBarkod());
            statement.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean urunSat(Urun urun,float adet,Kullanicilar kisi,MusteriBilgi musteri) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE stok SET urun_sayi = ? - ? , toplam_fiyati = ? WHERE ID = ?");
            preparedStatement.setInt(1, Integer.valueOf(urun.getUrunSayi()));
            preparedStatement.setFloat(2,adet);
            double toplam = urun.getToplamFiyat() - ((double)adet*urun.getSatisFiyati());
            preparedStatement.setDouble(3,toplam);
            preparedStatement.setInt(4,urun.getBarkod());
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement("INSERT INTO satis (tarih,kullanici_adi,satilan_urun,adet,toplam_fiyat) values (Now(),?,?,?,?)");
            preparedStatement.setString(1,kisi.getKullaniciAdi());
            preparedStatement.setString(2,urun.getUrunAdi());
            preparedStatement.setFloat(3,adet);
            preparedStatement.setDouble(4,(double)adet*urun.getSatisFiyati());
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement("INSERT INTO musteri (ad_soyad,tel_numara,adres,satin_alinan_urun,fiyat,satici_ad) " +
                    "values(?,?,?,?,?,?)");
            preparedStatement.setString(1,musteri.getAdSoyad());
            preparedStatement.setString(2,musteri.getTelefon());
            preparedStatement.setString(3,musteri.getAdres());
            preparedStatement.setString(4,musteri.getAldigiUrun());
            preparedStatement.setDouble(5,musteri.getFiyat());
            preparedStatement.setString(6,musteri.getSatan());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Urun> urunListele() {
        ArrayList<Urun> liste = new ArrayList<>();

        try {
            resultSet = statement.executeQuery("SELECT * FROM stok");

            while(resultSet.next()){
                Urun urun = new Urun();
                urun.setBarkod(resultSet.getInt(1));
                urun.setUrunAdi(resultSet.getString(2));
                urun.setUrunSayi(resultSet.getString(3));
                urun.setBirim(resultSet.getString(4));
                urun.setTaneFiyati(resultSet.getFloat(5));
                urun.setSatisFiyati(resultSet.getFloat(6));
                urun.setToplamFiyat(resultSet.getDouble(7));
                urun.setStokGrubu(resultSet.getString(8));
                urun.setRafNo(resultSet.getString(9));
                liste.add(urun);
            }
            close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public Urun urunBilgiAl(String barkod) {
        Urun urun = new Urun();

        try {
            resultSet = statement.executeQuery("SELECT * FROM stok WHERE ID = "+Integer.valueOf(barkod));
            resultSet.next();
            urun.setBarkod(resultSet.getInt(1));
            urun.setUrunAdi(resultSet.getString(2));
            urun.setUrunSayi(resultSet.getString(3));
            urun.setBirim(resultSet.getString(4));
            urun.setTaneFiyati(resultSet.getFloat(5));
            urun.setSatisFiyati(resultSet.getFloat(6));
            urun.setToplamFiyat(Double.valueOf(resultSet.getDouble(7)));
            urun.setStokGrubu(resultSet.getString(8));
            urun.setRafNo(resultSet.getString(9));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata oluştu. Barkodu Tekrar Kontrol Ediniz. Eğer Sorun Devam Ederse Yetkiliye Başvurunuz.");
            e.printStackTrace();
            return null;
        }
        return urun;
    }

    @Override
    public boolean urunSil(String barkod) {
        try {
            statement.execute("delete from stok where ID = '"+barkod+"'");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean urunVarmi(String barkod) {
        try {
            resultSet = statement.executeQuery(" SELECT ID FROM stok ");
            while (resultSet.next()){
                if(resultSet.getInt(1) == Integer.valueOf(barkod)) return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<SatisBilgi> satisBilgiAl(String kullaniciAdi){
        ArrayList<SatisBilgi> liste = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT tarih,satilan_urun,adet,toplam_fiyat from satis WHERE kullanici_adi= '"+kullaniciAdi+"'");
            while(resultSet.next()){
                SatisBilgi bilgi = new SatisBilgi();
                bilgi.setTarih(resultSet.getString(1));
                bilgi.setUrunAdi(resultSet.getString(2));
                bilgi.setAdet(resultSet.getFloat(3));
                bilgi.setToplamFiyat(resultSet.getDouble(4));

                liste.add(bilgi);
            }

            return liste;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu");
            e.printStackTrace();
            return liste;
        }
    }

    public ArrayList<MusteriBilgi> musterListe() {
        ArrayList<MusteriBilgi> liste = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM musteri");
            while (resultSet.next()){
                MusteriBilgi musteri = new MusteriBilgi();
                musteri.setID(resultSet.getInt(1));
                musteri.setTelefon(resultSet.getString(3));
                musteri.setSatan(resultSet.getString(7));
                musteri.setFiyat(resultSet.getDouble(6));
                musteri.setAdSoyad(resultSet.getString(2));
                musteri.setAdres(resultSet.getString(4));
                musteri.setAldigiUrun(resultSet.getString(5));
                liste.add(musteri);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu");
        }
        return liste;
    }
    public ArrayList<MusteriBilgi> musteriBilgiAl(String adSoyad){
        ArrayList<MusteriBilgi> liste = new ArrayList<>();

        try {
            resultSet = statement.executeQuery("SELECT * FROM musteri WHERE ad_soyad = '"+adSoyad+"'");
            while (resultSet.next()){
                MusteriBilgi musteri = new MusteriBilgi();
                musteri.setID(resultSet.getInt(1));
                musteri.setTelefon(resultSet.getString(3));
                musteri.setSatan(resultSet.getString(7));
                musteri.setFiyat(resultSet.getDouble(6));
                musteri.setAdSoyad(resultSet.getString(2));
                musteri.setAdres(resultSet.getString(4));
                musteri.setAldigiUrun(resultSet.getString(5));
                liste.add(musteri);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu");
        }
        return liste;
    }

    public boolean kullaniciSil(int integer) {
        try {
            statement.execute("DELETE FROM yonetici WHERE idyonetici = "+integer);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean kullaniciGuncelle(Kullanicilar kisi) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE yonetici SET yonetici_adi = ? , yonetici_sifre = ?" +
                    ", yetki = ?, ad = ? , soyad = ? , telefon = ? WHERE idyonetici = ? ");
            preparedStatement.setString(1,kisi.getKullaniciAdi());
            preparedStatement.setString(2,kisi.getParola());
            preparedStatement.setInt(3,kisi.getYetkiSayi());
            preparedStatement.setString(4,kisi.getAd());
            preparedStatement.setString(5,kisi.getSoyad());
            preparedStatement.setString(6,kisi.getTelefon());
            preparedStatement.setInt(7,kisi.getId());
            preparedStatement.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void satisAnalizTabloYap(JTable tbSatisAnaliz) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM satis");
            DefaultTableModel model = (DefaultTableModel) tbSatisAnaliz.getModel();
            model.getDataVector().removeAllElements();
            tbSatisAnaliz.revalidate();
            tbSatisAnaliz.repaint();
            while(resultSet.next()){
                model.addRow(new Object[]{resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getFloat(5),resultSet.getDouble(6)});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
        }
    }

    public void alimAnalizTabloYap(JTable tbAlimAnaliz) {
        try {
            resultSet = statement.executeQuery("SELECT * FROM girdiler");
            DefaultTableModel model = (DefaultTableModel) tbAlimAnaliz.getModel();
            model.getDataVector().removeAllElements();
            tbAlimAnaliz.revalidate();
            tbAlimAnaliz.repaint();
            while(resultSet.next()){
                model.addRow(new Object[]{resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getFloat(5),
                        resultSet.getFloat(6),resultSet.getDouble(7)});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.");
        }
    }

    public String[] enCokSatan(){
        String[] urun = new String[2];

        try {
            resultSet = statement.executeQuery(" select kullanici_adi,sum(adet) from satis group by kullanici_adi order by sum(adet) desc");
            resultSet.next();
            urun[0] = resultSet.getString(1);
            urun[1] = resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
    }
    public String[] enCokSatanUrun(){
        String[] urun = new String[2];

        try {
            resultSet = statement.executeQuery(" select satilan_urun,sum(adet) from satis group by satilan_urun order by sum(adet) desc");
            resultSet.next();
            urun[0] = resultSet.getString(1);
            urun[1] = resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
    }
    public String[] enCokGelir(){
        String[] urun = new String[2];

        try {
            resultSet = statement.executeQuery(" select satilan_urun,sum(toplam_fiyat) from satis group by satilan_urun order by sum(toplam_fiyat) desc");
            resultSet.next();
            urun[0] = resultSet.getString(1);
            urun[1] = resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
    }

    public String[] enAzSatan(){
        String[] urun = new String[2];

        try {
            resultSet = statement.executeQuery(" select kullanici_adi,sum(adet) from satis group by kullanici_adi order by sum(adet)");
            resultSet.next();
            urun[0] = resultSet.getString(1);
            urun[1] = resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
    }
    public String[] enAzSatanUrun(){
        String[] urun = new String[2];

        try {
            resultSet = statement.executeQuery(" select satilan_urun,sum(adet) from satis group by satilan_urun order by sum(adet) ");
            resultSet.next();
            urun[0] = resultSet.getString(1);
            urun[1] = resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
    }
    public String[] enAzGelir(){
        String[] urun = new String[2];

        try {
            resultSet = statement.executeQuery(" select satilan_urun,sum(toplam_fiyat) from satis group by satilan_urun order by sum(toplam_fiyat)");
            resultSet.next();
            urun[0] = resultSet.getString(1);
            urun[1] = resultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return urun;
    }

    public double toplamGelirMiktari(){
        try {
            resultSet = statement.executeQuery("Select sum(toplam_fiyat) from satis");
            resultSet.next();
            return resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public double toplamGiderMiktari(){
        try {
            resultSet = statement.executeQuery("Select sum(toplam_fiyat) from girdiler");
            resultSet.next();
            return resultSet.getDouble(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public void stokAzListe(JList<String> listStokAz) {
        DefaultListModel<String> list = new DefaultListModel<>();
        listStokAz.setModel(list);
        try {
            resultSet = statement.executeQuery("Select urun_adi,urun_sayi from stok where urun_sayi <=5");
            while(resultSet.next()){
                list.addElement(resultSet.getFloat(2) + " - " + resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Bir Hata Oluştu");
        }
    }
}
