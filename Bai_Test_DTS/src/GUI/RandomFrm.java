package GUI;

import java.util.Random;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class RandomFrm extends javax.swing.JFrame {

    Random rd = new Random();
    String str = "abcdefghijklmnopqrstuvwxyz";
    String string = str + str.toUpperCase();
    String[] arr = new String[1000];
    String[] arrFirst;
    public DefaultTableModel defaultTableModel;
    int index;

    public RandomFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //Đưa ra danh sách các chuỗi trong mảng
    public void showToString(String[] arrStrings) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Chuỗi");

        for (int i = 0; i < index; i++) {
            Vector vector = new Vector();
            vector.add(i + 1);
            vector.add(arrStrings[i]);
            defaultTableModel.addRow(vector);
        }
        tbl_Rd.setModel(defaultTableModel);
    }

    //Sắp xếp chọn
    public void SX_Chon(String[] arr, int index) {
        for (int i = 0; i < index - 1; i++) {
            //Tìm phần tử nhỏ nhất ở vị trí k
            int k = i;
            for (int j = i + 1; j < index; j++) {
                if (String.valueOf(arr[k].charAt(0)).toUpperCase().compareTo(String.valueOf(arr[j].charAt(0)).toUpperCase()) > 0) {
                    k = j;
                }
            }
            //Đổi chỗ phần tử nhỏ nhất ở vị trí k cho vị trí i
            if (k != i) {
                hoanDoi(arr, i, k);
            }
        }
    }

    //Sắp xếp chèn
    public void SX_Chen(String[] arr, int index) {
        for (int i = 1; i < index; i++) {
            String tg = arr[i];
            int j = i - 1;
            while (j >= 0 && String.valueOf(tg.charAt(0)).toUpperCase().compareTo(String.valueOf(arr[j].charAt(0)).toUpperCase()) < 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = tg;
        }
    }

    //Sắp xếp nổi bọt
    public void SX_NoiBot(String[] arr, int index) {
        for (int i = 0; i < index - 1; i++) {
            for (int j = index - 1; j > i; j--) {
                if (String.valueOf(arr[j].charAt(0)).toUpperCase().compareTo(String.valueOf(arr[j - 1].charAt(0)).toUpperCase()) < 0) {
                    hoanDoi(arr, j, j - 1);
                }
            }
        }
    }

    //Sắp xếp nhanh
    public void SX_Nhanh(String[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int i = L, j = R;
        int k = (L + R) / 2;
        String x = arr[k];
        do {
            while (String.valueOf(x.charAt(0)).toUpperCase().compareTo(String.valueOf(arr[i].charAt(0)).toUpperCase()) > 0) {
                i++;
            }
            while (String.valueOf(x.charAt(0)).toUpperCase().compareTo(String.valueOf(arr[j].charAt(0)).toUpperCase()) < 0) {
                j--;
            }
            if (i >= j) {
                break;
            }
            hoanDoi(arr, i, j);
            i++;
            j--;
        } while (i < j);
        SX_Nhanh(arr, L, j - 1); //Sắp xếp trên đoạn < x
        SX_Nhanh(arr, j + 1, R); //Sắp xếp trên đoạn > x
    }

    public void hoanDoi(String[] arr, int i, int j) {
        String tg = arr[i];
        arr[i] = arr[j];
        arr[j] = tg;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_Rd = new javax.swing.JButton();
        cbb_SapXep = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Rd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Tạo chuỗi ngẫu nhiên từ 1-5 kí tự");

        btn_Rd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_Rd.setText("Random");
        btn_Rd.setToolTipText("Click để tạo một chuỗi ngẫu nhiên(1-5 kí tự)");
        btn_Rd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RdActionPerformed(evt);
            }
        });

        cbb_SapXep.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbb_SapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xếp theo: Mặc định", "Sắp xếp chọn", "Sắp xếp chèn", "Sắp xếp sủi bọt", "Sắp xếp nhanh" }));
        cbb_SapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_SapXepActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách chuỗi đã tạo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 16))); // NOI18N
        jPanel2.setToolTipText("");

        tbl_Rd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbl_Rd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tbl_Rd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbl_Rd.setRowHeight(20);
        jScrollPane1.setViewportView(tbl_Rd);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_SapXep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(btn_Rd)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addGap(48, 48, 48)
                .addComponent(btn_Rd)
                .addGap(44, 44, 44)
                .addComponent(cbb_SapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_RdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RdActionPerformed
        index = 0;
        do {
            int strLength = rd.nextInt(5) + 1;
            String strRandom = "";
            char[] text = new char[strLength];
            for (int j = 0; j < strLength; j++) {
                text[j] = string.charAt(rd.nextInt(string.length()));
                strRandom += text[j];
            }
            arr[index++] = strRandom;

            showToString(arr);

        } while (index < arr.length);

        //Copy mảng
        arrFirst = new String[arr.length];
        System.arraycopy(arr, 0, arrFirst, 0, arr.length);
        show(arrFirst);
    }//GEN-LAST:event_btn_RdActionPerformed

    public void show(String[] a) {
        for (String b : a) {
            System.out.println(b);
        }
    }
    private void cbb_SapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_SapXepActionPerformed
        switch (cbb_SapXep.getSelectedIndex()) {
            case 0:
                showToString(arrFirst);
                break;
            case 1:
                SX_Chon(arr, index);
                showToString(arr);
                break;
            case 2:
                SX_Chen(arr, index);
                showToString(arr);
                break;
            case 3:
                SX_NoiBot(arr, index);
                showToString(arr);
                break;
            case 4:
                SX_Nhanh(arr, 0, index - 1);
                showToString(arr);
                break;
        }
    }//GEN-LAST:event_cbb_SapXepActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RandomFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RandomFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RandomFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RandomFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RandomFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Rd;
    private javax.swing.JComboBox<String> cbb_SapXep;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Rd;
    // End of variables declaration//GEN-END:variables
}
