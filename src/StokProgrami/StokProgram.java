package StokProgrami;

import Database.DBoperations;
import Database.Kullanicilar;
import Database.Urun;
import main.UserConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
/*
 * Created by JFormDesigner on Thu Dec 07 20:28:11 EET 2017
 */



/**
 * @author unknown
 */
public class StokProgram extends JFrame{
    public StokProgram(Kullanicilar kisi) {
        this.kisi = kisi;
        initComponents();
        if(kisi.getYetki().equals("Kullanıcı")){
            btnUrunEkle.setEnabled(false);
            btnUrunGuncelle.setEnabled(false);
            btnMusteriListe.setEnabled(false);
            btnAanaliz.setEnabled(false);
        }
        btnUrunListe.doClick();
    }

    private void btnUrunSatActionPerformed(ActionEvent e) {
        UrunSat sat = new UrunSat(this.tbUrunListe,kisi);
        sat.setBounds(0,0,1200,170);
        panel4.removeAll();
        panel4.add(sat);
        panel4.revalidate();
        panel4.repaint();
    }

    private void btnUrunEkleActionPerformed(ActionEvent e) {
        UrunEkle ekle = new UrunEkle(this.tbUrunListe);
        ekle.setBounds(0,0,1300,170);
        panel4.removeAll();
        panel4.add(ekle);
        panel4.revalidate();
        panel4.repaint();
    }

    private void btnUrunGuncelleActionPerformed(ActionEvent e) {
        UrunGuncelle guncelle = new UrunGuncelle(this.tbUrunListe);
        guncelle.setBounds(0,0,1200,170);
        panel4.removeAll();
        panel4.add(guncelle);
        panel4.revalidate();
        panel4.repaint();
    }

    private void btnUrunListeActionPerformed(ActionEvent e) {
        DBoperations dBoperations = DBoperations.createDBoperations();
        ArrayList<Urun> liste =  dBoperations.urunListele();
        dBoperations.close();
        DefaultTableModel model = (DefaultTableModel) tbUrunListe.getModel();
        model.getDataVector().removeAllElements();
        tbUrunListe.revalidate();
        tbUrunListe.repaint();
        panel2.removeAll();
        JLabel iconPanel2 = new JLabel();
        iconPanel2.setIcon(new ImageIcon(getClass().getResource("/panelImage/tarik635.png")));
        panel2.add(iconPanel2);
        iconPanel2.setBounds(0,0,1200,635);
        panel2.add(scrollPane1);
        panel2.add(panel3);
        panel4.removeAll();
        panel2.add(panel4);
        panel2.revalidate();
        panel2.repaint();
        while(!liste.isEmpty()) {
            Urun urun = liste.remove(0);
            model.addRow(new Object[]{urun.getBarkod(),urun.getUrunAdi(),urun.getUrunSayi(),urun.getBirim(),urun.getTaneFiyati()+"TL",urun.getSatisFiyati()+"TL",
                    urun.getToplamFiyat()+"TL",urun.getStokGrubu(),urun.getRafNo()});
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - tarik umutlu
        panel1 = new JPanel();
        label1 = new JLabel();
        hSpacer1 = new JPanel(null);
        btnUrunListe = new JButton();
        btnMusteriListe = new JButton();
        btnAanaliz = new JButton();
        btnBilgilerim = new JButton();
        btnCikis = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        tbUrunListe = new JTable();
        panel3 = new JPanel();
        btnUrunEkle = new JButton();
        btnUrunSat = new JButton();
        btnUrunGuncelle = new JButton();
        panel4 = new JPanel();

        //======== this ========
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stok Takip Programı - Kullanıcı : " + kisi.getKullaniciAdi());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(19, 86, 131));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                   null, javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 15));

            //---- label1 ----
            label1.setPreferredSize(new Dimension(140, 100));
            label1.setIcon(new ImageIcon("/home/clepz/Pictures/rsz_1menu.png"));
            panel1.add(label1);

            //---- hSpacer1 ----
            hSpacer1.setBackground(null);
            hSpacer1.setForeground(null);
            panel1.add(hSpacer1);

            //---- btnUrunListe ----
            btnUrunListe.setPreferredSize(new Dimension(120, 100));
            btnUrunListe.addActionListener(e -> btnUrunListeActionPerformed(e));
            panel1.add(btnUrunListe);

            //---- btnMusteriListe ----
            btnMusteriListe.setPreferredSize(new Dimension(120, 100));
            btnMusteriListe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    btnMusteriListeIslemler();
                }
            });
            panel1.add(btnMusteriListe);

            //---- btnAanaliz ----
            btnAanaliz.setPreferredSize(new Dimension(120, 100));
            btnAanaliz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    btnAnalizIslemler();
                }
            });
            panel1.add(btnAanaliz);

            //---- btnBilgilerim ----
            btnBilgilerim.setPreferredSize(new Dimension(120, 100));
            btnBilgilerim.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    btnBilgilerimIslemler();
                }
            });
            panel1.add(btnBilgilerim);

            //---- btnCikis ----
            btnCikis.setPreferredSize(new Dimension(120, 100));
            btnCikis.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    btnCikisIslemleri();
                }
            });
            panel1.add(btnCikis);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 1200, 140);

        //======== panel2 ========
        {
            panel2.setForeground(new Color(86, 92, 114));
            panel2.setBackground(new Color(86, 92, 114));
            panel2.setLayout(null);

            //======== scrollPane1 ========
            {
                scrollPane1.setBackground(new Color(102, 102, 102));
                scrollPane1.setForeground(new Color(102, 102, 102));

                //---- tbUrunListe ----
                tbUrunListe.setRowHeight(25);
                tbUrunListe.setRowMargin(3);
                tbUrunListe.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "Barkod", "\u00dcr\u00fcn Ad\u0131", "Stok Say\u0131s\u0131", "Birim", "Tane Alış Fiyat\u0131", "Sat\u0131\u015f Fiyat\u0131", "Toplam Satış Fiyatı", "Stok Grubu", "Raf No."
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                {
                    TableColumnModel cm = tbUrunListe.getColumnModel();
                    cm.getColumn(0).setResizable(false);
                }
                tbUrunListe.setBackground(new Color(204, 204, 204));
                tbUrunListe.setForeground(new Color(51, 51, 51));
                tbUrunListe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                tbUrunListe.setFont(new Font("Arial",Font.BOLD,15));
                scrollPane1.setViewportView(tbUrunListe);
            }

            scrollPane1.setBounds(25, 240, 1150, 375);

            //======== panel3 ========
            {
                panel3.setBorder(null);
                panel3.setBackground(new Color(86, 92, 114));
                panel3.setForeground(new Color(86, 92, 114));
                panel3.setLayout(new GridLayout(1, 3, 60, 20));



                //---- btnUrunEkle ----
                btnUrunEkle.addActionListener(e -> btnUrunEkleActionPerformed(e));
                panel3.add(btnUrunEkle);

                //---- btnUrunSat ----
                btnUrunSat.addActionListener(e -> btnUrunSatActionPerformed(e));
                panel3.add(btnUrunSat);

                //---- btnUrunGuncelle ----
                btnUrunGuncelle.setToolTipText("Tablodan G\u00fcncellemek \u0130stedi\u011finiz \u00dcr\u00fcn\u00fc Se\u00e7iniz.");
                btnUrunGuncelle.addActionListener(e -> btnUrunGuncelleActionPerformed(e));
                panel3.add(btnUrunGuncelle);
            }

            panel3.setBounds(10, 10, 1175, 35);

            //======== panel4 ========
            {
                panel4.setBackground(null);
                panel4.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            panel2.add(panel4);
            panel4.setBounds(25, 55, 1140, 175);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2);
        panel2.setBounds(0, 140, 1200, 635);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }

        panel1.setBackground(new Color(29,96,102));
        panel2.setBackground(new Color(208,208,209));
        panel3.setBackground(null);

        btnAanaliz.setIcon(new ImageIcon(getClass().getResource("/panelImage/analiz.png")));
        btnAanaliz.setBackground(null);
        btnAanaliz.setBorder(null);
        btnMusteriListe.setIcon(new ImageIcon(getClass().getResource("/panelImage/musterilistesi.png")));
        btnMusteriListe.setBackground(null);
        btnMusteriListe.setBorder(null);
        btnCikis.setIcon(new ImageIcon(getClass().getResource("/panelImage/cikis.png")));
        btnCikis.setBackground(null);
        btnCikis.setBorder(null);
        btnBilgilerim.setIcon(new ImageIcon(getClass().getResource("/panelImage/bilgilerim.png")));
        btnBilgilerim.setBackground(null);
        btnBilgilerim.setBorder(null);
        btnUrunListe.setIcon(new ImageIcon(getClass().getResource("/panelImage/urunliste.png")));
        btnUrunListe.setBackground(null);
        btnUrunListe.setBorder(null);
        btnUrunGuncelle.setIcon(new ImageIcon(getClass().getResource("/panelImage/urunguncelle.png")));
        btnUrunGuncelle.setBackground(null);
        btnUrunEkle.setIcon(new ImageIcon(getClass().getResource("/panelImage/urunekle.png")));
        btnUrunEkle.setBackground(null);
        btnUrunSat.setIcon(new ImageIcon(getClass().getResource("/panelImage/urunsat.png")));
        btnUrunSat.setBackground(null);

        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void btnAnalizIslemler(){
        panel2.removeAll();
        Analiz analiz = new Analiz();
        analiz.setBounds(0,0,1200,635);
        panel2.add(analiz);
        panel2.revalidate();
        panel2.repaint();
    }


    private void btnMusteriListeIslemler(){
        panel2.removeAll();
        MusteriListe liste = new MusteriListe();
        liste.setBounds(0,0,1200,635);
        panel2.add(liste);
        panel2.revalidate();
        panel2.repaint();
    }

    private void btnBilgilerimIslemler() {
        panel2.removeAll();
        Bilgilerim bilgilerim = new Bilgilerim(kisi);
        bilgilerim.setBounds(0,0,1200,635);
        panel2.add(bilgilerim);
        panel2.revalidate();
        panel2.repaint();
    }

    private void btnCikisIslemleri(){
        new UserConnection().setVisible(true);
        this.dispose();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - tarik umutlu
    private JPanel panel1;
    private JLabel label1;
    private JPanel hSpacer1;
    private JButton btnUrunListe;
    private JButton btnMusteriListe;
    private JButton btnAanaliz;
    private JButton btnBilgilerim;
    private JButton btnCikis;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable tbUrunListe;
    private JPanel panel3;
    private JButton btnUrunEkle;
    private JButton btnUrunSat;
    private JButton btnUrunGuncelle;
    private JPanel panel4;
    private Kullanicilar kisi;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
