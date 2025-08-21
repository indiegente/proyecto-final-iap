package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogAcercaDe extends JDialog {
    public static final int ANCHO = 350;
    public static final int ALTO = 200;

    public DialogAcercaDe(JFrame parent) {
        super(parent, "Acerca de...", true);
        setLayout(null);

        JLabel lblTitulo = new JLabel("TIENDA DISTRIBUIDORA XIAOMI");
        lblTitulo.setBounds(40, 20, 250, 25);
        add(lblTitulo);

        JLabel lblVersion = new JLabel("Versión: 1.0");
        lblVersion.setBounds(40, 50, 200, 25);
        add(lblVersion);

        JLabel lblAutores = new JLabel("Autores: Alfredo, Ever, Fiorela, Jorge");
        lblAutores.setBounds(40, 80, 250, 25);
        add(lblAutores);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(110, 120, 100, 30);
        add(btnCerrar);

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
    }
}
