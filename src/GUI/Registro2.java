package GUI;

import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Registro2 extends javax.swing.JFrame {

    public ListaEnlazada<Dependencia> listaDependencias;
    public ListaEnlazada<Usuario> listaUsuarios;

    public Registro2() {
        initComponents();
        agregarEventos();
        
        listaDependencias = Datos.listaDependencias;
        listaUsuarios = Datos.listaUsuarios;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });
    }

    private void resizeComponents() {
        Dimension size = getSize();
        float scale = Math.min(size.width / 1920.0f, size.height / 1080.0f);

        Dimension encabezadoSize = new Dimension((int)(Encabezado.getPreferredSize().width * scale), (int)(Encabezado.getPreferredSize().height * scale));
        Encabezado.setPreferredSize(encabezadoSize);
        Encabezado.setMinimumSize(encabezadoSize);
        Encabezado.setMaximumSize(encabezadoSize);

        Encabezado.revalidate();
        getContentPane().revalidate();
        repaint();
    }
    
    private void registrarUsuario() {
        String nombre = IngresarNombre.getText();
        String correo = IngresarCorreo.getText();
        String contraseña = IngresarContraseña.getText();
        String repetirContraseña = IngresarContraseña2.getText();

        if (correo.isEmpty() || contraseña.isEmpty() || repetirContraseña.isEmpty()) {
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
        
        if (verificarInstitución(nombre)) {
            JOptionPane.showMessageDialog(this, "Ya existe una institución con ese nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (verificarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "Ese correo ya fue utilizado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario nuevoUsuario = new Institución(nombre, correo, contraseña);

        this.listaUsuarios.insertar(nuevoUsuario);

        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        new Acceso().setVisible(true);
        dispose();
    }
    
    private boolean verificarInstitución(String nombre) {
        Nodo<Usuario> ptr = listaUsuarios.getHead();
        while (ptr != null) {
            if (ptr.getData() instanceof Institución && ((Institución) ptr.getData()).getNombre().equals(nombre)) {
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
        
    private void agregarEventos() {
        ComunícateConNosotros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().mail(new URI("mailto:helpdesk@ulima.edu.pe?subject=MiUlima"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo abrir el cliente de correo.");
                }
            }
        });

        InicioUniversidadDeLima.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.ulima.edu.pe/"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo abrir el navegador.");
                }
            }
        });
        
        RealizarRegistroComoUsuarioPersonal.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Registro registroFrame = new Registro();
                registroFrame.setVisible(true);
                dispose();
            }
        });
        
        IniciarSesión.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Acceso inicioFrame = new Acceso();
                inicioFrame.setVisible(true);
                dispose();
            }
        });
        
        Volver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Acceso inicioFrame = new Acceso();
                inicioFrame.setVisible(true);
                dispose();
            }
        });        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        InicioUniversidadDeLima = new javax.swing.JLabel();
        ComunícateConNosotros = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IngresarNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        IngresarCorreo = new javax.swing.JTextField();
        Volver = new javax.swing.JLabel();
        IngresarContraseña = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        IngresarContraseña2 = new javax.swing.JTextField();
        Registrarse = new javax.swing.JButton();
        IniciarSesión = new javax.swing.JLabel();
        RealizarRegistroComoUsuarioPersonal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Encabezado.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/logo_ulima.png"))); // NOI18N

        InicioUniversidadDeLima.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        InicioUniversidadDeLima.setForeground(new java.awt.Color(102, 102, 102));
        InicioUniversidadDeLima.setText("Inicio Universidad de Lima");

        ComunícateConNosotros.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        ComunícateConNosotros.setForeground(new java.awt.Color(102, 102, 102));
        ComunícateConNosotros.setText("Comunícate con nosotros");
        ComunícateConNosotros.setToolTipText("");

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncabezadoLayout.createSequentialGroup()
                .addContainerGap(1180, Short.MAX_VALUE)
                .addComponent(ComunícateConNosotros)
                .addGap(133, 133, 133)
                .addComponent(InicioUniversidadDeLima)
                .addGap(228, 228, 228))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InicioUniversidadDeLima)
                    .addComponent(ComunícateConNosotros))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Registro institucional");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Nombre");

        IngresarNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarNombreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Correo");

        IngresarCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarCorreoActionPerformed(evt);
            }
        });

        Volver.setFont(new java.awt.Font("Segoe UI", 1, 5)); // NOI18N
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Atrás.png"))); // NOI18N
        Volver.setToolTipText("");
        Volver.setMaximumSize(new java.awt.Dimension(526, 446));
        Volver.setMinimumSize(new java.awt.Dimension(526, 446));
        Volver.setName(""); // NOI18N

        IngresarContraseña.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarContraseñaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Contraseña");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Repetir contraseña");

        IngresarContraseña2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarContraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarContraseña2ActionPerformed(evt);
            }
        });

        Registrarse.setBackground(new java.awt.Color(255, 153, 0));
        Registrarse.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Registrarse.setText("Registrarse");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });

        IniciarSesión.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IniciarSesión.setForeground(new java.awt.Color(255, 102, 0));
        IniciarSesión.setText("Iniciar sesión");

        RealizarRegistroComoUsuarioPersonal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RealizarRegistroComoUsuarioPersonal.setForeground(new java.awt.Color(255, 102, 0));
        RealizarRegistroComoUsuarioPersonal.setText("Realizar registro como usuario personal");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/RegistroInstitucional.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(IniciarSesión))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(150, 150, 150)
                        .addComponent(IngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addComponent(IngresarContraseña2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RealizarRegistroComoUsuarioPersonal)
                                .addGap(34, 34, 34)
                                .addComponent(Registrarse)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(117, 117, 117)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IniciarSesión))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IngresarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel7)
                                    .addComponent(IngresarContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel8)
                                    .addComponent(IngresarContraseña2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(Registrarse))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addComponent(RealizarRegistroComoUsuarioPersonal))))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(709, 709, 709))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarNombreActionPerformed

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
            java.util.logging.Logger.getLogger(Registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Registro2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ComunícateConNosotros;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JTextField IngresarContraseña;
    private javax.swing.JTextField IngresarContraseña2;
    private javax.swing.JTextField IngresarCorreo;
    private javax.swing.JTextField IngresarNombre;
    private javax.swing.JLabel IniciarSesión;
    private javax.swing.JLabel InicioUniversidadDeLima;
    private javax.swing.JLabel RealizarRegistroComoUsuarioPersonal;
    private javax.swing.JButton Registrarse;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
