package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogHistorialVentas extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 300;

    public DialogHistorialVentas(JFrame parent) {
        super(parent, "Historial de Ventas", true);
        setLayout(null);

        JTextArea area = new JTextArea("Venta 1\nVenta 2\nVenta 3\n(Simulado)");
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
