
package forms;
import desarrolloo.ListSaldo;

public class FrmSaldo extends javax.swing.JInternalFrame {

    ListSaldo showListSaldo= new ListSaldo();
    public FrmSaldo() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSaldos = new javax.swing.JTable();
        BtnSearch = new javax.swing.JButton();
        rbtn1 = new javax.swing.JRadioButton();
        rbtn2 = new javax.swing.JRadioButton();
        rbtn3 = new javax.swing.JRadioButton();
        rbtn4 = new javax.swing.JRadioButton();
        rbtn5 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbtn6 = new javax.swing.JRadioButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Listar por $aldo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 16, -1, -1));

        TableSaldos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableSaldos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 300, 410));

        BtnSearch.setBackground(new java.awt.Color(204, 204, 204));
        BtnSearch.setText("Search");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(BtnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 190, 30));

        btnGroup.add(rbtn1);
        rbtn1.setSelected(true);
        rbtn1.setText("Saldo menor o igual a $300");
        rbtn1.setMixingCutoutShape(null);
        jPanel1.add(rbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 40));

        btnGroup.add(rbtn2);
        rbtn2.setText("Sin saldo");
        jPanel1.add(rbtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, -1, -1));

        btnGroup.add(rbtn3);
        rbtn3.setText("Saldo Mayor a $300");
        jPanel1.add(rbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        btnGroup.add(rbtn4);
        rbtn4.setText("Sin saldo");
        jPanel1.add(rbtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, -1));

        btnGroup.add(rbtn5);
        rbtn5.setText("Inactivos");
        jPanel1.add(rbtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        jLabel2.setText("Listar los numeros con...");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, -1));

        jLabel3.setText("Listar los nombres...");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel4.setText("Listar el login de los usuarios inactivos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        btnGroup.add(rbtn6);
        rbtn6.setText("Inactivos :(");
        jPanel1.add(rbtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
       String option = null;
        if(this.rbtn1.isSelected()){
            option= "option1";
        }else if(this.rbtn2.isSelected()){
            option="option2";
        }
        else if(this.rbtn3.isSelected()){
            option="option3";
        }
        else if(this.rbtn4.isSelected()){
            option="option4";
        }
        else if(this.rbtn5.isSelected()){
            option="option5";
        }
        else if(this.rbtn6.isSelected()){
            option="option6";
        }
          this.TableSaldos.setModel(showListSaldo.TitulosSaldos());
        this.TableSaldos.setModel(showListSaldo.DataSaldos(option));
    }//GEN-LAST:event_BtnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSearch;
    private javax.swing.JTable TableSaldos;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtn1;
    private javax.swing.JRadioButton rbtn2;
    private javax.swing.JRadioButton rbtn3;
    private javax.swing.JRadioButton rbtn4;
    private javax.swing.JRadioButton rbtn5;
    private javax.swing.JRadioButton rbtn6;
    // End of variables declaration//GEN-END:variables
}
