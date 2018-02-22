package StokProgrami;

import Database.DBoperations;
import Database.Urun;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Thu Dec 07 22:56:34 EET 2017
 */



/**
 * @author tarik umutlu
 */
public class UrunGuncelle extends JPanel {
    public UrunGuncelle(JTable tablo) {
        this.tablo = tablo;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - tarik umutlu
        label1 = new JLabel();
        tfUrunAdi = new JTextField();
        label2 = new JLabel();
        tfUrunSayi = new JTextField();
        label3 = new JLabel();
        tfBirim = new JTextField();
        label4 = new JLabel();
        tfTaneFiyati = new JTextField();
        label5 = new JLabel();
        tfToplamFiyati = new JTextField();
        label6 = new JLabel();
        tfSatisFiyati = new JTextField();
        label7 = new JLabel();
        tfStokGrubu = new JTextField();
        btnGuncelle = new JButton();
        tfRafno = new JTextField();
        label8 = new JLabel();
        label9 = new JLabel();
        tfBarkod = new JTextField();
        btnSil = new JButton();

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
                tfToplamFiyati.setText(String.valueOf(model.getValueAt(a,6)));
                tfUrunSayi.setText(String.valueOf(model.getValueAt(a,2)));

                setEditableAll(true);
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

        //---- tfUrunSayi ----
        tfUrunSayi.setEditable(false);
        add(tfUrunSayi);
        tfUrunSayi.setBounds(120, 70, 125, 25);

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

        //---- tfToplamFiyati ----
        tfToplamFiyati.setEditable(false);
        add(tfToplamFiyati);
        tfToplamFiyati.setBounds(450, 70, 125, 25);

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

        //---- btnGuncelle ----
        btnGuncelle.setText("G\u00fcncelle");
        add(btnGuncelle);
        btnGuncelle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnGuncelleIslemler();
            }
        });
        btnGuncelle.setBounds(825, 110, 135, 45);

        //---- tfRafno ----
        tfRafno.setEditable(false);
        add(tfRafno);
        tfRafno.setBounds(830, 70, 125, 25);

        //---- label8 ----
        label8.setText("Raf No :");
        add(label8);
        label8.setBounds(720, 70, 110, 23);

        //---- label9 ----
        label9.setText("Barkod:");
        add(label9);
        label9.setBounds(1010, 30, 90, 25);

        //-----tfBarkod----
        add(tfBarkod);
        tfBarkod.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                String numb = tfBarkod.getText();
                Urun urun;
                if(numb.length() <6){
                   setEditableAll(false);
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
                    tfToplamFiyati.setText(String.valueOf(urun.getToplamFiyat()));
                    tfUrunSayi.setText(urun.getUrunSayi());

                    setEditableAll(true);
                }
                else if(numb.length() >6){
                    tfBarkod.setText("");
                    return;
                }
            }
        });
        tfBarkod.setBounds(985, 60, 125, 25);

        //---- button1 ----
        btnSil.setText("Ürünü Sil");
        btnSil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSilİslemler();
            }
        });
        add(btnSil);
        btnSil.setBounds(985, 110, 130, 45);

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

    private void btnGuncelleIslemler() {
        String barkod = tfBarkod.getText();
        DBoperations dBoperations = DBoperations.createDBoperations();
        Urun urun = dBoperations.urunBilgiAl(barkod);
        urun.setBirim(tfBirim.getText());
        urun.setRafNo(tfRafno.getText());
        urun.setSatisFiyati(Float.parseFloat(tfSatisFiyati.getText().replace("TL","")));
        urun.setStokGrubu(tfStokGrubu.getText());
        urun.setUrunSayi(tfUrunSayi.getText());
        urun.setTaneFiyati(Float.parseFloat(tfTaneFiyati.getText().replace("TL","")));
        double toplamfiyat = (double) urun.getSatisFiyati() * Double.valueOf(urun.getUrunSayi());
        urun.setToplamFiyat(toplamfiyat);
        urun.setUrunAdi(tfUrunAdi.getText());
        if(dBoperations.urunGuncelle(urun)){
            JOptionPane.showMessageDialog(null,"İşlem Başarılı.");
            setTextEmpty();
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

    private void btnSilİslemler() {
        DBoperations dBoperations = DBoperations.createDBoperations();
        if(dBoperations.urunSil(tfBarkod.getText())){
            JOptionPane.showMessageDialog(null,"Silme İşlemi Başarılı");
            setEditableAll(false);
            setTextEmpty();
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

    private void setTextEmpty(){
        tfUrunAdi.setText(null);
        tfBarkod.setText(null);
        tfBirim.setText(null);
        tfRafno.setText(null);
        tfSatisFiyati.setText(null);
        tfStokGrubu.setText(null);
        tfTaneFiyati.setText(null);
        tfToplamFiyati.setText(null);
        tfUrunSayi.setText(null);
    }

    private void setEditableAll(boolean b) {
        tfUrunAdi.setEditable(b);
        tfBirim.setEditable(b);
        tfRafno.setEditable(b);
        tfSatisFiyati.setEditable(b);
        tfStokGrubu.setEditable(b);
        tfTaneFiyati.setEditable(b);
        tfToplamFiyati.setEditable(b);
        tfUrunSayi.setEditable(b);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - tarik umutlu
    private JLabel label1;
    private JTextField tfUrunAdi;
    private JLabel label2;
    private JTextField tfUrunSayi;
    private JLabel label3;
    private JTextField tfBirim;
    private JLabel label4;
    private JTextField tfTaneFiyati;
    private JLabel label5;
    private JTextField tfToplamFiyati;
    private JLabel label6;
    private JTextField tfSatisFiyati;
    private JLabel label7;
    private JTextField tfStokGrubu;
    private JButton btnGuncelle;
    private JTextField tfRafno;
    private JLabel label8;
    private JLabel label9;
    private JTextField tfBarkod;
    private JButton btnSil;
    private JTable tablo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
