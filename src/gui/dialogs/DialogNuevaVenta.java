package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogNuevaVenta extends JDialog {
    public static final int ANCHO = 350;
    public static final int ALTO = 250;

    public DialogNuevaVenta(JFrame parent) {
        super(parent, "Nueva Venta", true);
        setLayout(null);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 30, 80, 25);
        add(lblModelo);

        JTextField txtModelo = new JTextField();
        txtModelo.setBounds(120, 30, 180, 25);
        add(txtModelo);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 70, 80, 25);
        add(lblCantidad);

        JTextField txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 70, 180, 25);
        add(txtCantidad);

        JButton btnVender = new JButton("Vender");
        btnVender.setBounds(60, 120, 100, 30);
        add(btnVender);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(180, 120, 100, 30);
        add(btnCerrar);

        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DialogNuevaVenta.this, "Venta realizada (simulado).");
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
