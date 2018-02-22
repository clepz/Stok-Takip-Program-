/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StokProgrami;

import Database.DBoperations;
import Database.Kullanicilar;
import Database.MusteriBilgi;
import Database.Urun;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author clepz
 */
public class SatisBilgiForm extends javax.swing.JFrame {

    /**
     * Creates new form satinAlmaBilgiForm
     */
    public SatisBilgiForm(Urun urun, Kullanicilar kisi, float adet,JTable tablo) {
        this.urun = urun;
        this.kisi = kisi;
        this.adet = adet;
        this.tablo = tablo;
        initComponents();
        tfAlinanUrun.setText(urun.getUrunAdi());
        double fiyat = (double) adet * urun.getSatisFiyati();
        tfFiyat.setText(String.valueOf(fiyat));
        tfSatan.setText(kisi.getKullaniciAdi());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfAlinanUrun = new javax.swing.JTextField();
        tfSatan = new javax.swing.JTextField();
        tfTelefon = new javax.swing.JTextField();
        tfFiyat = new javax.swing.JTextField();
        tfAdSoyad = new javax.swing.JTextField();
        tfAdres = new javax.swing.JTextField();
        btnSat = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(208, 208, 208));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 400));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SATIŞ BİLGİ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 30, 490, 70);

        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Ad Soyad");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 170, 90, 40);

        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Adres : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 230, 80, 40);

        jLabel4.setForeground(java.awt.Color.black);
        jLabel4.setText("Telefon :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(290, 170, 80, 40);

        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Fiyat : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 300, 90, 40);

        jLabel6.setForeground(java.awt.Color.black);
        jLabel6.setText("Alınan Ürün :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(520, 170, 110, 30);

        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Satan : ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(300, 300, 90, 30);

        tfAlinanUrun.setEditable(false);
        tfAlinanUrun.setBackground(new java.awt.Color(83, 87, 99));
        tfAlinanUrun.setForeground(java.awt.Color.white);
        jPanel1.add(tfAlinanUrun);
        tfAlinanUrun.setBounds(620, 170, 150, 40);

        tfSatan.setEditable(false);
        tfSatan.setBackground(new java.awt.Color(83, 87, 99));
        tfSatan.setForeground(java.awt.Color.white);
        jPanel1.add(tfSatan);
        tfSatan.setBounds(380, 300, 150, 40);

        tfTelefon.setBackground(new java.awt.Color(83, 87, 99));
        tfTelefon.setForeground(java.awt.Color.white);

        jPanel1.add(tfTelefon);
        tfTelefon.setBounds(360, 170, 140, 40);

        tfFiyat.setEditable(false);
        tfFiyat.setBackground(new java.awt.Color(83, 87, 99));
        tfFiyat.setForeground(java.awt.Color.white);
        jPanel1.add(tfFiyat);
        tfFiyat.setBounds(110, 300, 140, 40);

        tfAdSoyad.setBackground(new java.awt.Color(83, 87, 99));
        tfAdSoyad.setForeground(java.awt.Color.white);
        jPanel1.add(tfAdSoyad);
        tfAdSoyad.setBounds(110, 170, 160, 40);

        tfAdres.setBackground(new java.awt.Color(83, 87, 99));
        tfAdres.setForeground(java.awt.Color.white);
        jPanel1.add(tfAdres);
        tfAdres.setBounds(110, 230, 660, 40);

        btnSat.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        btnSat.setText("SAT");
        jPanel1.add(btnSat);
        btnSat.setBounds(600, 300, 150, 50);
        btnSat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                musteriOlustur();
                DBoperations dBoperations = DBoperations.createDBoperations();
                if(dBoperations.urunSat(urun,adet,kisi,musteri)){
                    JOptionPane.showMessageDialog(null,"Ürün Satışı Başarılı");
                    dispose();
                    ArrayList<Urun> liste =  dBoperations.urunListele();
                    dBoperations.close();
                    DefaultTableModel model = (DefaultTableModel) tablo.getModel();
                    model.getDataVector().removeAllElements();
                    tablo.revalidate();
                    tablo.repaint();
                    while(!liste.isEmpty()) {
                        Urun urunler = liste.remove(0);
                        model.addRow(new Object[]{urunler.getBarkod(),urunler.getUrunAdi(),urunler.getUrunSayi(),urunler.getBirim(),urunler.getTaneFiyati()+"TL",urunler.getSatisFiyati()+"TL",
                                urunler.getToplamFiyat()+"TL",urunler.getStokGrubu(),urunler.getRafNo()});
                    }
                }
            }
        });

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 400);

        setLocationRelativeTo(null);
        pack();
    }

    private void musteriOlustur() {
        musteri = new MusteriBilgi();
        musteri.setAdres(tfAdres.getText());
        musteri.setAdSoyad(tfAdSoyad.getText());
        musteri.setAldigiUrun(tfAlinanUrun.getText());
        musteri.setFiyat(Double.valueOf(tfFiyat.getText()));
        musteri.setSatan(tfSatan.getText());
        musteri.setTelefon(tfTelefon.getText());

    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnSat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfAdSoyad;
    private javax.swing.JTextField tfAdres;
    private javax.swing.JTextField tfAlinanUrun;
    private javax.swing.JTextField tfFiyat;
    private javax.swing.JTextField tfSatan;
    private javax.swing.JTextField tfTelefon;
    private JTable tablo;
    private Urun urun;
    private float adet;
    private Kullanicilar kisi;
    private MusteriBilgi musteri;

    // End of variables declaration
}
