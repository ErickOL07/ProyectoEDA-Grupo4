package GUI;

import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.Dependencia;
import Trámites._2_Registro.Expediente;
import Trámites._4_Seguimiento.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SeguimientoTrámites extends javax.swing.JFrame {

    private Acceso acceso;
    private SistemaTramite sistema;

    public SeguimientoTrámites(Acceso acceso) {
        this.acceso = acceso;
        sistema = Datos.sistema;
        
        initComponents();
        agregarEventos();
        cargarTramites();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
    
    private void agregarEventos() {
        
        TextoVolver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                VistaInteresado VistaInteresadoFrame = new VistaInteresado(acceso);
                VistaInteresadoFrame.setVisible(true);
                dispose();
            }
        });
        
        Volver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                VistaInteresado VistaInteresadoFrame = new VistaInteresado(acceso);
                VistaInteresadoFrame.setVisible(true);
                dispose();
            }
        });     
        
        ListaTrámites.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String expedienteId = ListaTrámites.getSelectedValue();
                    if (expedienteId != null) {
                        mostrarSeguimiento(expedienteId);
                    }
                }
            }
        });

    }
    
    private void cargarTramites() {
        ListaEnlazada<Expediente> expedientes = sistema.getListaExpedientes();
        Nodo<Expediente> ptr = expedientes.getHead();
        DefaultListModel<String> model = new DefaultListModel<>();
        while (ptr != null) {
            if (ptr.getData().getDatosInteresado().equals(acceso.usuarioActual())) {
                model.addElement(ptr.getData().getId());
            }
            ptr = ptr.getNext();
        }
        ListaTrámites.setModel(model);
    }

    private void mostrarSeguimiento(String expedienteId) {
        String seguimiento = sistema.mostrarSeguimiento(expedienteId);
        JOptionPane.showMessageDialog(this, seguimiento, "Seguimiento del Expediente", JOptionPane.INFORMATION_MESSAGE);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Encabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ObservarSeguimientoImg = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TextoVolver = new javax.swing.JLabel();
        Volver = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaTrámites = new javax.swing.JList<>();

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

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3.setText("Mis trámites");

        ObservarSeguimientoImg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ObservarSeguimientoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Observar seguimiento.png"))); // NOI18N
        ObservarSeguimientoImg.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/MenuMisTramites.png"))); // NOI18N

        TextoVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoVolver.setForeground(new java.awt.Color(255, 102, 0));
        TextoVolver.setText("Volver");

        Volver.setFont(new java.awt.Font("Segoe UI", 1, 5)); // NOI18N
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Atrás.png"))); // NOI18N
        Volver.setToolTipText("");
        Volver.setMaximumSize(new java.awt.Dimension(526, 446));
        Volver.setMinimumSize(new java.awt.Dimension(526, 446));
        Volver.setName(""); // NOI18N

        ListaTrámites.setBackground(new java.awt.Color(204, 204, 204));
        ListaTrámites.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 5, true));
        ListaTrámites.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ListaTrámites.setForeground(new java.awt.Color(255, 102, 0));
        jScrollPane1.setViewportView(ListaTrámites);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(ObservarSeguimientoImg))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(ObservarSeguimientoImg))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoVolver)))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(558, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SeguimientoTrámites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeguimientoTrámites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeguimientoTrámites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeguimientoTrámites.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            Acceso acceso = new Acceso();
                new SeguimientoTrámites(acceso).setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Encabezado;
    private javax.swing.JList<String> ListaTrámites;
    private javax.swing.JLabel ObservarSeguimientoImg;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
