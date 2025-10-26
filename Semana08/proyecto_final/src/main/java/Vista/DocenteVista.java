/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class DocenteVista extends javax.swing.JFrame {
    
    private DefaultTableModel modelo;
    /**
     * Creates new form DocenteVista
     */
    public DocenteVista() {
        initComponents();
        formulario();
    }

    private void formulario() {
        setTitle("Gestión de Tareas - Docente");
    setSize(850, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    // 🎨 Colores y fuente
    Color fondoPrincipal = new Color(18, 18, 18);
    Color panelOscuro = new Color(28, 28, 28);
    Color colorTexto = new Color(240, 240, 240);
    Color colorBoton = new Color(64, 64, 64);
    Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);
    Font fuenteNormal = new Font("Segoe UI", Font.PLAIN, 14);

    getContentPane().setBackground(fondoPrincipal);
    getContentPane().setLayout(new BorderLayout(10, 10));

    // 🧩 Panel superior (jPanel1)
    jPanel1.setBackground(panelOscuro);
    jPanel1.setLayout(new GridLayout(2, 1, 0, 5));
    jPanel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    lblBienvenido.setFont(fuenteTitulo);
    lblBienvenido.setForeground(new Color(0, 153, 255));
    lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
    lblBienvenido.setText("Bienvenido, Docente");

    lblGestionTareasEstudiante.setFont(fuenteNormal);
    lblGestionTareasEstudiante.setForeground(colorTexto);
    lblGestionTareasEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
    lblGestionTareasEstudiante.setText("Gestión de tareas de los estudiantes");

    jPanel1.add(lblBienvenido);
    jPanel1.add(lblGestionTareasEstudiante);

    // 🔍 Panel de búsqueda y tabla (jPanel2)
    jPanel2.setBackground(fondoPrincipal);
    jPanel2.setLayout(new BorderLayout(10, 10));
    jPanel2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

    JPanel panelFiltros = new JPanel(new GridLayout(2, 3, 10, 10));
    panelFiltros.setBackground(fondoPrincipal);

    lblBuscarxNombre.setFont(fuenteNormal);
    lblBuscarxNombre.setForeground(colorTexto);
    lblBuscarxNombre.setText("Buscar por nombre:");

    txtBuscar.setBackground(panelOscuro);
    txtBuscar.setForeground(colorTexto);
    txtBuscar.setCaretColor(Color.WHITE);
    txtBuscar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

    btnBuscar.setBackground(colorBoton);
    btnBuscar.setForeground(colorTexto);
    btnBuscar.setFocusPainted(false);
    btnBuscar.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
    btnBuscar.setText("Buscar");

    lblBuscarxEstado.setFont(fuenteNormal);
    lblBuscarxEstado.setForeground(colorTexto);
    lblBuscarxEstado.setText("Filtrar por estado:");

    cmbFiltroEstado.setBackground(panelOscuro);
    cmbFiltroEstado.setForeground(colorTexto);

    panelFiltros.add(lblBuscarxNombre);
    panelFiltros.add(txtBuscar);
    panelFiltros.add(btnBuscar);
    panelFiltros.add(lblBuscarxEstado);
    panelFiltros.add(cmbFiltroEstado);
    panelFiltros.add(new JLabel("")); // espacio vacío

    // 🧾 Tabla de tareas
    tablaTareas.setBackground(panelOscuro);
    tablaTareas.setForeground(colorTexto);
    tablaTareas.setFont(fuenteNormal);
    tablaTareas.setRowHeight(28);
    tablaTareas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
    tablaTareas.getTableHeader().setBackground(new Color(45, 45, 45));
    tablaTareas.getTableHeader().setForeground(Color.WHITE);

    scrollTareas.setViewportView(tablaTareas);
    scrollTareas.setBorder(BorderFactory.createLineBorder(panelOscuro, 1));
    scrollTareas.setPreferredSize(new Dimension(700, 250));

    jPanel2.add(panelFiltros, BorderLayout.NORTH);
    jPanel2.add(scrollTareas, BorderLayout.CENTER);

    // ⚙️ Panel inferior (botones)
    jPanel3.setBackground(panelOscuro);
    jPanel3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

    btnAvance.setBackground(colorBoton);
    btnAvance.setForeground(colorTexto);
    btnAvance.setFocusPainted(false);
    btnAvance.setText("Ver Avance");

    btnActualizar.setBackground(colorBoton);
    btnActualizar.setForeground(colorTexto);
    btnActualizar.setFocusPainted(false);
    btnActualizar.setText("Actualizar");

    btnSalir.setBackground(new Color(204, 0, 0));
    btnSalir.setForeground(colorTexto);
    btnSalir.setFocusPainted(false);
    btnSalir.setText("Salir");

    jPanel3.add(btnAvance);
    jPanel3.add(btnActualizar);
    jPanel3.add(btnSalir);

    // 🧱 Agregar los paneles al JFrame
    getContentPane().add(jPanel1, BorderLayout.NORTH);
    getContentPane().add(jPanel2, BorderLayout.CENTER);
    getContentPane().add(jPanel3, BorderLayout.SOUTH);

    revalidate();
    repaint();
        cmbFiltroEstado.addItem("Todos");
        cmbFiltroEstado.addItem("Pendiente");
        cmbFiltroEstado.addItem("En Proceso");
        cmbFiltroEstado.addItem("Completada");
        // === TABLA ===
        modelo = new DefaultTableModel(new Object[]{"Estudiante", "Nombre", "Descripción", "Fecha", "Estado"}, 0);
        tablaTareas.setModel(modelo);
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
        lblBienvenido = new javax.swing.JLabel();
        lblGestionTareasEstudiante = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblBuscarxNombre = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblBuscarxEstado = new javax.swing.JLabel();
        cmbFiltroEstado = new javax.swing.JComboBox<>();
        scrollTareas = new javax.swing.JScrollPane();
        tablaTareas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAvance = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));

        lblBienvenido.setForeground(new java.awt.Color(0, 255, 0));
        lblBienvenido.setText("Bienvenido docente, aquí vera las tareas de sus estudiantes");

        lblGestionTareasEstudiante.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGestionTareasEstudiante.setText("GESTIÓN DE TAREAS DE ESTUDIANTES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGestionTareasEstudiante)
                .addGap(192, 192, 192))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(lblGestionTareasEstudiante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        lblBuscarxNombre.setText("Buscar por nombre del estudiante:");

        btnBuscar.setText("Buscar");

        lblBuscarxEstado.setText("Buscar por estado de la tarea:");

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
        scrollTareas.setViewportView(tablaTareas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBuscarxNombre)
                            .addComponent(lblBuscarxEstado))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbFiltroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscarxNombre)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscarxEstado)
                    .addComponent(cmbFiltroEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(scrollTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        btnAvance.setBackground(new java.awt.Color(0, 0, 255));
        btnAvance.setForeground(new java.awt.Color(255, 255, 255));
        btnAvance.setText("Avance");

        btnActualizar.setBackground(new java.awt.Color(0, 0, 204));
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar");

        btnSalir.setBackground(new java.awt.Color(204, 0, 0));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getTextoBuscar() {
        return txtBuscar.getText();
    }

    public String getFiltroEstado() {
        return (String) cmbFiltroEstado.getSelectedItem();
    }

    public DefaultTableModel getModeloTabla() {
        return modelo;
    }

    // ===================== MÉTODOS DE UTILIDAD =====================

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarTabla() {
        modelo.setRowCount(0);
    }

    // ===================== LISTENERS =====================

    public void agregarBuscarListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
    }

    public void agregarActualizarListener(ActionListener listener) {
        btnActualizar.addActionListener(listener);
    }

    public void agregarAvanceListener(ActionListener listener) {
        btnAvance.addActionListener(listener);
    }

    public void agregarSalirListener(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }
    
    public JTable getTablaTareas() {
    return tablaTareas;
}

public DefaultTableModel getModelo() {
    return modelo;
}
public JButton getBtnBuscar() {
    return btnBuscar;
}
public JButton getBtnActualizar() {
    return btnActualizar;
}

public JButton getBtnAvance() {
    return btnAvance;
}

public JButton getBtnSalir() {
    return btnSalir;
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
            java.util.logging.Logger.getLogger(DocenteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocenteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocenteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocenteVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DocenteVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAvance;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbFiltroEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblBuscarxEstado;
    private javax.swing.JLabel lblBuscarxNombre;
    private javax.swing.JLabel lblGestionTareasEstudiante;
    private javax.swing.JScrollPane scrollTareas;
    private javax.swing.JTable tablaTareas;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
