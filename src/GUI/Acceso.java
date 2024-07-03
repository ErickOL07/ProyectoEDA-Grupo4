package GUI;

import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.Desktop;
import java.net.URI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Acceso extends javax.swing.JFrame {

    public ListaEnlazada<Dependencia> listaDependencias;
    public ListaEnlazada<Usuario> listaUsuarios;
    
    public Acceso() {
        initComponents();
        agregarEventos();
        listaDependencias = Datos.listaDependencias;
        listaUsuarios = Datos.listaUsuarios;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public ListaEnlazada<Dependencia> getListaDependencias() {
        return listaDependencias;
    }

    public void setListaDependencias(ListaEnlazada<Dependencia> listaDependencias) {
        this.listaDependencias = listaDependencias;
    }

    public ListaEnlazada<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ListaEnlazada<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
        
        INGRESAR.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                verificarCredenciales();
            }
        });
        
        Registrarse.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Registro registroFrame = new Registro();
                registroFrame.setVisible(true);
                dispose();
            }
        });
    }
    
    public Usuario usuarioActual() {
        
        String correo = IngresarCorreo.getText();
        String contraseña = IngresarContraseña.getText();

        Nodo<Usuario> ptr = listaUsuarios.getHead();
        while (ptr != null) {
            Usuario usuario = ptr.getData();
            if (usuario.getNombreUsuario().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
                } 
            ptr = ptr.getNext();
            }
        return null;
    }
        

    
    private void verificarCredenciales() {
        String correo = IngresarCorreo.getText();
        String contraseña = IngresarContraseña.getText();

        Nodo<Usuario> ptr = listaUsuarios.getHead();
        while (ptr != null) {
            Usuario usuario = ptr.getData();
            if (usuario.getNombreUsuario().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                if (usuario instanceof Admin) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Admin) usuario).getNombre());
                    new VistaAdmin(this).setVisible(true);
                } else if (usuario instanceof Personal) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Personal) usuario).getNombre());
                    new VistaPersonal().setVisible(true);
                } else if (usuario instanceof Persona) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Persona) usuario).getNombre());
                    new VistaInteresado(this).setVisible(true);
                } else if (usuario instanceof Institución) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Institución) usuario).getNombre());
                    new VistaInteresado(this).setVisible(true);
                }
                this.dispose();
                return;
            }
            ptr = ptr.getNext();
        }
    JOptionPane.showMessageDialog(null, "El usuario y/o contraseña ingresados no son correctos.");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        Encabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        InicioUniversidadDeLima = new javax.swing.JLabel();
        ComunícateConNosotros = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IngresarCorreo = new javax.swing.JTextField();
        INGRESAR = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Registrarse = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IngresarContraseña = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        Contenido.setBackground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Contraseña");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Usuario");

        IngresarCorreo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        IngresarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarCorreoActionPerformed(evt);
            }
        });

        INGRESAR.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        INGRESAR.setForeground(new java.awt.Color(255, 153, 51));
        INGRESAR.setText("INGRESAR");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Av. Javier Prado Este, Cdra. 46 s/n, Monterrico, Lima 33 - Perú. Telf.: (511) 437 6767 Fax (511) 437 8066 Ulima, todos los derechos reservados ® 2012");

        Registrarse.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Registrarse.setForeground(new java.awt.Color(102, 102, 102));
        Registrarse.setText("Registrarse");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/ImagenBlackboard.png"))); // NOI18N

        IngresarContraseña.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        IngresarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarContraseñaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Iniciar sesión");

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(INGRESAR)
                            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ContenidoLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(173, 173, 173)
                                    .addComponent(IngresarCorreo))
                                .addGroup(ContenidoLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(108, 108, 108)
                                    .addComponent(IngresarContraseña)))
                            .addComponent(Registrarse))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addGap(0, 327, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(237, 237, 237))
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel6)
                        .addGap(101, 101, 101)
                        .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ContenidoLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(IngresarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(101, 101, 101))
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)))
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(INGRESAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registrarse)
                .addGap(180, 180, 180)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarCorreoActionPerformed

    private void IngresarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarContraseñaActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ComunícateConNosotros;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JLabel INGRESAR;
    private javax.swing.JPasswordField IngresarContraseña;
    private javax.swing.JTextField IngresarCorreo;
    private javax.swing.JLabel InicioUniversidadDeLima;
    private javax.swing.JLabel Registrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
