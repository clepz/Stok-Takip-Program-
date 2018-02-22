package AdminPanel;/*


import Database.DBoperations;
import Database.Kullanicilar;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 *
 * @author clepz
 */

import Database.DBoperations;
import Database.Kullanicilar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class KullaniciGuncelle extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form AdminPanel.KullaniciGuncelle
     */
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private JComboBox<String> jComboBox1;
    private JTextField jTextField6;


    public KullaniciGuncelle() {
        initComponents();
        this.listele();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new JTextField();
        btnGuncelle = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new JComboBox<>();
        Font labelFont = new Font("Arial",Font.BOLD,16);
        Font tfFont = new Font("Arial", Font.BOLD,16);
        jLabel1.setFont(labelFont);
        jLabel2.setFont(labelFont);
        jLabel4.setFont(labelFont);
        jLabel5.setFont(labelFont);
        jLabel6.setFont(labelFont);
        jLabel7.setFont(labelFont);
        jLabel8.setFont(labelFont);
        jTextField1.setFont(tfFont);
        jTextField2.setFont(tfFont);
        jTextField3.setFont(tfFont);
        jTextField4.setFont(tfFont);
        jTextField5.setFont(tfFont);
        jTextField6.setVisible(false);



        setBackground(new java.awt.Color(112, 131, 154));
        setPreferredSize(new java.awt.Dimension(680, 570));
        setLayout(null);

        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(850, 130, 49, 18);

        jLabel2.setIcon(new javax.swing.ImageIcon("/home/clepz/Pictures/Refresh.png")); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(30, 30, 100, 100);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel3.setText("KULLANICI GÜNCELLE");
        add(jLabel3);
        jLabel3.setBounds(190, 30, 440, 100);

        jComboBox1.setBounds(510,400,125,30);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kullanıcı" , "Yönetici" }));
        add(jComboBox1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Kullanıcı Adı", "Parola", "yetki","Ad","Soyad","Telefon"
                }


        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false,false,false
        };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getColumn("ID").setPreferredWidth(10);

        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                int secili = jTable1.getSelectedRow();
                TableModel model = jTable1.getModel();
                jTextField3.setText(model.getValueAt(secili,2).toString());
                jTextField2.setText(model.getValueAt(secili,5).toString());
                if(model.getValueAt(secili,3).toString().equals("Admin"))
                    jComboBox1.setSelectedIndex(0);
                else if(model.getValueAt(secili,3).toString().equals("Kullanıcı"))
                    jComboBox1.setSelectedIndex(1);
                else
                    jComboBox1.setSelectedIndex(2);
                jTextField4.setText(model.getValueAt(secili,1).toString());
                jTextField5.setText(model.getValueAt(secili,6).toString());
                jTextField1.setText(model.getValueAt(secili,4).toString());
                jTextField6.setText(model.getValueAt(secili,0).toString());
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(40, 140, 600, 190);
        add(jTextField1);
        jTextField1.setBounds(40, 400, 125, 30);
        add(jTextField2);
        jTextField2.setBounds(190, 400, 125, 30);
        add(jTextField3);
        jTextField3.setBounds(190, 500, 125, 30);
        add(jTextField4);
        jTextField4.setBounds(40, 500, 125, 30);
        add(jTextField5);
        jTextField5.setBounds(350, 400, 125, 30);

        btnGuncelle.setText("Güncelle");
        add(btnGuncelle);
        btnGuncelle.setBounds(370, 470, 160, 60);
        btnGuncelle.addActionListener(this);

        jLabel4.setText("Adı");
        add(jLabel4);
        jLabel4.setBounds(60, 370, 100, 18);

        jLabel5.setText("Soyadı");
        add(jLabel5);
        jLabel5.setBounds(210, 370, 100, 18);

        jLabel6.setText("Telefonu");
        add(jLabel6);
        jLabel6.setBounds(360, 370, 100, 18);

        jLabel7.setText("Kullanıcı Adı");
        add(jLabel7);
        jLabel7.setBounds(50, 470, 100, 18);

        jLabel8.setText("Parolası");
        add(jLabel8);
        jLabel8.setBounds(200, 470, 100, 18);

        getAccessibleContext().setAccessibleParent(this);
    }

    private void listele(){
        DBoperations dBoperations = DBoperations.createDBoperations();
        ArrayList<Kullanicilar> liste = dBoperations.kullaniciVeriAl();
        dBoperations.close();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        int i = 0;
        while(!liste.isEmpty()){
            Kullanicilar kisi = liste.remove(0);
            model.addRow(new Object[]{kisi.getId(),kisi.getKullaniciAdi(),kisi.getParola(),kisi.getYetki(),kisi.getAd(),kisi.getSoyad(),kisi.getTelefon()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == btnGuncelle){
            Kullanicilar kisi = new Kullanicilar();
            kisi.setId(Integer.valueOf(jTextField6.getText()));
            kisi.setYetki(jComboBox1.getSelectedIndex()+1);
            kisi.setKullaniciAdi(jTextField4.getText());
            kisi.setParola(jTextField3.getText());
            kisi.setAd(jTextField1.getText());
            kisi.setSoyad(jTextField2.getText());
            kisi.setTelefon(jTextField5.getText());
            DBoperations dBoperations = DBoperations.createDBoperations();
            if(dBoperations.kullaniciGuncelle(kisi)){
                dBoperations.close();

                JOptionPane.showMessageDialog(null,"Güncelleme Başarıyla Tamamlandı.");
                return;
            }
            JOptionPane.showMessageDialog(null,"İşlem Başarısız.");
        }
    }
}
