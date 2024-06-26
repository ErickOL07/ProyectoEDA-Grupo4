package GUI;

import TDA.*;
import Trámites._1_Inicio.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.Desktop;
import java.net.URI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class Acceso extends javax.swing.JFrame {

    public ListaEnlazada<Dependencia> listaDependencias;
    public ListaEnlazada<Usuario> listaUsuarios;
    
    public Acceso() {
        initComponents();
        agregarEventos();
        inicializarListas();
    }
    
    private void inicializarListas() {
        listaDependencias = new ListaEnlazada<>();
        listaUsuarios = new ListaEnlazada<>();
        
        // Dependencias:
        
        // Facultades y Programas de Pregrado
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Estudios Generales", "FPP_EG-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Arquitectura", "FPP_FA_Arq-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Contabilidad", "FPP_FCEE_Con-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Economía", "FPP_FCEE_Eco-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Negocios Internacionales", "FPP_FCEE_Neg-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Administración", "FPP_FCEE_Adm-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Marketing", "FPP_FCEE_Mar-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Comunicación", "FPP_FC_Com-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Derecho", "FPP_FD_Der-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Ingeniería Civil", "FPP_FI_Civ-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Ingeniería Industrial", "FPP_FI_Ind-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Ingeniería de Sistemas", "FPP_FI_Sis-"));
        listaDependencias.insertar(new Dependencia("Facultades y Programas de Pregrado", "Psicología", "FPP_FP_Psi-"));
        // Estudios de Posgrado
        listaDependencias.insertar(new Dependencia("Estudios de Posgrado", "POS-"));
        // Programas de Educación Ejecutiva
        listaDependencias.insertar(new Dependencia("Programas de Educación Ejecutiva", "PEG-"));
        // Oficinas Administrativas y Servicios
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Biblioteca", "OAS_Bib-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Bienestar", "OAS_Bie-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Deportes", "OAS_Dep-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Cultura", "OAS_Cul-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Fondo Editorial", "OAS_Fon-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Relaciones Internacionales", "OAS_Rel-"));
        listaDependencias.insertar(new Dependencia("Oficinas Administrativas y Servicios", "Red de Graduados", "OAS_Red-"));
        // Centros e Institutos
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Centro Cultural", "CI_CCul-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Centro de Empleabilidad", "CI_CEmpl-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Centro de Emprendimiento", "CI_CEmpr-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Observatorio", "CI_Obs-"));
        listaDependencias.insertar(new Dependencia("Centros e Institutos", "Instituto de Investigación", "CI_IInv-"));
        
        
        // Usuarios:
        
        // Administradores
            listaUsuarios.insertar(new Admin("Hector Gianmarco", "Arrasco Juarez", "76145825", "20223148@aloe.ulima.edu.pe", "76145825"));
            listaUsuarios.insertar(new Admin("Erick", "Obradovich Luna", "70814703", "20221751@aloe.ulima.edu.pe", "70814703"));
            listaUsuarios.insertar(new Admin("Roberto Victor", "Rodenas Rodenas", "71261584", "20222182@aloe.ulima.edu.pe", "71261584"));
            listaUsuarios.insertar(new Admin("Claudia Patricia", "Sipion Guillen", "70901486", "20224062@aloe.ulima.edu.pe", "70901486"));
        // Personal de dependencia
            // Facultades y Programas de Pregrado, Ingeniería de Sistemas
            listaUsuarios.insertar(new Personal("Jim Bryan", "Dios Luna", "10101010", "FPP_FI_Sis-", "jdios@aloe.ulima.edu.pe", "sistemas"));
            // Estudios de Posgrado
            listaUsuarios.insertar(new Personal("Gepeto", "Fossati", "00000001", "POS-", "gfossati@aloe.ulima.edu.pe", "posgrado"));
            // Oficinas Administrativas y Servicios, Deportes
            listaUsuarios.insertar(new Personal("Christian Alberto", "Cueva Bravo", "12345678", "OAS_Dep-", "ccueva@aloe.ulima.edu.pe", "deportes"));
        // Interesados comunes
            // Persona
            listaUsuarios.insertar(new Persona("Makanaky", "La Realeza", "66666666", "makanaky@gmail.com", "makanaky"));
            // Institución
            listaUsuarios.insertar(new Institución("USB", "USB@ucv.edu.pe", "paolo"));
        
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
    
    private void verificarCredenciales() {
        String correo = IngresarCorreo.getText();
        String contraseña = IngresarContraseña.getText();

        Nodo<Usuario> current = listaUsuarios.getHead();
        while (current != null) {
            Usuario usuario = current.getData();
            if (usuario.getNombreUsuario().equals(correo) && usuario.getContraseña().equals(contraseña)) {
                if (usuario instanceof Admin) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Admin) usuario).getNombre());
                    new VistaAdmin().setVisible(true);
                } else if (usuario instanceof Personal) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Personal) usuario).getNombre());
                    new VistaPersonal().setVisible(true);
                } else if (usuario instanceof Persona) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Persona) usuario).getNombre());
                    new VistaInteresado().setVisible(true);
                } else if (usuario instanceof Institución) {
                    JOptionPane.showMessageDialog(null, "Hola, " + ((Institución) usuario).getNombre());
                    new VistaInteresado().setVisible(true);
                }
                this.dispose();
                return;
            }
            current = current.getNext();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IngresarContraseña = new javax.swing.JTextField();
        IngresarCorreo = new javax.swing.JTextField();
        INGRESAR = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Registrarse = new javax.swing.JLabel();

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
                .addContainerGap(923, Short.MAX_VALUE)
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/ImagenBlackboard.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Contraseña");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Usuario");

        IngresarContraseña.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        IngresarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarContraseñaActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContenidoLayout.createSequentialGroup()
                        .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(INGRESAR)
                            .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ContenidoLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(108, 108, 108)
                                    .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ContenidoLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Registrarse))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                        .addGap(0, 739, Short.MAX_VALUE)
                        .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContenidoLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap())))))
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ContenidoLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(IngresarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addGap(41, 41, 41)
                .addGroup(ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(IngresarContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(INGRESAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registrarse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
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
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JTextField IngresarContraseña;
    private javax.swing.JTextField IngresarCorreo;
    private javax.swing.JLabel InicioUniversidadDeLima;
    private javax.swing.JLabel Registrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
