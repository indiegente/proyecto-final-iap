package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogRespaldarDatos extends JDialog {
    public static final int ANCHO = 300;
    public static final int ALTO = 150;

    public DialogRespaldarDatos(JFrame parent) {
        super(parent, "Respaldar Datos", true);
        setLayout(null);

        JLabel label = new JLabel("Datos respaldados correctamente.");
        label.setBounds(30, 30, 250, 30);
        add(label);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(90, 70, 100, 30);
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
