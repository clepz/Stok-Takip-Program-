package StokProgrami;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.*;

import Database.DBoperations;
import Database.Kullanicilar;
import Database.SatisBilgi;

import javax.swing.*;

public class Bilgilerim extends JPanel{
    public Bilgilerim(Kullanicilar kisi) {
        this.kisi = kisi;
        initComponents();
        tabloBilgiEkle();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - tarik umutlu
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();

        //======== this ========
        setPreferredSize(new Dimension(1200, 635));
        setMinimumSize(new Dimension(1200, 635));
        setBackground(new Color(208, 208, 208));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                null, javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(null);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Tarih", "Sat\u0131lan \u00dcr\u00fcn", "Adet", "Toplam Fiyat"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table1.setFont(new Font("Arial",Font.BOLD,15));
            table1.setRowHeight(20);
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(15, 15, 800, 595);

        //---- label1 ----
        label1.setText("text");
        add(label1);
        label1.setBounds(820, 140, 150, 45);
        label1.setText("Toplam Satış Fiyatı");

        //---- label2 ----
        label2.setText("Kazanılan Komisyon");
        add(label2);
        label2.setBounds(820, 280, 150, 40);

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setForeground(Color.BLACK);
        textField1.setFont(new Font("Arial",1,17));
        add(textField1);
        textField1.setBounds(975, 140, 200, 40);

        //---- label3 ----
        label3.setText("text");
        add(label3);
        label3.setBounds(850, 420, 125, 40);
        label3.setVisible(false);

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setForeground(Color.BLACK);
        textField2.setFont(new Font("Arial",1,17));
        add(textField2);
        textField2.setBounds(975, 280, 200, 40);

        //---- textField3 ----
        textField3.setEditable(false);
        add(textField3);
        textField3.setBounds(975, 420, 200, 40);
        textField3.setVisible(false);

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
        iconPanel2.setIcon(new ImageIcon(getClass().getResource("/panelImage/tarik635.png")));
        add(iconPanel2);
        iconPanel2.setBounds(0,0,1200,635);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void tabloBilgiEkle(){
        DBoperations dBoperations = DBoperations.createDBoperations();
        ArrayList<SatisBilgi> liste = dBoperations.satisBilgiAl(kisi.getKullaniciAdi());
        dBoperations.close();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        while(!liste.isEmpty()) {
            SatisBilgi bilgi = liste.remove(0);
            toplam += bilgi.getToplamFiyat();
            model.addRow(new Object[]{bilgi.getTarih(),bilgi.getUrunAdi(),bilgi.getAdet(),bilgi.getToplamFiyat()});
        }
        textField1.setText(toplam+" TL");
        textField2.setText((toplam/1000) + " TL");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - tarik umutlu
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JTextField textField3;
    private Kullanicilar kisi;
    double toplam;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
