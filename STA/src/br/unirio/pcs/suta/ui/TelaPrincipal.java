/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unirio.pcs.suta.ui;

/**
 *
 * @author Tiago
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form loginUI
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTelaPrincipal = new javax.swing.JPanel();
        barraPesquisaPrincipal = new javax.swing.JTextField();
        botaoPesquisarPrincipal = new javax.swing.JButton();
        percorrerCatalogoPrincipal = new javax.swing.JButton();
        descricaoPrincipal = new javax.swing.JLabel();
        alteraCadastroPrincipal = new javax.swing.JButton();
        visualizarPedidoPrincipal = new javax.swing.JButton();
        reportaErroSistemaPrincipal = new javax.swing.JButton();
        reportarErroObraPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelTelaPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        botaoPesquisarPrincipal.setText("Pesquisar");

        percorrerCatalogoPrincipal.setText("Percorrer catálogo");
        percorrerCatalogoPrincipal.setToolTipText("");

        descricaoPrincipal.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        descricaoPrincipal.setText("STA");

        alteraCadastroPrincipal.setText("Alterar Cadastro");

        visualizarPedidoPrincipal.setText("Visualizar Pedido");

        reportaErroSistemaPrincipal.setText("Reportar erro no sistema");
        reportaErroSistemaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportaErroSistemaPrincipalActionPerformed(evt);
            }
        });

        reportarErroObraPrincipal.setText("Reportar erro em obra");

        javax.swing.GroupLayout painelTelaPrincipalLayout = new javax.swing.GroupLayout(painelTelaPrincipal);
        painelTelaPrincipal.setLayout(painelTelaPrincipalLayout);
        painelTelaPrincipalLayout.setHorizontalGroup(
            painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaPrincipalLayout.createSequentialGroup()
                        .addGap(0, 82, Short.MAX_VALUE)
                        .addGroup(painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaPrincipalLayout.createSequentialGroup()
                                .addComponent(barraPesquisaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaPrincipalLayout.createSequentialGroup()
                                .addComponent(descricaoPrincipal)
                                .addGap(281, 281, 281))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaPrincipalLayout.createSequentialGroup()
                        .addGroup(painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelTelaPrincipalLayout.createSequentialGroup()
                                .addComponent(visualizarPedidoPrincipal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reportarErroObraPrincipal))
                            .addGroup(painelTelaPrincipalLayout.createSequentialGroup()
                                .addComponent(alteraCadastroPrincipal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reportaErroSistemaPrincipal)))
                        .addGap(32, 32, 32))
                    .addGroup(painelTelaPrincipalLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(botaoPesquisarPrincipal)
                        .addGap(76, 76, 76)
                        .addComponent(percorrerCatalogoPrincipal)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelTelaPrincipalLayout.setVerticalGroup(
            painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaPrincipalLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(descricaoPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barraPesquisaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoPesquisarPrincipal)
                    .addComponent(percorrerCatalogoPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alteraCadastroPrincipal)
                    .addComponent(reportaErroSistemaPrincipal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visualizarPedidoPrincipal)
                    .addComponent(reportarErroObraPrincipal))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reportaErroSistemaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportaErroSistemaPrincipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportaErroSistemaPrincipalActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alteraCadastroPrincipal;
    private javax.swing.JTextField barraPesquisaPrincipal;
    private javax.swing.JButton botaoPesquisarPrincipal;
    private javax.swing.JLabel descricaoPrincipal;
    private javax.swing.JPanel painelTelaPrincipal;
    private javax.swing.JButton percorrerCatalogoPrincipal;
    private javax.swing.JButton reportaErroSistemaPrincipal;
    private javax.swing.JButton reportarErroObraPrincipal;
    private javax.swing.JButton visualizarPedidoPrincipal;
    // End of variables declaration//GEN-END:variables
}
