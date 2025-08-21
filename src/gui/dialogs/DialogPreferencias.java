package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogPreferencias extends JDialog {
    public static final int ANCHO = 300;
    public static final int ALTO = 180;

    public DialogPreferencias(JFrame parent) {
        super(parent, "Preferencias", true);
        setLayout(null);

        JLabel lblEjemplo = new JLabel("Preferencia ejemplo:");
        lblEjemplo.setBounds(30, 30, 120, 25);
        add(lblEjemplo);

        JTextField txtEjemplo = new JTextField("Valor");
        txtEjemplo.setBounds(160, 30, 100, 25);
        add(txtEjemplo);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(40, 80, 100, 30);
        add(btnGuardar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(160, 80, 100, 30);
        add(btnCerrar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DialogPreferencias.this, "Preferencias guardadas (simulado).");
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
