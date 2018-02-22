package AdminPanel;

import Database.DBoperations;
import Database.Kullanicilar;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


/**
 *
 * @author clepz
 */
public class kullaniciListe extends javax.swing.JPanel {

    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;

    public kullaniciListe() {
        initComponents();
        this.listele();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jPanel1.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 600));
        jPanel1.setLayout(null);

        jLabel3.setText("jLabel1");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 330, 49, 18);

        jLabel4.setText("jLabel2");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(650, 300, 49, 18);

        jButton3.setText("jButton1");
        jPanel1.add(jButton3);
        jButton3.setBounds(620, 570, 74, 32);

        jButton4.setText("jButton2");
        jPanel1.add(jButton4);
        jButton4.setBounds(0, 0, 74, 32);

        setMinimumSize(new java.awt.Dimension(400, 300));
        setPreferredSize(new java.awt.Dimension(700, 600));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Kullanıcı Adı", "Parola", "yetki","Ad","Soyad","Telefon"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false,false,false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
            jTable2.getColumnModel().getColumn(5).setResizable(false);
            jTable2.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }

    private void listele(){
        DBoperations dBoperations = DBoperations.createDBoperations();
        ArrayList<Kullanicilar> liste = dBoperations.kullaniciVeriAl();
        dBoperations.close();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        while(!liste.isEmpty()){
            Kullanicilar kisi = liste.remove(0);
            model.addRow(new Object[]{kisi.getId(),kisi.getKullaniciAdi(),kisi.getParola(),kisi.getYetki(),kisi.getAd(),kisi.getSoyad(),kisi.getTelefon()});
        }
    }


}
