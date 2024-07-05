package GUI.Admin;

import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.*;
import javax.swing.*;

public class DependenciasAdmin extends JFrame {
    
    public DependenciasAdmin() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
        
    }
    
    public void setTipo(String tipo) {
        IngresarTipo.setText(tipo);
    }

    public void setSubtipo(String subtipo) {
        IngresarSubtipo.setText(subtipo);
    }

    private static String IDBaseInicial;
    private static String toStringInicial;
    
    public void setIDBase(String IDBase) {
        IngresarIDBase.setText(IDBase);
        IDBaseInicial = IngresarIDBase.getText();
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EliminarUsuario = new javax.swing.JButton();
        GuardarCambios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IngresarSubtipo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IngresarIDBase = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EliminarUsuario.setBackground(new java.awt.Color(204, 0, 0));
        EliminarUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        EliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        EliminarUsuario.setText("Eliminar dependencia");
        EliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarUsuarioActionPerformed(evt);
            }
        });

        GuardarCambios.setBackground(new java.awt.Color(0, 255, 51));
        GuardarCambios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        GuardarCambios.setText("Guardar cambios");
        GuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarCambiosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Tipo");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Subtipo");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setText("Edición de dependencia");
        jLabel3.setToolTipText("");

        IngresarSubtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarSubtipoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("ID Base");
        jLabel4.setToolTipText("");

        Cancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(EliminarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GuardarCambios)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IngresarIDBase, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarSubtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5))
                            .addComponent(jLabel3))
                        .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresarTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(IngresarSubtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(IngresarIDBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarCambios)
                    .addComponent(EliminarUsuario))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarSubtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarSubtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarSubtipoActionPerformed

    private void EliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarUsuarioActionPerformed
        JOptionPane.showMessageDialog(this, "No puede eliminar a otro administrador.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_EliminarUsuarioActionPerformed

    private void GuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosActionPerformed
        if (IngresarTipo.getText().isEmpty() || IngresarIDBase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete los campos \"Tipo\" e \"ID Base\".", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                
        if (verificarID(IngresarIDBase.getText())) {
            JOptionPane.showMessageDialog(this, "El ID base ya ha sido utilizado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!IngresarSubtipo.getText().equals("")){
            if (verificarTipo(IngresarTipo.getText() + ", "+ IngresarSubtipo.getText())) {
                JOptionPane.showMessageDialog(this, "La dependencia ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            if (verificarTipo(IngresarTipo.getText())) {
                JOptionPane.showMessageDialog(this, "La dependencia ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
            Datos.buscarDependencia(IDBaseInicial).setTipo(IngresarTipo.getText());
            Datos.buscarDependencia(IDBaseInicial).setSubTipo(IngresarSubtipo.getText());
            Datos.buscarDependencia(IDBaseInicial).setID(IngresarIDBase.getText());
        JOptionPane.showMessageDialog(this, "Datos guardados con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_GuardarCambiosActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private boolean verificarID(String baseID) {
        Nodo<Dependencia> ptr = Datos.getListaDependencias().getHead();
        while (ptr != null) {
            if (ptr.getData().getID().equals(baseID) && !(ptr.getData().getID().equals(IDBaseInicial))) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }
    
    private boolean verificarTipo(String toString) {
        Nodo<Dependencia> ptr = Datos.getListaDependencias().getHead();
        while (ptr != null) {
            if (ptr.getData().toString().equals(toString) && !ptr.getData().toString().equals(toStringInicial) ) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }

    
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
            java.util.logging.Logger.getLogger(DependenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DependenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DependenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DependenciasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DependenciasAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton EliminarUsuario;
    private javax.swing.JButton GuardarCambios;
    private javax.swing.JTextField IngresarIDBase;
    private javax.swing.JTextField IngresarSubtipo;
    private final javax.swing.JTextField IngresarTipo = new javax.swing.JTextField();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
