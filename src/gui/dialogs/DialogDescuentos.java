package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogDescuentos extends JDialog {
    public static final int ANCHO = 350;
    public static final int ALTO = 250;

    public DialogDescuentos(JFrame parent) {
        super(parent, "Configurar Descuentos", true);
        setLayout(null);

        JLabel lbl1a5 = new JLabel("1-5 unidades:");
        lbl1a5.setBounds(30, 30, 100, 25);
        add(lbl1a5);

        JTextField txt1a5 = new JTextField("7.5");
        txt1a5.setBounds(140, 30, 60, 25);
        add(txt1a5);

        JLabel lbl6a10 = new JLabel("6-10 unidades:");
        lbl6a10.setBounds(30, 60, 100, 25);
        add(lbl6a10);

        JTextField txt6a10 = new JTextField("10.0");
        txt6a10.setBounds(140, 60, 60, 25);
        add(txt6a10);

        JLabel lbl11a15 = new JLabel("11-15 unidades:");
        lbl11a15.setBounds(30, 90, 100, 25);
        add(lbl11a15);

        JTextField txt11a15 = new JTextField("12.5");
        txt11a15.setBounds(140, 90, 60, 25);
        add(txt11a15);

        JLabel lblMas15 = new JLabel("Más de 15:");
        lblMas15.setBounds(30, 120, 100, 25);
        add(lblMas15);

        JTextField txtMas15 = new JTextField("15.0");
        txtMas15.setBounds(140, 120, 60, 25);
        add(txtMas15);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(60, 170, 100, 30);
        add(btnAceptar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(180, 170, 100, 30);
        add(btnCerrar);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DialogDescuentos.this, "Descuentos guardados (simulado).");
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
