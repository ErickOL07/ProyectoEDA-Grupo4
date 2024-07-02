package GUI;

import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.*;
import Trámites._2_Registro.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashSet;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NuevoTrámite extends javax.swing.JFrame {

    private Acceso acceso;
    private String archivo;

    public NuevoTrámite(Acceso acceso) {
        this.acceso = acceso;
        initComponents();
        agregarEventos();
        obtenerTipos();
        obtenerSubtipos();
        
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

        SelSubtipoDependencia.setEnabled(false);
    }
    
    private void nuevoTrámite() {
        try {
            String asunto = IngresarAsunto.getText().trim();
            String documentoReferencia = archivo;
            Usuario usuarioActual = acceso.usuarioActual();

            if (asunto.isEmpty() || documentoReferencia.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Dependencia dependencia = obtenerDependencia();
            
            Expediente nuevoExpediente = new Expediente(dependencia, false, usuarioActual, asunto, documentoReferencia);

            Datos.expedientesNuevos.insertar(nuevoExpediente);

            JOptionPane.showMessageDialog(this, "Trámite creado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear el trámite: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void obtenerTipos() {

        Nodo<Dependencia> ptr = acceso.getListaDependencias().getHead();
        ListaEnlazada<Dependencia> L = new ListaEnlazada<>();
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (!tipoRepetido(dependencia.getTipo(), L)) {
                SelTipoDependencia.addItem(dependencia.getTipo());
            }
            ptr = ptr.getNext();
        
        }
        
        if (SelSubtipoDependencia.getItemCount() > 0) {
            SelSubtipoDependencia.setEnabled(true);
        } else {
            SelSubtipoDependencia.setEnabled(false);
        }
    }
    
    private boolean tipoRepetido(String tipo, ListaEnlazada<Dependencia> L) {
        
        Nodo<Dependencia> ptr = L.getHead();
        boolean s = false;
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (dependencia.getTipo() == tipo) {
                s = true;
            }
            ptr = ptr.getNext();
            
        }
        
        return s;
    }
    
    private void obtenerSubtipos() {
        String tipoSeleccionado = (String) SelTipoDependencia.getSelectedItem();
        
        SelSubtipoDependencia.removeAllItems();
        
        Nodo<Dependencia> ptr = acceso.getListaDependencias().getHead();
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            if (dependencia.getTipo() == tipoSeleccionado) {
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
        Dependencia dep = new Dependencia(null, null, null);
        if (SelSubtipoDependencia.getItemCount() > 0) {
            Nodo<Dependencia> ptr = acceso.getListaDependencias().getHead();
            String subtipoSeleccionado = (String) SelSubtipoDependencia.getSelectedItem();
            while (ptr != null) {
                Dependencia dependencia = ptr.getData();
                if (dependencia.getTipo() == tipoSeleccionado) {
                    if (dependencia.getSubTipo() == subtipoSeleccionado) {
                        dep = dependencia;
                    }
                }
                ptr = ptr.getNext();
                
            }
        } else {
            Nodo<Dependencia> ptr = acceso.getListaDependencias().getHead();
            while (ptr != null) {
                Dependencia dependencia = ptr.getData();
                if (dependencia.getTipo() == tipoSeleccionado) {
                        dep = dependencia;
                }
                ptr = ptr.getNext();
                
            }
        }
        return dep;
    }

    private void seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int M = fileChooser.showOpenDialog(this);

        if (M == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            archivo = archivoSeleccionado.getName();
            NombreArchivo.setText(archivo);            
            JOptionPane.showMessageDialog(this, "Se seleccionó el archivo " + archivoSeleccionado.getName() + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Encabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IniciarTrámiteImg = new javax.swing.JLabel();
        TextoVolver = new javax.swing.JLabel();
        Volver = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        IngresarAsunto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Enviar = new javax.swing.JButton();
        SelTipoDependencia = new javax.swing.JComboBox<>();
        SelSubtipoDependencia = new javax.swing.JComboBox<>();
        Seleccionar = new javax.swing.JButton();
        NombreArchivo = new javax.swing.JLabel();

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
        jLabel3.setText("Nuevo trámite");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/MenuNuevoTrámite.png"))); // NOI18N

        IniciarTrámiteImg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        IniciarTrámiteImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Nuevo trámite.png"))); // NOI18N
        IniciarTrámiteImg.setToolTipText("");

        TextoVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoVolver.setForeground(new java.awt.Color(255, 102, 0));
        TextoVolver.setText("Volver");

        Volver.setFont(new java.awt.Font("Segoe UI", 1, 5)); // NOI18N
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Atrás.png"))); // NOI18N
        Volver.setToolTipText("");
        Volver.setMaximumSize(new java.awt.Dimension(526, 446));
        Volver.setMinimumSize(new java.awt.Dimension(526, 446));
        Volver.setName(""); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Dependencia");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("Asunto");

        IngresarAsunto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IngresarAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarAsuntoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Documento referencia");

        Enviar.setBackground(new java.awt.Color(255, 153, 0));
        Enviar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        SelTipoDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        SelSubtipoDependencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        NombreArchivo.setText(archivo);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(IniciarTrámiteImg))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(SelTipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SelSubtipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(IngresarAsunto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                                .addComponent(Enviar)
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NombreArchivo)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoVolver))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(IniciarTrámiteImg)))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SelTipoDependencia)
                            .addComponent(SelSubtipoDependencia))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IngresarAsunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Seleccionar)
                            .addComponent(NombreArchivo))
                        .addGap(47, 47, 47)
                        .addComponent(Enviar)
                        .addGap(347, 347, 347)))
                .addContainerGap(560, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IngresarAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngresarAsuntoActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        nuevoTrámite();
    }//GEN-LAST:event_EnviarActionPerformed

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        seleccionarArchivo();
    }//GEN-LAST:event_SeleccionarActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoTrámite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoTrámite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoTrámite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoTrámite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Acceso acceso = new Acceso();
                new NuevoTrámite(acceso).setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Encabezado;
    private javax.swing.JButton Enviar;
    private javax.swing.JTextField IngresarAsunto;
    private javax.swing.JLabel IniciarTrámiteImg;
    private javax.swing.JLabel NombreArchivo;
    private javax.swing.JComboBox<String> SelSubtipoDependencia;
    private javax.swing.JComboBox<String> SelTipoDependencia;
    private javax.swing.JButton Seleccionar;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
