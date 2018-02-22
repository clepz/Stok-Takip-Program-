package StokProgrami;

import Database.DBoperations;
import Database.Kullanicilar;
import Database.Urun;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Thu Dec 07 22:51:32 EET 2017
 */



/**
 * @author tarik umutlu
 */
public class UrunSat extends JPanel{
    private Kullanicilar kisi;

    public UrunSat(JTable tablo, Kullanicilar kisi) {
        this.tablo = tablo;
        this.kisi = kisi;
        initComponents();
    }

    private void btnSatActionPerformed(ActionEvent e) {
        if(tfBarkod.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Lütfen Barkod Numarasını Giriniz.");
            return;
        }
        else if(Float.valueOf(tfAdet.getText()) > Float.valueOf(tfUrunSayisi.getText()) ){
            JOptionPane.showMessageDialog(null,"Stokta Yeterli Miktarda Ürün Bulunmamaktadır.");
            return;
        }
        DBoperations dBoperations = DBoperations.createDBoperations();
        Urun urun = dBoperations.urunBilgiAl(tfBarkod.getText());
        dBoperations.close();
        new SatisBilgiForm(urun,kisi,Float.valueOf(tfAdet.getText()),tablo).setVisible(true);

    }

    private void tfBarkodKeyReleased(KeyEvent e) {
        String numb = tfBarkod.getText();
        Urun urun;
        if(numb.length() <6){
            tfAdet.setEditable(false);
        }
        else if(numb.length() == 6){
            urun  = new Urun();
            DBoperations dBoperations = DBoperations.createDBoperations();
            urun = dBoperations.urunBilgiAl(numb);
            dBoperations.close();
            tfUrunAdi.setText(urun.getUrunAdi());
            tfBarkod.setText(String.valueOf(urun.getBarkod()));
            tfBirim.setText(urun.getBirim());
            tfRafno.setText(urun.getRafNo());
            tfSatisFiyati.setText(String.valueOf(urun.getSatisFiyati()));
            tfStokGrubu.setText(urun.getStokGrubu());
            tfTaneFiyati.setText(String.valueOf(urun.getTaneFiyati()));
            tfToplamFiyat.setText(String.valueOf(urun.getToplamFiyat()));
            tfUrunSayisi.setText(urun.getUrunSayi());

            tfAdet.setEditable(true);
        }
        else if(numb.length() >6){
            tfBarkod.setText("");
            return;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - tarik umutlu
        label1 = new JLabel();
        tfUrunAdi = new JTextField();
        label2 = new JLabel();
        tfUrunSayisi = new JTextField();
        label3 = new JLabel();
        tfBirim = new JTextField();
        label4 = new JLabel();
        tfTaneFiyati = new JTextField();
        label5 = new JLabel();
        tfToplamFiyat = new JTextField();
        label6 = new JLabel();
        tfSatisFiyati = new JTextField();
        label7 = new JLabel();
        tfStokGrubu = new JTextField();
        tfRafno = new JTextField();
        label8 = new JLabel();
        label9 = new JLabel();
        tfAdet = new JTextField();
        btnSat = new JButton();
        label10 = new JLabel();
        tfBarkod = new JTextField();
        Font tfFont = new Font("Arial",Font.BOLD,16);

        tfAdet.setFont(tfFont);
        tfBarkod.setFont(tfFont);
        tfBirim.setFont(tfFont);
        tfRafno.setFont(tfFont);
        tfSatisFiyati.setFont(tfFont);
        tfStokGrubu.setFont(tfFont);
        tfTaneFiyati.setFont(tfFont);
        tfToplamFiyat.setFont(tfFont);
        tfUrunAdi.setFont(tfFont);
        tfUrunSayisi.setFont(tfFont);

        tablo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                DefaultTableModel model = (DefaultTableModel) tablo.getModel();
                int a = tablo.getSelectedRow();

                tfUrunAdi.setText((String) model.getValueAt(a,1));
                tfBarkod.setText(String.valueOf(model.getValueAt(a,0)));
                tfBirim.setText(String.valueOf( model.getValueAt(a,3)));
                tfRafno.setText((String.valueOf(model.getValueAt(a,8))));
                tfSatisFiyati.setText(String.valueOf( model.getValueAt(a,5)));
                tfStokGrubu.setText(String.valueOf(model.getValueAt(a,7)));
                tfTaneFiyati.setText(String.valueOf( model.getValueAt(a,4)));
                tfToplamFiyat.setText(String.valueOf(model.getValueAt(a,6)));
                tfUrunSayisi.setText(String.valueOf(model.getValueAt(a,2)));

                tfAdet.setEditable(true);
            }
        });

        //======== this ========
        setBackground(Color.RED);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                null, javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //---- label1 ----
        label1.setText("\u00dcr\u00fcn Ad\u0131 :");
        add(label1);
        label1.setBounds(10, 15, 110, 30);

        //---- tfUrunAdi ----
        tfUrunAdi.setEditable(false);
        add(tfUrunAdi);
        tfUrunAdi.setBounds(120, 15, 125, 25);

        //---- label2 ----
        label2.setText("\u00dcr\u00fcn Sayisi");
        add(label2);
        label2.setBounds(10, 70, 110, 25);

        //---- tfUrunSayisi ----
        tfUrunSayisi.setEditable(false);
        add(tfUrunSayisi);
        tfUrunSayisi.setBounds(120, 70, 125, 25);

        //---- label3 ----
        label3.setText("Sayinin Birimi :");
        add(label3);
        label3.setBounds(10, 125, 110, label3.getPreferredSize().height);

        //---- tfBirim ----
        tfBirim.setEditable(false);
        add(tfBirim);
        tfBirim.setBounds(120, 125, 125, 25);

        //---- label4 ----
        label4.setText("Tane Fiyat\u0131 :");
        add(label4);
        label4.setBounds(340, 15, 110, 25);

        //---- tfTaneFiyati ----
        tfTaneFiyati.setEditable(false);
        add(tfTaneFiyati);
        tfTaneFiyati.setBounds(450, 15, 125, 25);

        //---- label5 ----
        label5.setText("Toplam Fiyat\u0131 :");
        add(label5);
        label5.setBounds(340, 70, 110, 20);

        //---- tfToplamFiyat ----
        tfToplamFiyat.setEditable(false);
        add(tfToplamFiyat);
        tfToplamFiyat.setBounds(450, 70, 125, 25);

        //---- label6 ----
        label6.setText("Sat\u0131\u015f Fiyat\u0131 :");
        add(label6);
        label6.setBounds(340, 125, 110, 20);

        //---- tfSatisFiyati ----
        tfSatisFiyati.setEditable(false);
        add(tfSatisFiyati);
        tfSatisFiyati.setBounds(450, 125, 125, 25);

        //---- label7 ----
        label7.setText("Stok Grubu :");
        add(label7);
        label7.setBounds(720, 15, 110, 20);

        //---- tfStokGrubu ----
        tfStokGrubu.setEditable(false);
        add(tfStokGrubu);
        tfStokGrubu.setBounds(830, 15, 125, 25);

        //---- tfRafno ----
        tfRafno.setEditable(false);
        add(tfRafno);
        tfRafno.setBounds(830, 70, 125, 25);

        //---- label8 ----
        label8.setText("Raf No :");
        add(label8);
        label8.setBounds(720, 70, 110, 23);

        //---- label9 ----
        label9.setText("Ka\u00e7 Adet : ");
        add(label9);
        label9.setBounds(720, 125, 110, 23);

        //---- tfAdet ----
        tfAdet.setEditable(false);
        add(tfAdet);
        tfAdet.setBounds(830, 125, 125, 25);

        //---- btnSat ----
        btnSat.setText("Sat");
        btnSat.addActionListener(e -> btnSatActionPerformed(e));

        add(btnSat);
        btnSat.setBounds(965, 110, 135, 45);

        //---- label10 ----
        label10.setText("Barkod :");
        add(label10);
        label10.setBounds(990, 15, 95, 30);

        //---- tfBarkod ----
        tfBarkod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                tfBarkodKeyReleased(e);
            }
        });
        add(tfBarkod);
        tfBarkod.setBounds(980, 45, 105, 30);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - tarik umutlu
    private JLabel label1;
    private JTextField tfUrunAdi;
    private JLabel label2;
    private JTextField tfUrunSayisi;
    private JLabel label3;
    private JTextField tfBirim;
    private JLabel label4;
    private JTextField tfTaneFiyati;
    private JLabel label5;
    private JTextField tfToplamFiyat;
    private JLabel label6;
    private JTextField tfSatisFiyati;
    private JLabel label7;
    private JTextField tfStokGrubu;
    private JTextField tfRafno;
    private JLabel label8;
    private JLabel label9;
    private JTextField tfAdet;
    private JButton btnSat;
    private JLabel label10;
    private JTextField tfBarkod;
    private JTable tablo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
