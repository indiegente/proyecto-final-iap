package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogManualUsuario extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 300;

    public DialogManualUsuario(JFrame parent) {
        super(parent, "Manual de Usuario", true);
        setLayout(null);

        JTextArea area = new JTextArea("Manual de usuario (simulado)\n\n1. Para vender, vaya a la pestaña Ventas...\n2. Para consultar productos, use Mantenimiento...");
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 350, 180);
        add(scroll);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(150, 220, 100, 30);
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
