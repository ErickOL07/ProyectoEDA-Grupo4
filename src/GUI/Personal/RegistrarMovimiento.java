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

public class RegistrarMovimiento extends javax.swing.JFrame {

    private Acceso acceso;
    
    public RegistrarMovimiento(Acceso acceso) {
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
        
        
        SelSubtipoDependencia.setEnabled(false);
        
        obtenerTipos();
        obtenerSubtipos();
        SelTipoDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerSubtipos();
            }
        });
        getExpediente();
        setDependenciaID();
        condTrans();
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
    
    public void setDependenciaID() {
        if (expediente != null) {
            Dependencia dependencia = buscarDependenciaPorID(expediente.getDependencia().getID());
            if (dependencia != null) {
                SelTipoDependencia.setSelectedItem(dependencia.getTipo());
                obtenerSubtipos();
                SelSubtipoDependencia.setSelectedItem(dependencia.getSubTipo());
            }
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
    
    private void seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int M = fileChooser.showOpenDialog(this);

        if (M == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            archivo = archivoSeleccionado.getName();
            NombreArchivo.setText(archivo);            
            JOptionPane.showMessageDialog(this, "Se seleccionó el archivo " + archivoSeleccionado.getName() + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            Registrar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo.", "Error", JOptionPane.ERROR_MESSAGE);
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
    
    public void condTrans() {
        
        if (this.expediente != null && this.obtenerDependencia() == this.expediente.getDependencia()) {
            Registrar.setEnabled(true);
        }
        
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
                if (expediente.isPrioridad()) {
                    jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/Advertencia.png")));
                    jLabel8.setText("Expediente prioritario");
                }
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
        jPanel1 = new javax.swing.JPanel();
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
        Seleccionar = new javax.swing.JButton();
        NombreArchivo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SelTipoDependencia = new javax.swing.JComboBox<>();
        SelSubtipoDependencia = new javax.swing.JComboBox<>();

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
        RegistrarMovimiento.setSelected(true);
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
        jLabel1.setText("Registrar movimiento");

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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/RegistrarMovimiento.png"))); // NOI18N

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

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        NombreArchivo.setText(archivo);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Adjuntar documento:");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 102, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Transferir expediente:");
        jLabel13.setToolTipText("");

        SelTipoDependencia.setToolTipText("");
        SelTipoDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelTipoDependenciaActionPerformed(evt);
            }
        });

        SelSubtipoDependencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelSubtipoDependenciaActionPerformed(evt);
            }
        });

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
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(Seleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NombreArchivo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(SelTipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SelSubtipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(DocumentoReferenciaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Seleccionar)
                        .addComponent(NombreArchivo))
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(SelSubtipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelTipoDependencia, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGap(272, 272, 272)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16)))
                        .addComponent(jLabel4)
                        .addGap(267, 267, 267)))
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
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarFinalizaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarFinalizaciónActionPerformed
        RegistrarFinalización RegistrarFinalizaciónFrame = new RegistrarFinalización(acceso);
        RegistrarFinalizaciónFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegistrarFinalizaciónActionPerformed

    private void RegistrarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarMovimientoActionPerformed
        RegistrarMovimiento.setSelected(true);
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
        if (archivo != null || expediente.getDependencia() != this.obtenerDependencia()) {
            if (archivo != null) {
                Datos.sistema.agregarDocumento(expediente.getId(), archivo);
            }
            if (expediente.getDependencia() != this.obtenerDependencia()) {
                Datos.sistema.moverExpediente(expediente.getId(), this.obtenerDependencia());
            }
            JOptionPane.showMessageDialog(this, "Movimiento realizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            RegistrarMovimiento RegistrarIngresoFrame = new RegistrarMovimiento(acceso);
            RegistrarIngresoFrame.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se realizó ningún movimiento.", "Sin movimiento", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_RegistrarActionPerformed

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed
        seleccionarArchivo();
    }//GEN-LAST:event_SeleccionarActionPerformed

    private void SelTipoDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelTipoDependenciaActionPerformed
        
    }//GEN-LAST:event_SelTipoDependenciaActionPerformed

    private void SelSubtipoDependenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelSubtipoDependenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelSubtipoDependenciaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarMovimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Acceso acceso = new Acceso();
                new RegistrarMovimiento(acceso).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AsuntoLabel;
    private javax.swing.JTextArea DatosInteresadoLabel;
    private javax.swing.JLabel DependenciaLabel;
    private javax.swing.JLabel DocumentoReferenciaLabel;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JLabel IdentificadorLabel;
    private javax.swing.JLabel IdentificadorLabel1;
    private javax.swing.JButton IniciarTrámitePersonal;
    private javax.swing.JLabel NombreArchivo;
    private javax.swing.JButton Registrar;
    private javax.swing.JRadioButton RegistrarFinalización;
    private javax.swing.JRadioButton RegistrarIngreso;
    private javax.swing.JRadioButton RegistrarMovimiento;
    private javax.swing.JComboBox<String> SelSubtipoDependencia;
    private javax.swing.JComboBox<String> SelTipoDependencia;
    private javax.swing.JButton Seleccionar;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
