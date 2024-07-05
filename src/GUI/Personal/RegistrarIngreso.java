package GUI.Personal;

import GUI.*;
import TDA.*;
import Trámites.*;
import Trámites._2_Registro.*;
import Trámites._6_Roles.*;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class RegistrarIngreso extends javax.swing.JFrame {

    private Acceso acceso;
    
    public RegistrarIngreso(Acceso acceso) {
        this.acceso = acceso;
        initComponents();
        getExpediente();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        TextoVolver.addMouseListener(new MouseAdapter() {
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
    
    private Expediente expediente;
    private String asunto;
    private String nombreDependencia;
    private String identificador;
    private String documentoReferencia;
    
    public void getExpediente() {
        
        Cola<Expediente> aux = new Cola<>();
        int c = 0;
        while (!Datos.getExpedientesNuevos().esVacia()) {
            Expediente z = (Expediente) Datos.getExpedientesNuevos().desencolar();
            aux.encolar(z);
            if (z.getDependencia() == Datos.buscarDependencia(((Personal) acceso.usuarioActual()).getDependenciaID()) && c == 0) {
                System.out.println(z.getDependencia().toString() + " | " + Datos.buscarDependencia(((Personal) acceso.usuarioActual()).getDependenciaID()).toString());
                expediente = aux.desencolar();
                AsuntoLabel.setText(expediente.getAsunto());
                DependenciaLabel.setText(expediente.getDependencia().toString());
                identificador = Datos.getSistema().generarID(Datos.buscarDependencia(((Personal) acceso.usuarioActual()).getDependenciaID()));
                expediente.setId(identificador);
                IdentificadorLabel.setText(expediente.getId()); 
                DatosInteresadoLabel.setText(expediente.getDatosInteresado().verInfo());
                DocumentoReferenciaLabel.setText(expediente.getDocumentoReferencia());
                if (ExpedientePrioritario.isSelected()) {
                    expediente.setPrioridad(true);
                } else {
                    expediente.setPrioridad(false);
                }
                c++; 
            }
        }
        while(!aux.esVacia()){
            Datos.getExpedientesNuevos().encolar(aux.desencolar());
        }
        
    }
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Encabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        IniciarTrámitePersonal = new javax.swing.JButton();
        RegistrarFinalización = new javax.swing.JRadioButton();
        RegistrarMovimiento = new javax.swing.JRadioButton();
        RegistrarIngreso = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextoVolver = new javax.swing.JLabel();
        Volver = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        DependenciaLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ExpedientePrioritario = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DatosInteresadoLabel = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        IdentificadorLabel = new javax.swing.JLabel();
        AsuntoLabel = new javax.swing.JLabel();
        DocumentoReferenciaLabel = new javax.swing.JLabel();

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

        IniciarTrámitePersonal.setBackground(new java.awt.Color(255, 153, 0));
        IniciarTrámitePersonal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        IniciarTrámitePersonal.setText("Iniciar trámite personal");
        IniciarTrámitePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarTrámitePersonalActionPerformed(evt);
            }
        });

        RegistrarFinalización.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        RegistrarFinalización.setText("Finalización");
        RegistrarFinalización.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarFinalizaciónActionPerformed(evt);
            }
        });

        RegistrarMovimiento.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        RegistrarMovimiento.setText("Movimiento");
        RegistrarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarMovimientoActionPerformed(evt);
            }
        });

        RegistrarIngreso.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        RegistrarIngreso.setSelected(true);
        RegistrarIngreso.setText("Ingreso");
        RegistrarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarIngresoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Registrar ingreso");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/MenuPersonal.png"))); // NOI18N

        TextoVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoVolver.setForeground(new java.awt.Color(255, 102, 0));
        TextoVolver.setText("Cerrar sesión");

        Volver.setFont(new java.awt.Font("Segoe UI", 1, 5)); // NOI18N
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/CerrarSesión.png"))); // NOI18N
        Volver.setToolTipText("");
        Volver.setMaximumSize(new java.awt.Dimension(526, 446));
        Volver.setMinimumSize(new java.awt.Dimension(526, 446));
        Volver.setName(""); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/RegistrarIngreso.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 10, true));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(526, 526));

        DependenciaLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        DependenciaLabel.setForeground(new java.awt.Color(255, 102, 0));
        DependenciaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DependenciaLabel.setText(nombreDependencia);
        DependenciaLabel.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/EstrellaULima.png"))); // NOI18N
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Identificador:");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Prioridad:");
        jLabel8.setToolTipText("");

        ExpedientePrioritario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ExpedientePrioritario.setText("Expediente prioritario");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Datos del interesado:");
        jLabel9.setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        DatosInteresadoLabel.setEditable(false);
        DatosInteresadoLabel.setColumns(20);
        DatosInteresadoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DatosInteresadoLabel.setRows(5);
        jScrollPane1.setViewportView(DatosInteresadoLabel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Documento referencia:");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Asunto:");
        jLabel11.setToolTipText("");

        Registrar.setBackground(new java.awt.Color(255, 102, 0));
        Registrar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        IdentificadorLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        IdentificadorLabel.setForeground(new java.awt.Color(51, 51, 51));
        IdentificadorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IdentificadorLabel.setText(identificador);
        IdentificadorLabel.setToolTipText("");

        AsuntoLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AsuntoLabel.setForeground(new java.awt.Color(51, 51, 51));
        AsuntoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        AsuntoLabel.setText(asunto);
        AsuntoLabel.setToolTipText("");

        DocumentoReferenciaLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DocumentoReferenciaLabel.setForeground(new java.awt.Color(51, 51, 51));
        DocumentoReferenciaLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DocumentoReferenciaLabel.setText(documentoReferencia);
        DocumentoReferenciaLabel.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DependenciaLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(IdentificadorLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(DocumentoReferenciaLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(AsuntoLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(ExpedientePrioritario, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(Registrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(DependenciaLabel)))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(IdentificadorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(AsuntoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(ExpedientePrioritario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(DocumentoReferenciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(Registrar)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoVolver)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RegistrarFinalización)
                                    .addComponent(RegistrarMovimiento)
                                    .addComponent(RegistrarIngreso)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(IniciarTrámitePersonal)))
                        .addGap(36, 36, 36)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoVolver)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(270, 270, 270))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(RegistrarIngreso)
                                .addGap(64, 64, 64)
                                .addComponent(RegistrarMovimiento)
                                .addGap(70, 70, 70)
                                .addComponent(RegistrarFinalización)
                                .addGap(77, 77, 77)
                                .addComponent(IniciarTrámitePersonal)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jLabel3)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarFinalizaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarFinalizaciónActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarFinalizaciónActionPerformed

    private void RegistrarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarMovimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarMovimientoActionPerformed

    private void RegistrarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarIngresoActionPerformed

    private void IniciarTrámitePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarTrámitePersonalActionPerformed
        VistaInteresado VistaInteresadoFrame = new VistaInteresado(acceso);
        VistaInteresadoFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_IniciarTrámitePersonalActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        Datos.getSistema().registrarExpediente((Datos.buscarDependencia(((Personal) acceso.usuarioActual()).getDependenciaID())), expediente);
        
        RegistrarIngreso RegistrarIngresoFrame = new RegistrarIngreso(acceso);
        RegistrarIngresoFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarIngreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Acceso acceso = new Acceso();
                new RegistrarIngreso(acceso).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AsuntoLabel;
    private javax.swing.JTextArea DatosInteresadoLabel;
    private javax.swing.JLabel DependenciaLabel;
    private javax.swing.JLabel DocumentoReferenciaLabel;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JCheckBox ExpedientePrioritario;
    private javax.swing.JLabel IdentificadorLabel;
    private javax.swing.JButton IniciarTrámitePersonal;
    private javax.swing.JButton Registrar;
    private javax.swing.JRadioButton RegistrarFinalización;
    private javax.swing.JRadioButton RegistrarIngreso;
    private javax.swing.JRadioButton RegistrarMovimiento;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
