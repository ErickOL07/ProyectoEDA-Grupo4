package GUI.Admin;

import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import javax.swing.*;

public class CuentasUsuarioPersonal extends JFrame {

    public CuentasUsuarioPersonal() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
        
        obtenerTipos();
        obtenerSubtipos();
        SelSubtipoDependencia.setEnabled(false);
        
        SelTipoDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerSubtipos();
            }
        });
    }
    
    public void setNombre(String nombre) {
        IngresarNombre.setText(nombre);
    }

    public void setApellido(String apellido) {
        IngresarApellido.setText(apellido);
    }
    
    private static String DNIInicial;

    public void setDNI(String dni) {
        IngresarDNI.setText(dni);
        DNIInicial = IngresarDNI.getText();
    }
    
    public void setDependenciaID(String dependenciaID) {
        Dependencia dependencia = buscarDependenciaPorID(dependenciaID);
        if (dependencia != null) {
            SelTipoDependencia.setSelectedItem(dependencia.getTipo());
            obtenerSubtipos();
            SelSubtipoDependencia.setSelectedItem(dependencia.getSubTipo());
        }
    }

    private Dependencia buscarDependenciaPorID(String dependenciaID) {
        Nodo<Dependencia> ptr = Datos.getListaDependencias().getHead();
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (dependencia.getID().equals(dependenciaID)) {
                return dependencia;
            }
            ptr = ptr.getNext();
        }
        return null;
    }

    private static String correoInicial;

    public void setCorreo(String correo) {
        IngresarCorreo.setText(correo);
        correoInicial = IngresarCorreo.getText();
    }
    
    public void setContraseña(String contraseña) {
        IngresarContraseña.setText(contraseña);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EliminarUsuario = new javax.swing.JButton();
        GuardarCambios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        IngresarApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        IngresarDNI = new javax.swing.JTextField();
        IngresarCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IngresarContraseña = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        SelTipoDependencia = new javax.swing.JComboBox<>();
        SelSubtipoDependencia = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EliminarUsuario.setBackground(new java.awt.Color(204, 0, 0));
        EliminarUsuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        EliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        EliminarUsuario.setText("Eliminar empleado");
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
        jLabel1.setText("Nombre");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Apellido");
        jLabel2.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setText("Edición de datos de empleado");
        jLabel3.setToolTipText("");

        IngresarApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarApellidoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("DNI");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Correo");
        jLabel5.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Contraseña");
        jLabel6.setToolTipText("");

        Cancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Dependencia");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Cancelar)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel4))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IngresarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SelTipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SelSubtipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(87, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EliminarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GuardarCambios)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(IngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(IngresarApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(IngresarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SelSubtipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SelTipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GuardarCambios)
                    .addComponent(EliminarUsuario))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarApellidoActionPerformed

    private void EliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarUsuarioActionPerformed
        Nodo<Usuario> ptr = Datos.getListaUsuarios().getHead();
        Nodo<Usuario> prev = null;

        while (ptr != null) {
            Usuario usuario = ptr.getData();
            if (usuario.getCorreo().equals(correoInicial)) {
                if (prev == null) {
                    Datos.getListaUsuarios().insertar(ptr.getNext().getData());
                } else {
                    prev.setNext(ptr.getNext());
                }
                JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
                this.setVisible(false);
                return;
            }
            prev = ptr;
            ptr = ptr.getNext();
        }
        JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
    }//GEN-LAST:event_EliminarUsuarioActionPerformed

    private void GuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarCambiosActionPerformed
        String nombre = IngresarNombre.getText();
        String apellido = IngresarApellido.getText();
        String dni = IngresarDNI.getText();
        String correo = IngresarCorreo.getText();
        String contraseña = IngresarContraseña.getText();
        String tipoDependencia = (String) SelTipoDependencia.getSelectedItem();
        String subtipoDependencia = (String) SelSubtipoDependencia.getSelectedItem();
        
        if (IngresarNombre.getText().isEmpty() || IngresarApellido.getText().isEmpty() || IngresarDNI.getText().isEmpty() || IngresarCorreo.getText().isEmpty() || IngresarContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!IngresarCorreo.getText().contains("@")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una dirección de correo electrónico válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (IngresarDNI.getText().length() != 8) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (verificarDNI(IngresarDNI.getText())) {
            JOptionPane.showMessageDialog(this, "El DNI ya ha sido utilizado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (verificarCorreo(IngresarCorreo.getText())) {
            JOptionPane.showMessageDialog(this, "Ese correo ya fue utilizado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Integer.parseInt(IngresarDNI.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Nodo<Usuario> ptr = Datos.getListaUsuarios().getHead();
        while (ptr != null) {
            Usuario usuario = ptr.getData();
            if (usuario.getCorreo().equals(correoInicial)) {
                ((Personal) usuario).setNombre(nombre);
                ((Personal) usuario).setApellido(apellido);
                ((Personal) usuario).setDNI(dni);
                ((Personal) usuario).setCorreo(correo);
                ((Personal) usuario).setContraseña(contraseña);
                ((Personal) usuario).setDependenciaID(this.obtenerDependencia().getID());
                break;
            }
            ptr = ptr.getNext();
        }

        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }//GEN-LAST:event_GuardarCambiosActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private boolean verificarDNI(String DNI) {
        Nodo<Usuario> ptr = Datos.getListaUsuarios().getHead();
        System.out.println(DNIInicial);
        int c = 0;
        while (ptr != null) {
            if ((ptr.getData() instanceof Admin && ((Admin) ptr.getData()).getDNI().equals(DNI) && !((Admin) ptr.getData()).getDNI().equals(DNIInicial)) || (ptr.getData() instanceof Persona && ((Persona) ptr.getData()).getDNI().equals(DNI) && !((Persona) ptr.getData()).getDNI().equals(DNIInicial)) || (ptr.getData() instanceof Personal && ((Personal) ptr.getData()).getDNI().equals(DNI) && !((Personal) ptr.getData()).getDNI().equals(DNIInicial))) {
                System.out.println(((Personal) ptr.getData()).getDNI());
                c++;
            }
            ptr = ptr.getNext();
        }
        return c > 0;
    }
    
    private boolean verificarCorreo(String correo) {
        Nodo<Usuario> ptr = Datos.getListaUsuarios().getHead();
        int c = 0;
        while (ptr != null) {
            if (ptr.getData().getCorreo().equals(correo) && !ptr.getData().getCorreo().equals(correoInicial)) {
                c++;
            }
            ptr = ptr.getNext();
        }
        return c > 0;
    }
    
    
    private void obtenerTipos() {

        Nodo<Dependencia> ptr = Datos.getListaDependencias().getHead();
        ListaEnlazada<Dependencia> L = new ListaEnlazada<>();
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (!tipoRepetido(dependencia.getTipo(), L)) {
                SelTipoDependencia.addItem(dependencia.getTipo());
                L.insertar(dependencia); 
            }
            ptr = ptr.getNext();
        
        }
        
    }
    
    private boolean tipoRepetido(String tipo, ListaEnlazada<Dependencia> L) {
        
        Nodo<Dependencia> ptr = L.getHead();
        boolean s = false;
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (dependencia.getTipo().equals(tipo)) {
                s = true;
            }
            ptr = ptr.getNext();
            
        }
        
        return s;
    }
    
    private void obtenerSubtipos() {
        String tipoSeleccionado = (String) SelTipoDependencia.getSelectedItem();
        
        SelSubtipoDependencia.removeAllItems();
        
        Nodo<Dependencia> ptr = Datos.getListaDependencias().getHead();
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (dependencia.getTipo().equals(tipoSeleccionado) && dependencia.getSubTipo() != null) {
                SelSubtipoDependencia.addItem(dependencia.getSubTipo());
            }
            ptr = ptr.getNext();
        
        }
        
        if (SelSubtipoDependencia.getItemCount() > 0) {
            SelSubtipoDependencia.setEnabled(true);
        } else {
            SelSubtipoDependencia.setEnabled(false);
        }
        
    }
    
    private Dependencia obtenerDependencia() {
        String tipoSeleccionado = (String) SelTipoDependencia.getSelectedItem();
        String subtipoSeleccionado = (String) SelSubtipoDependencia.getSelectedItem();
        Dependencia dep = null;

        Nodo<Dependencia> ptr = Datos.getListaDependencias().getHead();
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (dependencia.getTipo().equals(tipoSeleccionado)) {
                if (subtipoSeleccionado != null && !subtipoSeleccionado.isEmpty()) {
                    if (dependencia.getSubTipo() != null && dependencia.getSubTipo().equals(subtipoSeleccionado)) {
                        dep = dependencia;
                        break;
                    }
                } else {
                    dep = dependencia;
                    break;
                }
            }
            ptr = ptr.getNext();
        }

        return dep;
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
            java.util.logging.Logger.getLogger(CuentasUsuarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CuentasUsuarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CuentasUsuarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CuentasUsuarioPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CuentasUsuarioPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton EliminarUsuario;
    private javax.swing.JButton GuardarCambios;
    private javax.swing.JTextField IngresarApellido;
    private javax.swing.JTextField IngresarContraseña;
    private javax.swing.JTextField IngresarCorreo;
    private javax.swing.JTextField IngresarDNI;
    private final javax.swing.JTextField IngresarNombre = new javax.swing.JTextField();
    private javax.swing.JComboBox<String> SelSubtipoDependencia;
    private javax.swing.JComboBox<String> SelTipoDependencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
