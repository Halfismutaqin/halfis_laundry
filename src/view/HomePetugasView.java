package view;

import controller.HomePetugasController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.HomePetugasModel;
import model.Koneksi;
import model.Pelanggan;

public class HomePetugasView extends javax.swing.JFrame {

    /**
     * Membuat From Transaksi Untuk Petugas
     */
    private Connection con;
    Koneksi conn;
      
    public HomePetugasView() {
        conn = new Koneksi();
        conn.connect();        
        
        initComponents();
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        labelIdCust.setVisible(false);
        
        radioLk.setActionCommand("Laki - Laki");
        radioPr.setActionCommand("Perempuan");
        
        bgJK = new ButtonGroup();
        bgJK.add(radioLk);
        bgJK.add(radioPr);
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JLabel getLabelHi() {
        return labelHi;
    }

    public void setLabelHi(String labelHi) {
        this.labelHi.setText("Hi, " + labelHi);
    }
    
    public ButtonGroup getBgJK() {
        return bgJK;
    }

    public JButton getBtnHitung() {
        return btnHitung;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public JButton getBtnTambah() {
        return btnTambah;
    }

    public JComboBox<String> getCbBayar() {
        return cbBayar;
    }

    public JComboBox<String> getCbLayanan() {
        return cbLayanan;
    }

    public JRadioButton getRadioLk() {
        return radioLk;
    }

    public JRadioButton getRadioPr() {
        return radioPr;
    }

    public String getTfAlamat() {
        return tfAlamat.getText();
    }

    public void setLabelTanggal(String labelTanggal) {
        this.labelTanggal.setText(labelTanggal);
    }

    public JTable getTableTransaksi() {
        return tableTransaksi;
    }

    public String getTfBerat() {
        return tfBerat.getText();
    }

    public String getTfNama() {
        return tfNama.getText();
    }

    public String getTfNoHp() {
        return tfNoHp.getText();
    }

    public double getTfTotal() {
        return Double.parseDouble(tfTotal.getText());
    }

    public void setTfAlamat(String tfAlamat) {
        this.tfAlamat.setText(tfAlamat);
    }

    public void setTfNama(String tfNama) {
        this.tfNama.setText(tfNama);
    }

    public void setTfNoHp(String tfNoHp) {
        this.tfNoHp.setText(tfNoHp);
    }

    public void setTfTotal(String tfTotal) {
        this.tfTotal.setText(tfTotal);
    }
    
    public void setTfBerat(String tfBerat) {
        this.tfBerat.setText(tfBerat);
    }

    public String getLabelIdCust() {
        return labelIdCust.getText();
    }

    public void setLabelIdCust(String labelIdCust) {
        this.labelIdCust.setText(labelIdCust);
    }

    public JComboBox<String> getComboCari() {
        return comboCari;
    }
    
    public String gettfCariPelanggan() {
        return tfCariPelanggan.getText();
    }
    
    public void addActionListener(HomePetugasController a){
        btnHitung.addActionListener(a);
        btnTambah.addActionListener(a);
        btnReset.addActionListener(a);
        btnLogout.addActionListener(a);
        btnUpdate.addActionListener(a);
        btnCariPelanggan.addActionListener(a);
        btnRefresh.addActionListener(a);
    } 

    public JButton getBtnCariPelanggan() {
        return btnCariPelanggan;
    }
    
    public JButton getBtnUdpate() {
        return btnUpdate;
    }    
    
    public JButton getBtnRefresh() {
        return btnRefresh;
    }    

    public String getTfCari() {
        return tfCari.getText();
    }
    
    public int getLastID() {
        con = conn.getKoneksi();
        ResultSet rs;
        try {
            String query = "SELECT COUNT(no_transaksi) AS lastID FROM tb_transaksi";
            Statement s = con.createStatement();
            rs = s.executeQuery(query);
            if (rs.next())
                return rs.getInt("lastID");
        } catch (SQLException ex) {
            Logger.getLogger(HomePetugasModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }
    
    public int getLastIdCust() {
        con = conn.getKoneksi();
        ResultSet rs;
        try {
            String query = "SELECT COUNT(id_cust) AS lastID FROM tb_customer";
            Statement s = con.createStatement();
            rs = s.executeQuery(query);
            if (rs.next())
                return rs.getInt("lastID");
        } catch (SQLException ex) {
            Logger.getLogger(HomePetugasModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 0;
    }
    
    public void insertCust(Pelanggan c) {
        int no = getLastIdCust()+1;
        try {
            String query = "INSERT INTO tb_customer VALUES ('"+no+"','"+c.getIdCust()+"',"
                    + "'"+c.getNama()+"','"+c.getAlamat()+"','"+c.getNoTelp()+"',"
                    + "'"+c.getJenisKelamin()+"')";
            Statement s = con.createStatement();
            s.execute(query);
        } catch(SQLException se){
            System.out.println(se);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJK = new javax.swing.ButtonGroup();
        Jpanel_Bg = new javax.swing.JPanel();
        labelHi = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfAlamat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfNoHp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        radioLk = new javax.swing.JRadioButton();
        radioPr = new javax.swing.JRadioButton();
        labelIdCust = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfBerat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnHitung = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbLayanan = new javax.swing.JComboBox<>();
        tfTotal = new javax.swing.JTextField();
        cbBayar = new javax.swing.JComboBox<>();
        labelTanggal = new javax.swing.JLabel();
        labelHi1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        labelHi2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTransaksi = new javax.swing.JTable();
        btnLogout = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfCariPelanggan = new javax.swing.JTextField();
        btnCariPelanggan = new javax.swing.JButton();
        comboCari = new javax.swing.JComboBox<>();
        tfCari = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Form Transaksi");
        setResizable(false);

        Jpanel_Bg.setBackground(new java.awt.Color(102, 255, 102));

        labelHi.setFont(new java.awt.Font("Tiranti Solid LET", 1, 36)); // NOI18N
        labelHi.setForeground(new java.awt.Color(51, 51, 255));
        labelHi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/pic/logo.png"))); // NOI18N
        labelHi.setText("Form Transaksi");

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Pelanggan"));

        jLabel1.setText("Nama");

        jLabel2.setText("Alamat");

        jLabel3.setText("No. HP");

        jLabel4.setText("Jenis Kelamin");

        radioLk.setBackground(new java.awt.Color(153, 255, 153));
        bgJK.add(radioLk);
        radioLk.setText("Laki - Laki");

        radioPr.setBackground(new java.awt.Color(153, 255, 153));
        bgJK.add(radioPr);
        radioPr.setText("Perempuan");

        labelIdCust.setText("null");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNoHp)
                            .addComponent(tfAlamat)
                            .addComponent(tfNama)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIdCust)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioLk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioPr)))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(radioLk)
                    .addComponent(radioPr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIdCust)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Cucian"));

        jLabel5.setText("Berat (Kg)");

        jLabel6.setText("Layanan");

        jLabel7.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Total (Rp)");

        btnHitung.setText("HITUNG");

        jLabel8.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Pembayaran");

        cbLayanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reguler", "Oneday", "Sameday", "Express" }));

        tfTotal.setEditable(false);

        cbBayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belum Lunas", "Lunas" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfBerat)
                            .addComponent(cbLayanan, 0, 156, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)))
                        .addGap(64, 64, 64))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbLayanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnHitung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        labelTanggal.setText("Tanggal");

        labelHi1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelHi1.setText("Transaksi Baru");

        labelHi2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelHi2.setText("Data Transaksi");

        tableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableTransaksi);

        btnLogout.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnLogout.setText("LOGOUT");

        btnUpdate.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE TRANSAKSI");

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cari Data Pelanggan"));

        jLabel9.setText("ID / Nama Pelanggan");

        btnCariPelanggan.setText("CARI");
        btnCariPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPelangganActionPerformed(evt);
            }
        });

        comboCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Pelanggan", "ID Pelanggan" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCariPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCariPelanggan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCari, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCariPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCariPelanggan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("No. Transaksi");

        btnRefresh.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnRefresh.setText("REFRESH");

        btnTambah.setBackground(new java.awt.Color(255, 255, 204));
        btnTambah.setFont(new java.awt.Font("굴림", 3, 18)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(51, 51, 255));
        btnTambah.setText("TAMBAH TRANSAKSI");

        btnReset.setBackground(new java.awt.Color(255, 255, 204));
        btnReset.setFont(new java.awt.Font("굴림", 3, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 51, 51));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Jpanel_BgLayout = new javax.swing.GroupLayout(Jpanel_Bg);
        Jpanel_Bg.setLayout(Jpanel_BgLayout);
        Jpanel_BgLayout.setHorizontalGroup(
            Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_BgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_BgLayout.createSequentialGroup()
                        .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelHi2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh))
                    .addGroup(Jpanel_BgLayout.createSequentialGroup()
                        .addComponent(labelHi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTanggal))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_BgLayout.createSequentialGroup()
                        .addComponent(labelHi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Jpanel_BgLayout.createSequentialGroup()
                        .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Jpanel_BgLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Jpanel_BgLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        Jpanel_BgLayout.setVerticalGroup(
            Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_BgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout)
                    .addComponent(labelHi))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHi1)
                    .addComponent(labelTanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_BgLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Jpanel_BgLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(labelHi2)
                                .addGap(4, 4, 4)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_BgLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Jpanel_BgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUpdate)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Jpanel_Bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel_Bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
       tfCariPelanggan.setText(null);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCariPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariPelangganActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel_Bg;
    private javax.swing.ButtonGroup bgJK;
    private javax.swing.JButton btnCariPelanggan;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbBayar;
    private javax.swing.JComboBox<String> cbLayanan;
    private javax.swing.JComboBox<String> comboCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelHi;
    private javax.swing.JLabel labelHi1;
    private javax.swing.JLabel labelHi2;
    private javax.swing.JLabel labelIdCust;
    private javax.swing.JLabel labelTanggal;
    private javax.swing.JRadioButton radioLk;
    private javax.swing.JRadioButton radioPr;
    private javax.swing.JTable tableTransaksi;
    private javax.swing.JTextField tfAlamat;
    private javax.swing.JTextField tfBerat;
    private javax.swing.JTextField tfCari;
    private javax.swing.JTextField tfCariPelanggan;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNoHp;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
