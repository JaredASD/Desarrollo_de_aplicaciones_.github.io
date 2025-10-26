/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;


import Modelo.Usuario;
import Modelo.Tarea;
import Modelo.BaseDatosSimulada;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class EstudianteVista extends javax.swing.JFrame {
    private Usuario usuario;
    private DefaultTableModel modelo;
    
    public EstudianteVista(Usuario u) {
    initComponents();
    this.usuario = u; // ✅ ahora sí se guarda el usuario que viene del login
    setLocationRelativeTo(null);
    formulario();

    // Aquí puedes personalizar un mensaje de bienvenida, por ejemplo:
    JLabel lblBienvenida = new JLabel("Bienvenido, " + u.getNombreUsuario());
    lblBienvenida.setBounds(30, 30, 300, 30);
    add(lblBienvenida);
}


    /**
     * Creates new form EstudianteVista
     */
    public EstudianteVista() {
        initComponents();
    formulario();
    }
    // =================== CONFIGURACIÓN ===================
    private void formulario() {
         setTitle("Gestión de Tareas - Estudiante");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(900, 650);
    setLocationRelativeTo(null);
    setResizable(false);

    // 🎨 Paleta de colores
    Color fondoOscuro = new Color(23, 23, 28);
    Color acento = new Color(76, 132, 255);
    Color textoClaro = new Color(230, 230, 230);
    Color campoFondo = new Color(38, 38, 45);
    Color grisMedio = new Color(60, 60, 65);

    // 🧱 Panel principal
    jPanel1.setLayout(null);
    jPanel1.setBackground(fondoOscuro);

    // 🧩 Panel superior
    lblGestionTareas.setText("GESTIÓN DE TAREAS");
    lblGestionTareas.setFont(new Font("Segoe UI", Font.BOLD, 26));
    lblGestionTareas.setForeground(acento);
    lblGestionTareas.setHorizontalAlignment(SwingConstants.CENTER);
    lblGestionTareas.setBounds(0, 25, 900, 40);
    jPanel1.add(lblGestionTareas);

    lblAquiPuedesRegistrarTareas.setText("Aquí puedes registrar y administrar tus tareas");
    lblAquiPuedesRegistrarTareas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
    lblAquiPuedesRegistrarTareas.setForeground(Color.LIGHT_GRAY);
    lblAquiPuedesRegistrarTareas.setHorizontalAlignment(SwingConstants.CENTER);
    lblAquiPuedesRegistrarTareas.setBounds(0, 65, 900, 30);
    jPanel1.add(lblAquiPuedesRegistrarTareas);

    // 📋 Panel de formulario
    jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
    scrollTabla.setPreferredSize(new Dimension(600, 1000));
    tablaTareas.setPreferredSize(new Dimension(600, 1000));
    tablaTareas.setRowHeight(30);
    tablaTareas.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));tablaTareas.setRowHeight(30);
tablaTareas.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
tablaTareas.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
scrollTabla.setPreferredSize(new Dimension(700, 250));
jPanel2.add(scrollTabla);

    jPanel2.setBackground(new Color(30, 30, 37));
    jPanel2.setBounds(70, 110, 760, 260);
    jPanel2.setBorder(BorderFactory.createLineBorder(acento, 2, true));
    jPanel1.add(jPanel2);

    // 👤 Nombre
    lblNom.setText("Nombre:");
    lblNom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblNom.setForeground(textoClaro);
    lblNom.setBounds(40, 30, 150, 25);
    jPanel2.add(lblNom);

    txtNombre.setBounds(120, 30, 250, 30);
    txtNombre.setBackground(campoFondo);
    txtNombre.setForeground(textoClaro);
    txtNombre.setCaretColor(Color.WHITE);
    txtNombre.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    jPanel2.add(txtNombre);

    // 📅 Fecha
    lblFecha.setText("Fecha:");
    lblFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblFecha.setForeground(textoClaro);
    lblFecha.setBounds(410, 30, 100, 25);
    jPanel2.add(lblFecha);

    txtFecha.setBounds(470, 30, 230, 30);
    txtFecha.setBackground(campoFondo);
    txtFecha.setForeground(textoClaro);
    txtFecha.setCaretColor(Color.WHITE);
    txtFecha.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    jPanel2.add(txtFecha);

    // 🟢 Estado
    lblEstado.setText("Estado:");
    lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblEstado.setForeground(textoClaro);
    lblEstado.setBounds(40, 80, 100, 25);
    jPanel2.add(lblEstado);

    cmbEstado.setBounds(120, 80, 250, 30);
    cmbEstado.setBackground(campoFondo);
    cmbEstado.setForeground(textoClaro);
    cmbEstado.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    jPanel2.add(cmbEstado);

    // 📝 Descripción
    lblDesc.setText("Descripción:");
    lblDesc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblDesc.setForeground(textoClaro);
    lblDesc.setBounds(40, 130, 150, 25);
    jPanel2.add(lblDesc);

    txtDescripcion.setBackground(campoFondo);
    txtDescripcion.setForeground(textoClaro);
    txtDescripcion.setCaretColor(Color.WHITE);
    txtDescripcion.setLineWrap(true);
    txtDescripcion.setWrapStyleWord(true);
    txtDescripcion.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    jScrollPane1.setViewportView(txtDescripcion);
    jScrollPane1.setBounds(120, 130, 580, 90);
    jPanel2.add(jScrollPane1);

    // 📄 Título tabla
    lblTareasRegistradas.setText("TAREAS REGISTRADAS");
    lblTareasRegistradas.setFont(new Font("Segoe UI", Font.BOLD, 18));
    lblTareasRegistradas.setForeground(acento);
    lblTareasRegistradas.setBounds(70, 390, 300, 25);
    jPanel1.add(lblTareasRegistradas);

    // 🧮 Tabla
    scrollTabla.setBounds(70, 420, 760, 130);
    tablaTareas.setBackground(campoFondo);
    tablaTareas.setForeground(textoClaro);
    tablaTareas.setRowHeight(25);
    tablaTareas.setGridColor(acento);
    tablaTareas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    tablaTareas.getTableHeader().setBackground(acento);
    tablaTareas.getTableHeader().setForeground(Color.WHITE);
    tablaTareas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));cmbEstado.addItem("Pendiente");
        modelo = new DefaultTableModel(new Object[]{"Nombre", "Descripción", "Fecha", "Estado"}, 0);
        tablaTareas.setModel(modelo);
    jPanel2.add(scrollTabla);

    // 🔘 Panel inferior con botones
    jPanel3.setLayout(null);
    jPanel3.setBackground(fondoOscuro);
    jPanel3.setBounds(0, 570, 900, 60);
    jPanel1.add(jPanel3);

    int btnWidth = 130;
    int btnHeight = 35;
    int gap = 25;
    int startX = 85;

    JButton[] botones = {btnAgregar, btnCalcular, btnCompletar, btnEliminar, btnSalir};
    String[] textos = {"Agregar", "Calcular", "Completar", "Eliminar", "Salir"};
    Color[] colores = {
        acento,
        new Color(66, 122, 235),
        new Color(56, 172, 120),
        new Color(200, 60, 60),
        grisMedio
    };

    for (int i = 0; i < botones.length; i++) {
        botones[i].setText(textos[i]);
        botones[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
        botones[i].setForeground(Color.WHITE);
        botones[i].setBackground(colores[i]);
        botones[i].setFocusPainted(false);
        botones[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
        botones[i].setBounds(startX + (btnWidth + gap) * i, 10, btnWidth, btnHeight);
        jPanel3.add(botones[i]);
    }

    // 🌙 Hover efecto (opcional)
    for (JButton b : botones) {
        Color base = b.getBackground();
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b.setBackground(base.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b.setBackground(base);
            }
        });
    }
        cmbEstado.addItem("Pendiente");
        cmbEstado.addItem("En Proceso");
        
        add(jPanel1);
        add(jPanel2);
        add(jPanel3);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblGestionTareas = new javax.swing.JLabel();
        lblAquiPuedesRegistrarTareas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNom = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblTareasRegistradas = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnCompletar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        lblGestionTareas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGestionTareas.setText("GESTIÓN DE TAREAS");

        lblAquiPuedesRegistrarTareas.setForeground(new java.awt.Color(255, 255, 255));
        lblAquiPuedesRegistrarTareas.setText("Aquí puedes registrar las tareas que tienes ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAquiPuedesRegistrarTareas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGestionTareas)
                .addGap(348, 348, 348))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblGestionTareas)
                .addGap(18, 18, 18)
                .addComponent(lblAquiPuedesRegistrarTareas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        lblNom.setText("Nombre:");

        lblFecha.setText("Fecha:");

        lblEstado.setText("Estado:");

        lblDesc.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        lblTareasRegistradas.setText("TAREAS REGISTRADAS:");

        tablaTareas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollTabla.setViewportView(tablaTareas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNom)
                            .addComponent(lblFecha)
                            .addComponent(lblEstado)
                            .addComponent(lblDesc))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtFecha)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblTareasRegistradas)
                    .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNom)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFecha)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblEstado)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(lblTareasRegistradas)
                .addGap(28, 28, 28)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        btnCompletar.setBackground(new java.awt.Color(0, 0, 204));
        btnCompletar.setForeground(new java.awt.Color(255, 255, 255));
        btnCompletar.setText("Completar");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 204));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");

        btnCalcular.setBackground(new java.awt.Color(0, 0, 204));
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setText("Avanze");

        btnAgregar.setBackground(new java.awt.Color(0, 0, 204));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");

        btnSalir.setBackground(new java.awt.Color(204, 0, 0));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCompletar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public Usuario getUsuario() {
    return usuario;
    }
    public String getNombre() {
        return txtNombre.getText();
    }

    public String getDescripcion() {
        return txtDescripcion.getText();
    }

    public String getFecha() {
        return txtFecha.getText();
    }

    public String getEstado() {
        return (String) cmbEstado.getSelectedItem();
    }

    // -------- Métodos de utilidad --------
    public void limpiarCampos() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtFecha.setText("");
        cmbEstado.setSelectedIndex(0);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public void actualizarTabla(List<Tarea> tareas) {
        modelo.setRowCount(0); // limpiar
        for (Tarea t : tareas) {
            modelo.addRow(new Object[]{
                t.getNombre(), t.getDescripcion(), t.getFechaEntrega(), t.getEstado()
            });
        }
    }

    // ✅ Obtener la tarea seleccionada
    public String getTareaSeleccionada() {
        int fila = tablaTareas.getSelectedRow();
        if (fila != -1) {
            return (String) tablaTareas.getValueAt(fila, 0);
        }
        return null;
    }
    public DefaultTableModel getModeloTabla() {
        return modelo;
    }

    public JTable getTablaTareas() {
        return tablaTareas;
    }


    // -------- Métodos para asignar listeners --------
    public void agregarAgregarListener(ActionListener listener) {
        btnAgregar.addActionListener(listener);
    }

    public void agregarCompletarListener(ActionListener listener) {
        btnCompletar.addActionListener(listener);
    }
    
    public void agregarEliminarListener(ActionListener listener) {
        btnEliminar.addActionListener(listener);
    }

    public void agregarCalcularListener(ActionListener listener) {
        btnCalcular.addActionListener(listener);
    }

    public void agregarSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }
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
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstudianteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstudianteVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCompletar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAquiPuedesRegistrarTareas;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblGestionTareas;
    private javax.swing.JLabel lblNom;
    private javax.swing.JLabel lblTareasRegistradas;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaTareas;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
