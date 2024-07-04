/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Trámites.*;
import Trámites._6_Roles.*;
import Trámites._7_Alertas.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaInteresado extends javax.swing.JFrame {

    private Acceso acceso;
    private Alerta alerta;

    public VistaInteresado(Acceso acceso) {
        this.acceso = acceso;
        this.alerta = new Alerta();
        initComponents();
        agregarEventos();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                alerta();
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void alerta() {
        JOptionPane.showMessageDialog(this, alerta.expedientesNoAtendidos(Datos.getSistema(), acceso.usuarioActual()), "Alerta automática", JOptionPane.INFORMATION_MESSAGE);
    }
        
    public String nomUsuario() {
            
        if (acceso.usuarioActual() instanceof Admin) {
            return ((Admin) acceso.usuarioActual()).getNombre();
        } else if (acceso.usuarioActual() instanceof Personal) {
            return ((Personal) acceso.usuarioActual()).getNombre();
        } else if (acceso.usuarioActual() instanceof Persona) {
            return ((Persona) acceso.usuarioActual()).getNombre();
        } else if (acceso.usuarioActual() instanceof Institución) {
            return ((Institución) acceso.usuarioActual()).getNombre();
        }
        return "Usuario desconocido";
    }
    
    private String iconoCond() {
        
        if (acceso.usuarioActual() instanceof Admin || acceso.usuarioActual() instanceof Personal) {
            return "/Vectores/Atrás.png";
        } else {
            return "/Vectores/CerrarSesión.png";
        }
    }
        
    private String volverCond() {
        
        if (acceso.usuarioActual() instanceof Admin) {
            return "Vista de administrador";
        } else if (acceso.usuarioActual() instanceof Personal) {
            return "Vista de personal";
        } else {
            return "  Cerrar sesión";
        }
        
    }
    
    private void agregarEventos() {
        ObservarSeguimientoImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                SeguimientoTrámites SeguimientoTrámitesFrame = new SeguimientoTrámites(acceso);
                SeguimientoTrámitesFrame.setVisible(true);
                dispose();
            }
        });

        ObservarSeguimientoTxt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                SeguimientoTrámites SeguimientoTrámitesFrame = new SeguimientoTrámites(acceso);
                SeguimientoTrámitesFrame.setVisible(true);
                dispose();
            }
        });
        
        IniciarTrámiteImg.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                NuevoTrámite NuevoTrámiteFrame = new NuevoTrámite(acceso);
                NuevoTrámiteFrame.setVisible(true);
                dispose();
            }
        });
        
        IniciarTrámiteTxt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                NuevoTrámite NuevoTrámiteFrame = new NuevoTrámite(acceso);
                NuevoTrámiteFrame.setVisible(true);
                dispose();
            }
        });
        
        Volver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (acceso.usuarioActual() instanceof Admin) {
                    VistaAdmin VistaAdminFrame = new VistaAdmin(acceso);
                    VistaAdminFrame.setVisible(true);
                    dispose();
                } else if (acceso.usuarioActual() instanceof Personal) {
                    VistaPersonal VistaPersonalFrame = new VistaPersonal(acceso);
                    VistaPersonalFrame.setVisible(true);
                    dispose();
                } else {
                    Acceso AccesoFrame = new Acceso();
                    AccesoFrame.setVisible(true);
                    dispose();
                }
            }
        });
        
        TextoVolver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (acceso.usuarioActual() instanceof Admin) {
                    VistaAdmin VistaAdminFrame = new VistaAdmin(acceso);
                    VistaAdminFrame.setVisible(true);
                    dispose();
                } else if (acceso.usuarioActual() instanceof Personal) {
                    VistaPersonal VistaPersonalFrame = new VistaPersonal(acceso);
                    VistaPersonalFrame.setVisible(true);
                    dispose();
                } else {
                    Acceso AccesoFrame = new Acceso();
                    AccesoFrame.setVisible(true);
                    dispose();
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Encabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ObservarSeguimientoImg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IniciarTrámiteTxt = new javax.swing.JLabel();
        IniciarTrámiteImg = new javax.swing.JLabel();
        ObservarSeguimientoTxt = new javax.swing.JLabel();
        TextoVolver = new javax.swing.JLabel();
        Volver = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Encabezado.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/logo_ulima.png"))); // NOI18N

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("¿Qué desea hacer hoy?");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3.setText("¡Hola, " + nomUsuario() + "!");

        ObservarSeguimientoImg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ObservarSeguimientoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Observar seguimiento.png"))); // NOI18N
        ObservarSeguimientoImg.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/ImagenSolicitud.png"))); // NOI18N

        IniciarTrámiteTxt.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        IniciarTrámiteTxt.setText("Iniciar un nuevo trámite");

        IniciarTrámiteImg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        IniciarTrámiteImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Nuevo trámite.png"))); // NOI18N
        IniciarTrámiteImg.setToolTipText("");

        ObservarSeguimientoTxt.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        ObservarSeguimientoTxt.setText("Observar seguimiento de mis trámites");

        TextoVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoVolver.setForeground(new java.awt.Color(255, 102, 0));
        TextoVolver.setText(volverCond());

        Volver.setFont(new java.awt.Font("Segoe UI", 1, 5)); // NOI18N
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconoCond())));
        Volver.setToolTipText("");
        Volver.setMaximumSize(new java.awt.Dimension(526, 446));
        Volver.setMinimumSize(new java.awt.Dimension(526, 446));
        Volver.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TextoVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ObservarSeguimientoImg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ObservarSeguimientoTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IniciarTrámiteImg)
                        .addGap(62, 62, 62)
                        .addComponent(IniciarTrámiteTxt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoVolver)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ObservarSeguimientoImg)
                            .addComponent(ObservarSeguimientoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IniciarTrámiteTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IniciarTrámiteImg)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap(556, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Acceso acceso = new Acceso();
                new VistaInteresado(acceso).setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Encabezado;
    private javax.swing.JLabel IniciarTrámiteImg;
    private javax.swing.JLabel IniciarTrámiteTxt;
    private javax.swing.JLabel ObservarSeguimientoImg;
    private javax.swing.JLabel ObservarSeguimientoTxt;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
