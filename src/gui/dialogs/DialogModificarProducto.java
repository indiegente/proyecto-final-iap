package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogModificarProducto extends JDialog {
    public static final int ANCHO = 350;
    public static final int ALTO = 250;

    public DialogModificarProducto(JFrame parent) {
        super(parent, "Modificar Producto", true);
        setLayout(null);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 30, 80, 25);
        add(lblModelo);

        JTextField txtModelo = new JTextField();
        txtModelo.setBounds(120, 30, 180, 25);
        add(txtModelo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 70, 80, 25);
        add(lblPrecio);

        JTextField txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 70, 180, 25);
        add(txtPrecio);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(60, 120, 100, 30);
        add(btnGuardar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(180, 120, 100, 30);
        add(btnCerrar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DialogModificarProducto.this, "Producto guardado (simulado).");
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
    }
}
