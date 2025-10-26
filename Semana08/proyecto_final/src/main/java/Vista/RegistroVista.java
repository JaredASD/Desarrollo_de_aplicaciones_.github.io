/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author User
 */
public class RegistroVista extends javax.swing.JFrame {

    /**
     * Creates new form RegistroVista
     */
    public RegistroVista() {
        initComponents();
    formulario();
    }

    // =================== CONFIGURACIÓN ===================
    private void formulario() {
         setTitle("Registro - Sistema Académico");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(650, 500);
    setLocationRelativeTo(null);
    setResizable(false);

    // 🎨 Colores base
    Color fondoOscuro = new Color(23, 23, 28);
    Color acento = new Color(76, 132, 255);
    Color textoClaro = new Color(230, 230, 230);
    Color campoFondo = new Color(38, 38, 45);
    Color grisMedio = new Color(60, 60, 65);

    // 🌌 Fondo principal (panel base)
    jPanel1.setLayout(null);
    jPanel1.setBackground(fondoOscuro);

    // 🧱 Panel superior (título)
    jPanel2.setLayout(null);
    jPanel2.setBackground(fondoOscuro);
    jPanel2.setBounds(0, 20, 650, 60);
    jPanel1.add(jPanel2);

    lblRegistro.setText("CREAR NUEVA CUENTA");
    lblRegistro.setFont(new Font("Segoe UI", Font.BOLD, 22));
    lblRegistro.setForeground(acento);
    lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
    lblRegistro.setBounds(0, 10, 650, 40);
    jPanel2.add(lblRegistro);

    // 📋 Panel central (formulario)
    jPanel3.setLayout(null);
    jPanel3.setBackground(new Color(30, 30, 37));
    jPanel3.setBounds(160, 100, 330, 280);
    jPanel3.setBorder(BorderFactory.createLineBorder(acento, 2, true));
    jPanel1.add(jPanel3);

    // Subtítulo
    lblPorfavorRegistrese.setText("Por favor complete los campos");
    lblPorfavorRegistrese.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblPorfavorRegistrese.setForeground(Color.LIGHT_GRAY);
    lblPorfavorRegistrese.setHorizontalAlignment(SwingConstants.CENTER);
    lblPorfavorRegistrese.setBounds(50, 10, 230, 25);
    jPanel3.add(lblPorfavorRegistrese);

    // 👤 Usuario
    lblUsuario.setText("Usuario");
    lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblUsuario.setForeground(textoClaro);
    lblUsuario.setBounds(40, 50, 100, 25);
    jPanel3.add(lblUsuario);

    txtUsuario.setBounds(40, 75, 250, 30);
    txtUsuario.setBackground(campoFondo);
    txtUsuario.setForeground(textoClaro);
    txtUsuario.setCaretColor(Color.WHITE);
    txtUsuario.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    jPanel3.add(txtUsuario);

    // 🔑 Clave
    lblClave.setText("Contraseña");
    lblClave.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblClave.setForeground(textoClaro);
    lblClave.setBounds(40, 115, 100, 25);
    jPanel3.add(lblClave);

    txtClave.setBounds(40, 140, 250, 30);
    txtClave.setBackground(campoFondo);
    txtClave.setForeground(textoClaro);
    txtClave.setCaretColor(Color.WHITE);
    txtClave.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    jPanel3.add(txtClave);

    // ✅ Confirmar contraseña
    lblConfirmar.setText("Confirmar contraseña");
    lblConfirmar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
    lblConfirmar.setForeground(textoClaro);
    lblConfirmar.setBounds(40, 180, 200, 25);
    jPanel3.add(lblConfirmar);

    txtConfirmar.setBounds(40, 205, 250, 30);
    txtConfirmar.setBackground(campoFondo);
    txtConfirmar.setForeground(textoClaro);
    txtConfirmar.setCaretColor(Color.WHITE);
    txtConfirmar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    jPanel3.add(txtConfirmar);

    // 🔘 Botón registrar
    btnRegistrar.setText("Registrar");
    btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 15));
    btnRegistrar.setForeground(Color.WHITE);
    btnRegistrar.setBackground(acento);
    btnRegistrar.setFocusPainted(false);
    btnRegistrar.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnRegistrar.setBounds(100, 245, 130, 35);
    jPanel3.add(btnRegistrar);

    // Efecto hover
    btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            btnRegistrar.setBackground(new Color(66, 122, 235));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            btnRegistrar.setBackground(acento);
        }
    });

    // 🔙 Panel inferior
    jPanel4.setLayout(null);
    jPanel4.setBackground(fondoOscuro);
    jPanel4.setBounds(0, 400, 650, 50);
    jPanel1.add(jPanel4);

    btnVolver.setText("Volver");
    btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 13));
    btnVolver.setForeground(Color.WHITE);
    btnVolver.setBackground(grisMedio);
    btnVolver.setFocusPainted(false);
    btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
    btnVolver.setBounds(280, 10, 90, 30);
    jPanel4.add(btnVolver);
        // Opciones del combo
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
        jPanel2 = new javax.swing.JPanel();
        lblRegistro = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblPorfavorRegistrese = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblClave = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        lblConfirmar = new javax.swing.JLabel();
        txtConfirmar = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        lblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        lblRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRegistro.setText("REGISTRO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(lblRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lblRegistro)
                .addGap(27, 27, 27))
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        lblUsuario.setText("USUARIO");

        lblPorfavorRegistrese.setText("Porfavor registrese con el usuario y contraseña que usted quiera");

        lblClave.setText("CLAVE CREADA");

        btnRegistrar.setBackground(new java.awt.Color(0, 255, 204));
        btnRegistrar.setForeground(new java.awt.Color(204, 51, 255));
        btnRegistrar.setText("REGISTRARSE");

        lblConfirmar.setText("CONFIRMAR CLAVE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblPorfavorRegistrese))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(lblClave))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(lblConfirmar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(lblUsuario)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblPorfavorRegistrese)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblClave)
                .addGap(18, 18, 18)
                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblConfirmar)
                .addGap(36, 36, 36)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        btnVolver.setText("Volver");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnVolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getClave() {
        return new String(txtClave.getPassword());
    }

    public String getConfirmacion() {
        return new String(txtConfirmar.getPassword());
    }

    public void limpiarCampos() {
        txtUsuario.setText("");
        txtClave.setText("");
        txtConfirmar.setText("");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Listeners
    public void agregarRegistrarListener(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }

    public void agregarCancelarListener(ActionListener listener) {
        btnVolver.addActionListener(listener);
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
            java.util.logging.Logger.getLogger(RegistroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblConfirmar;
    private javax.swing.JLabel lblPorfavorRegistrese;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtConfirmar;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
