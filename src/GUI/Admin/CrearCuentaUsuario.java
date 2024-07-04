package GUI.Admin;

import GUI.*;
import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CrearCuentaUsuario extends javax.swing.JFrame {

    public ListaEnlazada<Dependencia> listaDependencias;
    public ListaEnlazada<Usuario> listaUsuarios;

    public CrearCuentaUsuario() {
        initComponents();
        
        listaDependencias = Datos.listaDependencias;
        listaUsuarios = Datos.listaUsuarios;
        
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        RealizarRegistroComoInstitución.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                CrearCuentaUsuario2 CrearCuentaUsuario2Frame = new CrearCuentaUsuario2();
                CrearCuentaUsuario2Frame.setVisible(true);
                dispose();
            }
        });
    }
    
    private void registrarUsuario() {
        String nombre = IngresarNombre.getText();
        String apellido = IngresarApellido.getText();
        String DNI = IngresarDNI.getText();
        String correo = IngresarCorreo.getText();
        String contraseña = IngresarContraseña.getText();
        String repetirContraseña = IngresarContraseña2.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || DNI.isEmpty() || correo.isEmpty() || contraseña.isEmpty() || repetirContraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contraseña.equals(repetirContraseña)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una dirección de correo electrónico válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (DNI.length() != 8) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (verificarDNI(DNI)) {
            JOptionPane.showMessageDialog(this, "El DNI ya ha sido utilizado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (verificarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Ese correo ya fue utilizado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Integer.parseInt(DNI);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario nuevoUsuario = new Persona(nombre, apellido, DNI, correo, contraseña);

        this.listaUsuarios.insertar(nuevoUsuario);

        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
    
    private boolean verificarDNI(String DNI) {
        Nodo<Usuario> ptr = listaUsuarios.getHead();
        while (ptr != null) {
            if (ptr.getData() instanceof Admin && ((Admin) ptr.getData()).getDNI().equals(DNI) || ptr.getData() instanceof Persona && ((Persona) ptr.getData()).getDNI().equals(DNI) || ptr.getData() instanceof Personal && ((Personal) ptr.getData()).getDNI().equals(DNI)) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }
    
    private boolean verificarCorreo(String correo) {
        Nodo<Usuario> ptr = listaUsuarios.getHead();
        while (ptr != null) {
            if (ptr.getData().getCorreo().equals(correo)) {
                return true;
            }
            ptr = ptr.getNext();
        }
        return false;
    }      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IngresarNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IngresarApellido = new javax.swing.JTextField();
        IngresarDNI = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        IngresarCorreo = new javax.swing.JTextField();
        IngresarContraseña = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        IngresarContraseña2 = new javax.swing.JTextField();
        Registrarse = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        RealizarRegistroComoInstitución = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Creación de usuario");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("DNI");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Nombre");

        IngresarNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarNombreActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Apellido");

        IngresarApellido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarApellidoActionPerformed(evt);
            }
        });

        IngresarDNI.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarDNIActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Correo");

        IngresarCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarCorreoActionPerformed(evt);
            }
        });

        IngresarContraseña.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarContraseñaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Contraseña");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Repetir contraseña");

        IngresarContraseña2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarContraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarContraseña2ActionPerformed(evt);
            }
        });

        Registrarse.setBackground(new java.awt.Color(255, 153, 0));
        Registrarse.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Registrarse.setText("Registrar");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        RealizarRegistroComoInstitución.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RealizarRegistroComoInstitución.setForeground(new java.awt.Color(255, 102, 0));
        RealizarRegistroComoInstitución.setText("Realizar registro como institución");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IngresarCorreo)
                                    .addComponent(IngresarContraseña)
                                    .addComponent(IngresarContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(IngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RealizarRegistroComoInstitución)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Registrarse)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(Cancelar)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Cancelar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(IngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(IngresarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IngresarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(IngresarContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrarse)
                    .addComponent(RealizarRegistroComoInstitución))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarNombreActionPerformed

    private void IngresarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarApellidoActionPerformed

    private void IngresarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarDNIActionPerformed

    private void IngresarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarCorreoActionPerformed

    private void IngresarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarContraseñaActionPerformed

    private void IngresarContraseña2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarContraseña2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarContraseña2ActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
        registrarUsuario();
    }//GEN-LAST:event_RegistrarseActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearCuentaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearCuentaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CrearCuentaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField IngresarApellido;
    private javax.swing.JTextField IngresarContraseña;
    private javax.swing.JTextField IngresarContraseña2;
    private javax.swing.JTextField IngresarCorreo;
    private javax.swing.JTextField IngresarDNI;
    private javax.swing.JTextField IngresarNombre;
    private javax.swing.JLabel RealizarRegistroComoInstitución;
    private javax.swing.JButton Registrarse;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
