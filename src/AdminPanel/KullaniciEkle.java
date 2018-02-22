package AdminPanel;

import Database.DBoperations;
import Database.Kullanicilar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author clepz
 */
public class KullaniciEkle extends javax.swing.JPanel {

    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JCheckBox cbGoster;
    private javax.swing.JButton btnKayit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField pfParola;
    private javax.swing.JPasswordField pfParola2;
    private javax.swing.JTextField tfAd;
    private javax.swing.JTextField tfKullaniciAdi;
    private javax.swing.JTextField tfSoyad;
    private javax.swing.JTextField tfTelefon;
    private Kullanicilar kisi;

    public KullaniciEkle() {
        initComponents();
    }


    private void initComponents() {
        btnKayit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbGoster = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        kisi = new Kullanicilar();

        tfAd = new javax.swing.JTextField();
        tfKullaniciAdi = new javax.swing.JTextField();
        tfSoyad = new javax.swing.JTextField();
        tfTelefon = new javax.swing.JTextField();
        pfParola = new javax.swing.JPasswordField();
        pfParola2 = new javax.swing.JPasswordField();
        Font labelFont = new Font("Arial",Font.BOLD,16);
        Font tfFont = new Font("Arial", Font.BOLD,16);
        tfAd.setFont(tfFont);
        tfKullaniciAdi.setFont(tfFont);
        tfSoyad.setFont(tfFont);
        tfTelefon.setFont(tfFont);
        pfParola.setFont(tfFont);
        pfParola2.setFont(tfFont);
        setBackground(new java.awt.Color(112, 131, 154));

        btnKayit.setText("KAYDET");
        btnKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if( kontrolEt() )
                    return;
                DBoperations dBoperations = DBoperations.createDBoperations();
                if(dBoperations.kullaniciAra(kisi)){
                    JOptionPane.showMessageDialog(null,"Bu Kullanıcı Adı Bulunmaktadır.");
                    dBoperations.close();
                    return;
                }
                if(dBoperations.kullaniciEkle(kisi))
                    JOptionPane.showMessageDialog(null,"Kayıt Başarıyla Yapılmıştır");
                dBoperations.close();
                removeAll();
                initComponents();

            }
        });
        jLabel1.setText("Kullanıcı Adı : ");
        jLabel1.setFont(labelFont);

        jLabel2.setText("Parola");
        jLabel2.setFont(labelFont);

        cbGoster.setText("Göster");
        cbGoster.setBackground(this.getBackground());
        cbGoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(cbGoster.isSelected()){
                    pfParola.setEchoChar((char) 0);
                    return;
                }
                pfParola.setEchoChar('*');
            }
        });

        jLabel3.setText("Parola(Tekrar)");
        jLabel3.setFont(labelFont);

        jLabel4.setText("Ad :");
        jLabel4.setFont(labelFont);

        jLabel5.setText("Soyad : ");
        jLabel5.setFont(labelFont);

        jLabel6.setText("Telefon :");
        jLabel6.setFont(labelFont);

        jLabel7.setIcon(new javax.swing.ImageIcon("/home/clepz/Pictures/add-user100x100.png"));

        jLabel8.setFont(new java.awt.Font("Arial", 3, 36));
        jLabel8.setText("KULLANICI EKLE");

        jLabel9.setText("Yetki :");
        jLabel9.setFont(labelFont);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kullanıcı", "Yönetici" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pfParola, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbGoster))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pfParola2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(106, 106, 106)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(210, 210, 210)
                                                .addComponent(btnKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfAd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                                .addGap(204, 204, 204))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfKullaniciAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbGoster))
                                        .addComponent(pfParola))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pfParola2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfAd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jComboBox1)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addComponent(btnKayit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
        );
    }

    private boolean kontrolEt() {
        if (kontrolAd()||kontrolKullaniciAdi()||kontrolParola()||kontrolParolaTekrar()||kontrolSoyad()||kontroltelefon()) {
            return true;
        }
        if(jComboBox1.getSelectedItem().equals("Admin"))
            kisi.setYetki(1);
        else if (jComboBox1.getSelectedItem().equals("Kullanıcı")){
        kisi.setYetki(2);
        }
        else
            kisi.setYetki(3);
        return false;
    }



    private boolean kontrolKullaniciAdi(){
        if(tfKullaniciAdi.getText().length() <5){
            JOptionPane.showMessageDialog(null,"Daha uzun Kullanıcı Adı Giriniz.");
            return true;
        }
        kisi.setKullaniciAdi(tfKullaniciAdi.getText());
        return false;
    }private boolean kontrolParola(){
        if(pfParola.getText().length()<7){
            JOptionPane.showMessageDialog(null,"Parola En Az 7 Karakter Olmalıdır.");
            return true;
        }
        return false;

    }private boolean kontrolParolaTekrar(){
        if(!pfParola.getText().equals(pfParola2.getText())){
            JOptionPane.showMessageDialog(null,"Parolalar Uyuşmuyor.");
            return true;
        }
        kisi.setParola(pfParola.getText());
        return false;

    }private boolean kontrolAd(){
        if(tfAd.getText().length() < 3 ){
            JOptionPane.showMessageDialog(null,"Lütfen Geçerli Bir Ad Giriniz.");
            return true;
        }
        kisi.setAd(tfAd.getText());
        return false;

    }private boolean kontrolSoyad(){
        if(tfSoyad.getText().length() < 3 ){
            JOptionPane.showMessageDialog(null,"Lütfen Geçerli Bir Soyad Giriniz.");
            return true;
        }
        kisi.setSoyad(tfSoyad.getText());
        return false;

    }private boolean kontroltelefon(){
        if(tfTelefon.getText().length() < 10 || tfTelefon.getText().length() > 11 ){
            JOptionPane.showMessageDialog(null,"Lütfen Geçerli Bir Telefon Giriniz.");
            return true;
        }
        kisi.setTelefon(tfTelefon.getText());
        return false;
    }


}
