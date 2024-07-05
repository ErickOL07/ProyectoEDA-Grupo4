package GUI.Personal;

import GUI.*;
import TDA.*;
import Trámites.*;
import Trámites._1_Inicio.Dependencia;
import Trámites._2_Registro.*;
import Trámites._4_Seguimiento.SistemaTramite;
import Trámites._6_Roles.*;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RegistrarFinalización extends javax.swing.JFrame {

    private Acceso acceso;
    
    public RegistrarFinalización(Acceso acceso) {
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

    private Expediente expediente = null;
    private String archivo = null;
    private String asunto;
    private String nombreDependencia;
    private String documentoReferencia;
    
    public void getExpediente() {
        
        ColaExpediente aux = new ColaExpediente();
        ColaExpediente nuevo = Datos.getSistema().getExpedientes();
        Expediente z = null;
        int c = 0, c2 = Integer.MAX_VALUE;
        while (!nuevo.estaVacia()) {
            z = nuevo.desencolar();
            aux.encolar(z);
            if (z.getDependencia() == Datos.buscarDependencia(((Personal) acceso.usuarioActual()).getDependenciaID()) && c < c2) {
                expediente = z;
                AsuntoLabel.setText(expediente.getAsunto());
                DependenciaLabel.setText(expediente.getDependencia().toString());
                IdentificadorLabel1.setText(expediente.getId()); 
                DatosInteresadoLabel.setText(expediente.getDatosInteresado().verInfo());
                DocumentoReferenciaLabel.setText(expediente.getDocumentoReferencia());
                PanelMovimientos.setText(expediente.mostrarMovimientos());
                if (expediente.isPrioridad()) {
                    jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Advertencia.png")));
                    jLabel8.setText("Expediente prioritario");
                }
                Registrar.setEnabled(true);
                c2 = c + 1; 
                
            }
            c++;
        }
        while(!aux.estaVacia()){
            nuevo.encolar(aux.desencolar());
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
        jPanel2 = new javax.swing.JPanel();
        DependenciaLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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
        IdentificadorLabel1 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        PanelMovimientos = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();

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
        RegistrarFinalización.setSelected(true);
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
        RegistrarIngreso.setText("Ingreso");
        RegistrarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarIngresoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Registrar finalización");

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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/RegistrarFinalización.png"))); // NOI18N

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

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Datos del interesado:");
        jLabel9.setToolTipText("");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        DatosInteresadoLabel.setEditable(false);
        DatosInteresadoLabel.setColumns(20);
        DatosInteresadoLabel.setRows(3);
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
        Registrar.setEnabled(false);
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        IdentificadorLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        IdentificadorLabel.setForeground(new java.awt.Color(204, 102, 0));
        IdentificadorLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IdentificadorLabel.setText("Expediente ID: ");
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

        IdentificadorLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        IdentificadorLabel1.setForeground(new java.awt.Color(204, 102, 0));
        IdentificadorLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IdentificadorLabel1.setText("");
        IdentificadorLabel1.setToolTipText("");

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        PanelMovimientos.setEditable(false);
        PanelMovimientos.setColumns(20);
        PanelMovimientos.setRows(3);
        jScrollPane15.setViewportView(PanelMovimientos);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 102, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Movimientos:");
        jLabel14.setToolTipText("");

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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DependenciaLabel)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(IdentificadorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IdentificadorLabel1))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Registrar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(DocumentoReferenciaLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(AsuntoLabel))
                            .addComponent(jLabel9)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(DependenciaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IdentificadorLabel)
                            .addComponent(IdentificadorLabel1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(AsuntoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(DocumentoReferenciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Registrar)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TextoVolver)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(341, 341, 341))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16)))
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 317, Short.MAX_VALUE)))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextoVolver)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel1)
                                .addGap(75, 75, 75))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RegistrarIngreso)
                                .addGap(64, 64, 64)
                                .addComponent(RegistrarMovimiento)
                                .addGap(70, 70, 70)
                                .addComponent(RegistrarFinalización)
                                .addGap(77, 77, 77)
                                .addComponent(IniciarTrámitePersonal)
                                .addGap(98, 98, 98)))
                        .addGap(392, 392, 392))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarFinalizaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarFinalizaciónActionPerformed
        RegistrarFinalización.setSelected(true);
    }//GEN-LAST:event_RegistrarFinalizaciónActionPerformed

    private void RegistrarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarMovimientoActionPerformed
        RegistrarMovimiento RegistrarMovimientoFrame = new RegistrarMovimiento(acceso);
        RegistrarMovimientoFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegistrarMovimientoActionPerformed

    private void RegistrarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarIngresoActionPerformed
        RegistrarIngreso RegistrarIngresoFrame = new RegistrarIngreso(acceso);
        RegistrarIngresoFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegistrarIngresoActionPerformed

    private void IniciarTrámitePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarTrámitePersonalActionPerformed
        VistaInteresado VistaInteresadoFrame = new VistaInteresado(acceso);
        VistaInteresadoFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_IniciarTrámitePersonalActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        Datos.sistema.finalizarExpediente(this.expediente.getId());
        JOptionPane.showMessageDialog(this, "Expediente finalizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        RegistrarFinalización RegistrarFinalizaciónFrame = new RegistrarFinalización(acceso);
        RegistrarFinalizaciónFrame.setVisible(true);
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
            java.util.logging.Logger.getLogger(RegistrarFinalización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarFinalización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarFinalización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarFinalización.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegistrarFinalización(acceso).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AsuntoLabel;
    private javax.swing.JTextArea DatosInteresadoLabel;
    private javax.swing.JTextArea DatosInteresadoLabel1;
    private javax.swing.JTextArea DatosInteresadoLabel10;
    private javax.swing.JTextArea DatosInteresadoLabel11;
    private javax.swing.JTextArea DatosInteresadoLabel12;
    private javax.swing.JTextArea DatosInteresadoLabel13;
    private javax.swing.JTextArea DatosInteresadoLabel2;
    private javax.swing.JTextArea DatosInteresadoLabel3;
    private javax.swing.JTextArea DatosInteresadoLabel4;
    private javax.swing.JTextArea DatosInteresadoLabel5;
    private javax.swing.JTextArea DatosInteresadoLabel6;
    private javax.swing.JTextArea DatosInteresadoLabel7;
    private javax.swing.JTextArea DatosInteresadoLabel8;
    private javax.swing.JTextArea DatosInteresadoLabel9;
    private javax.swing.JLabel DependenciaLabel;
    private javax.swing.JLabel DocumentoReferenciaLabel;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JLabel IdentificadorLabel;
    private javax.swing.JLabel IdentificadorLabel1;
    private javax.swing.JButton IniciarTrámitePersonal;
    private javax.swing.JTextArea PanelMovimientos;
    private javax.swing.JButton Registrar;
    private javax.swing.JRadioButton RegistrarFinalización;
    private javax.swing.JRadioButton RegistrarIngreso;
    private javax.swing.JRadioButton RegistrarMovimiento;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
