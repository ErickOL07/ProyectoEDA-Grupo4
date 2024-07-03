package GUI;

import GUI.Admin.*;
import TDA.Nodo;
import Trámites.*;
import Trámites._1_Inicio.*;
import Trámites._5_Interesados.*;
import Trámites._6_Roles.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class VistaAdmin extends javax.swing.JFrame {

    private Acceso acceso;
    private DefaultTableModel modeloTabla;
    private Usuario u;
    CuentasUsuarioAdmin CuentasUsuarioAdminFrame = new CuentasUsuarioAdmin(this);

    public VistaAdmin(Acceso acceso) {
        this.acceso = acceso;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ButtonGroup grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(AdminCuentasUsuario);
        grupoRadioButtons.add(AdminDependencias);
        grupoRadioButtons.add(AdminEmpleados);

        modeloTabla = new DefaultTableModel();
        jTable1.setModel(modeloTabla);
        
        Volver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Acceso AccesoFrame = new Acceso();
                AccesoFrame.setVisible(true);
                dispose();
            }
        });
        
        TextoVolver.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Acceso AccesoFrame = new Acceso();
                AccesoFrame.setVisible(true);
                dispose();
            }
        });
        
        this.u = null;
        
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int fila = jTable1.rowAtPoint(evt.getPoint());
                if (jTable1.getColumnCount() > 1) {
                    correo = jTable1.getValueAt(fila, 2).toString();
                    u = Datos.buscarUsuario(correo);
                    if (u instanceof Admin) {
                        CuentasUsuarioAdminFrame.setVisible(true);
                    }
                }
            }
        });
        
    }
    
    private void cargarCuentasUsuario() {
        crear = " cuenta de usuario";
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnIdentifiers(new String[]{"#", "Tipo", "Email"});

        Nodo<Usuario> ptr = Datos.listaUsuarios.getHead();
        int id = 1;
        while (ptr != null) {
            Usuario usuario = ptr.getData();
            String tipo = "Desconocido";
            if(usuario instanceof Admin) {tipo = "Administrador Sistema";}
            else if(usuario instanceof Institución || usuario instanceof Persona) {tipo = "Interesado";}
            else if(usuario instanceof Personal) {tipo = "Personal Depedencia";}
            modeloTabla.addRow(new Object[]{id, tipo, usuario.getCorreo()});
            ptr = ptr.getNext();
            id++;
        }
        
    }
    
    public void setAdmins() {
        
        if (u instanceof Admin) {
                        
            nombre = ((Admin) u).getNombre();
            apellido = ((Admin) u).getApellido();
            DNI = ((Admin) u).getDNI();
            contraseña = u.getContraseña();
            CuentasUsuarioAdminFrame.setNombre(nombre);
            CuentasUsuarioAdminFrame.setApellido(apellido);
            CuentasUsuarioAdminFrame.setDNI(DNI);
            CuentasUsuarioAdminFrame.setContraseña(contraseña);
        }
        
    }
    
    public String nombre = "", apellido = "", DNI = "", correo = "", contraseña = "", dependenciaID = "", tipo = "", subtipo = "", baseID = "", crear = "";

    private void cargarDependencias() {
        crear = " dependencia";
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnIdentifiers(new String[]{"#", "Dependencia", "Etiqueta"});

        Nodo<Dependencia> ptr = Datos.listaDependencias.getHead();
        int id = 1;
        while (ptr != null) {
            Dependencia dependencia = ptr.getData();
            modeloTabla.addRow(new Object[]{id, dependencia.toString(), dependencia.getID()});
            ptr = ptr.getNext();
            id++;
        }
    }

    private void cargarEmpleados() {
        crear = " empleado";
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnIdentifiers(new String[]{"#", "Nombre", "Dependencia"});
        
        Nodo<Usuario> ptr = Datos.listaUsuarios.getHead();
        int id = 1;
        while (ptr != null) {
            Usuario usuario = ptr.getData();
            if (usuario instanceof Personal) {
                Personal personal = (Personal) usuario;
                modeloTabla.addRow(new Object[]{id, personal.toString(), Datos.buscarDependencia(personal.getDependenciaID())});
                id++;
            }
            ptr = ptr.getNext();
        }
    }
    
    public static String extraerDNI(String personal) {
        int inicio = personal.indexOf('(') + 1;
        int fin = personal.indexOf(')');
        String dni = personal.substring(inicio, fin);
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getDependenciaID() {
        return dependenciaID;
    }

    public void setDependenciaID(String dependenciaID) {
        this.dependenciaID = dependenciaID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getBaseID() {
        return baseID;
    }

    public void setBaseID(String baseID) {
        this.baseID = baseID;
    }

    public String getCrear() {
        return crear;
    }

    public void setCrear(String crear) {
        this.crear = crear;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AdminCuentasUsuario = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        AdminDependencias = new javax.swing.JRadioButton();
        AdminEmpleados = new javax.swing.JRadioButton();
        Encabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        IniciarTrámitePersonal1 = new javax.swing.JButton();
        TextoVolver = new javax.swing.JLabel();
        Volver = new javax.swing.JLabel();
        IniciarTrámitePersonal2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AdminCuentasUsuario.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AdminCuentasUsuario.setText("Cuentas de usuario");
        AdminCuentasUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminCuentasUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Administrar");

        AdminDependencias.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AdminDependencias.setText("Dependencias");
        AdminDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminDependenciasActionPerformed(evt);
            }
        });

        AdminEmpleados.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        AdminEmpleados.setText("Empleados");
        AdminEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminEmpleadosActionPerformed(evt);
            }
        });

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/MenuAdmin.png"))); // NOI18N

        IniciarTrámitePersonal1.setBackground(new java.awt.Color(255, 153, 0));
        IniciarTrámitePersonal1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        IniciarTrámitePersonal1.setText("Iniciar trámite personal");
        IniciarTrámitePersonal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarTrámitePersonal1ActionPerformed(evt);
            }
        });

        TextoVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TextoVolver.setForeground(new java.awt.Color(255, 102, 0));
        TextoVolver.setText("Cerrar sesión");

        Volver.setFont(new java.awt.Font("Segoe UI", 1, 5)); // NOI18N
        Volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vectores/CerrarSesión.png"))); // NOI18N
        Volver.setToolTipText("");
        Volver.setMaximumSize(new java.awt.Dimension(526, 446));
        Volver.setMinimumSize(new java.awt.Dimension(526, 446));
        Volver.setName(""); // NOI18N

        IniciarTrámitePersonal2.setBackground(new java.awt.Color(0, 204, 51));
        IniciarTrámitePersonal2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        IniciarTrámitePersonal2.setText("Crear" + crear);
        IniciarTrámitePersonal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarTrámitePersonal2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(AdminEmpleados)
                                            .addComponent(AdminCuentasUsuario)
                                            .addComponent(AdminDependencias))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(IniciarTrámitePersonal1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(IniciarTrámitePersonal2))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TextoVolver)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextoVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AdminCuentasUsuario)
                                .addGap(39, 39, 39)
                                .addComponent(AdminDependencias)
                                .addGap(42, 42, 42)
                                .addComponent(AdminEmpleados))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(IniciarTrámitePersonal1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IniciarTrámitePersonal2))))
                    .addComponent(jLabel3))
                .addGap(222, 222, 222))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdminCuentasUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminCuentasUsuarioActionPerformed
        cargarCuentasUsuario();
    }//GEN-LAST:event_AdminCuentasUsuarioActionPerformed

    private void AdminDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminDependenciasActionPerformed
        cargarDependencias();
    }//GEN-LAST:event_AdminDependenciasActionPerformed

    private void AdminEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminEmpleadosActionPerformed
        cargarEmpleados();
    }//GEN-LAST:event_AdminEmpleadosActionPerformed

    private void IniciarTrámitePersonal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarTrámitePersonal1ActionPerformed
        VistaInteresado VistaInteresadoFrame = new VistaInteresado(acceso);
        VistaInteresadoFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_IniciarTrámitePersonal1ActionPerformed

    private void IniciarTrámitePersonal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarTrámitePersonal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IniciarTrámitePersonal2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            Acceso acceso = new Acceso();
                new VistaAdmin(acceso).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AdminCuentasUsuario;
    private javax.swing.JRadioButton AdminDependencias;
    private javax.swing.JRadioButton AdminEmpleados;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JButton IniciarTrámitePersonal1;
    private javax.swing.JButton IniciarTrámitePersonal2;
    private javax.swing.JLabel TextoVolver;
    private javax.swing.JLabel Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
