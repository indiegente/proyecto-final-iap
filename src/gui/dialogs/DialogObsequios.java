package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;

public class DialogObsequios extends JDialog {
    public static final int ANCHO = 350;
    public static final int ALTO = 200;

    public DialogObsequios(JFrame parent) {
        super(parent, "Configurar Obsequios", true);
        setLayout(null);

        JLabel lbl1 = new JLabel("1 unidad:");
        lbl1.setBounds(30, 30, 100, 25);
        add(lbl1);

        JTextField txt1 = new JTextField("Funda");
        txt1.setBounds(140, 30, 120, 25);
        add(txt1);

        JLabel lbl2a5 = new JLabel("2-5 unidades:");
        lbl2a5.setBounds(30, 60, 100, 25);
        add(lbl2a5);

        JTextField txt2a5 = new JTextField("Protector de pantalla");
        txt2a5.setBounds(140, 60, 120, 25);
        add(txt2a5);

        JLabel lbl6mas = new JLabel("6 o más:");
        lbl6mas.setBounds(30, 90, 100, 25);
        add(lbl6mas);

        JTextField txt6mas = new JTextField("Audífonos");
        txt6mas.setBounds(140, 90, 120, 25);
        add(txt6mas);

        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(60, 130, 100, 30);
        add(btnAceptar);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(180, 130, 100, 30);
        add(btnCerrar);

        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(DialogObsequios.this, "Obsequios guardados (simulado).");
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
