package StokProgrami;

import Database.DBoperations;
import Database.Urun;
import com.sun.imageio.plugins.jpeg.JPEGImageMetadataFormatResources;
import jdk.nashorn.internal.scripts.JO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Thu Dec 07 21:22:01 EET 2017
 */



/**
 * @author tarik umutlu
 */
public class UrunEkle extends JPanel {

    public UrunEkle(JTable tablo) {
        initComponents();
        this.tablo = tablo;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - tarik umutlu
        lbUrunAdi = new JLabel();
        tfUrunAdi = new JTextField();
        lbUrunSayi = new JLabel();
        tfUrunSayi = new JTextField();
        lbBirim = new JLabel();
        tfBirim = new JTextField();
        lbTaneFiyat = new JLabel();
        tfTaneFiyati = new JTextField();
        lbToplamFiyat = new JLabel();
        tfToplamFiyat = new JTextField();
        lbSatisFiyati = new JLabel();
        tfSatisFiyati = new JTextField();
        lbStokGrubu = new JLabel();
        tfStokGrub = new JTextField();
        btnEkle = new JButton();
        tfRafNo = new JTextField();
        lbRafno = new JLabel();
        lbBarkod = new JLabel();
        tfBarkod = new JTextField();
        tfkisi = new JTextField();
        lbkisi = new JLabel();

        //======== this ========


        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                null, javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //---- lbUrunAdi ----
        lbUrunAdi.setText("\u00dcr\u00fcn Ad\u0131 :");
        add(lbUrunAdi);
        lbUrunAdi.setBounds(10, 15, 110, 30);
        add(tfUrunAdi);
        tfUrunAdi.setBounds(120, 15, 125, 25);

        //---- lbUrunSayi ----
        lbUrunSayi.setText("\u00dcr\u00fcn Sayisi");
        add(lbUrunSayi);
        lbUrunSayi.setBounds(10, 70, 110, 25);
        add(tfUrunSayi);
        tfUrunSayi.setBounds(120, 70, 125, 25);

        //---- lbBirim ----
        lbBirim.setText("Sayinin Birimi :");
        add(lbBirim);
        lbBirim.setBounds(10, 125, 110, lbBirim.getPreferredSize().height);
        add(tfBirim);
        tfBirim.setBounds(120, 125, 125, 25);

        //---- lbTaneFiyat ----
        lbTaneFiyat.setText("Tane Fiyat\u0131 :");
        add(lbTaneFiyat);
        lbTaneFiyat.setBounds(340, 15, 110, 25);
        add(tfTaneFiyati);
        tfTaneFiyati.setBounds(450, 15, 125, 25);

        //---- lbToplamFiyat ----
        lbToplamFiyat.setText("Toplam Fiyat\u0131 :");
        add(lbToplamFiyat);
        lbToplamFiyat.setBounds(340, 70, 110, 20);
        add(tfToplamFiyat);
        tfToplamFiyat.setEditable(false);
        tfToplamFiyat.setBounds(450, 70, 125, 25);

        //---- lbSatisFiyati ----
        lbSatisFiyati.setText("Sat\u0131\u015f Fiyat\u0131 :");
        add(lbSatisFiyati);
        lbSatisFiyati.setBounds(340, 125, 110, 20);
        add(tfSatisFiyati);
        tfSatisFiyati.setBounds(450, 125, 125, 25);

        //---- lbStokGrubu ----
        lbStokGrubu.setText("Stok Grubu :");
        add(lbStokGrubu);
        lbStokGrubu.setBounds(720, 15, 110, 20);
        add(tfStokGrub);
        tfStokGrub.setBounds(830, 15, 125, 25);

        //---- btnEkle ----
        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Urun urun = new Urun();
                if(urunTekrarEkle(tfBarkod.getText())){
                    return;
                }
                try {
                    urun.setBarkod(Integer.parseInt(tfBarkod.getText()));
                    urun.setBirim(tfBirim.getText());
                    urun.setRafNo(tfRafNo.getText());
                    urun.setSatisFiyati(Float.parseFloat(tfSatisFiyati.getText()));
                    urun.setStokGrubu(tfStokGrub.getText());
                    urun.setUrunSayi(tfUrunSayi.getText());
                    urun.setTaneFiyati(Float.parseFloat(tfTaneFiyati.getText()));
                    double toplamfiyat = (double) urun.getSatisFiyati() * Double.valueOf(urun.getUrunSayi());
                    urun.setToplamFiyat(toplamfiyat);
                    urun.setUrunAdi(tfUrunAdi.getText());
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Lütfen Girdiğiniz Sayilari Kontrol Ediniz.");
                    return;
                }
                if(urunKontrol(urun)) {
                    DBoperations dBoperations = DBoperations.createDBoperations();
                    if (dBoperations.urunEkle(urun,tfkisi.getText())) {
                        ArrayList<Urun> liste = dBoperations.urunListele();
                        dBoperations.close();
                        DefaultTableModel model = (DefaultTableModel) tablo.getModel();
                        model.getDataVector().removeAllElements();
                        tablo.revalidate();
                        tablo.repaint();
                        while (!liste.isEmpty()) {
                            Urun urunler = liste.remove(0);
                            model.addRow(new Object[]{urunler.getBarkod(), urunler.getUrunAdi(), urunler.getUrunSayi(), urunler.getBirim(), urunler.getTaneFiyati() + "TL", urunler.getSatisFiyati() + "TL",
                                    urunler.getToplamFiyat() + "TL", urunler.getStokGrubu(), urunler.getRafNo()});
                        }
                        JOptionPane.showMessageDialog(null,"Ekleme Başarılı");
                        return;
                    }
                }

                JOptionPane.showMessageDialog(null,"Kayit Yapilamamistir.");

            }
        });
        add(btnEkle);
        btnEkle.setBounds(970, 115, 115, 45);
        add(tfRafNo);
        tfRafNo.setBounds(830, 70, 125, 25);

        //---- lbRafno ----
        lbRafno.setText("Raf No :");
        add(lbRafno);
        lbRafno.setBounds(720, 70, 110, 23);

        //---- lbBarkod ----
        lbBarkod.setText("Barkod:");
        add(lbBarkod);
        lbBarkod.setBounds(720, 125, 90, 20);
        add(tfBarkod);
        tfBarkod.setBounds(830, 125, 125, 25);

        //----- kisi ------
        lbkisi.setText("Satın Alınan Yer/Kişi");
        add(lbkisi);
        lbkisi.setBounds(970,45,160,25);
        add(tfkisi);
        tfkisi.setBounds(970,70,125,25);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }

        JLabel iconPanel2 = new JLabel();
        iconPanel2.setIcon(new ImageIcon(getClass().getResource("/panelImage/tarik160.png")));
        this.add(iconPanel2);
        iconPanel2.setBounds(0,0,1130,175);
        setBackground(null);
    }

    private boolean urunTekrarEkle(String barkod) {
        DBoperations dBoperations = DBoperations.createDBoperations();
        if(dBoperations.urunVarmi(barkod)){

            return true;
        }
        return false;
    }


    private boolean urunKontrol(Urun urun) {
        if(urun.getBarkod()<900000){
            JOptionPane.showMessageDialog(null,"Barkodu Doğru Giriniz.");
            return false;
        }
        if(tfkisi.getText().equals(null)){
            JOptionPane.showMessageDialog(null,"Alınan Yer/Kişi Boş Geçilemez.");
            return false;
        }
        return true;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - tarik umutlu
    private JLabel lbUrunAdi;
    private JTextField tfUrunAdi;
    private JLabel lbUrunSayi;
    private JTextField tfUrunSayi;
    private JLabel lbBirim;
    private JTextField tfBirim;
    private JLabel lbTaneFiyat;
    private JTextField tfTaneFiyati;
    private JLabel lbToplamFiyat;
    private JTextField tfToplamFiyat;
    private JLabel lbSatisFiyati;
    private JTextField tfSatisFiyati;
    private JLabel lbStokGrubu;
    private JTextField tfStokGrub;
    private JButton btnEkle;
    private JTextField tfRafNo;
    private JLabel lbRafno;
    private JLabel lbBarkod;
    private JTextField tfBarkod;
    private JTable tablo;
    private JTextField tfkisi;
    private JLabel lbkisi;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
