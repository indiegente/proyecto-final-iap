package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import utils.Constants;

public class DialogAcercaDe extends JDialog {
    public static final int ANCHO = 450;
    public static final int ALTO = 300;

    private JButton btnCerrar;

    public DialogAcercaDe(JFrame parent) {
        super(parent, "Acerca de Tienda", true);
        getContentPane().setLayout(null);

        // Fondo blanco limpio
        getContentPane().setBackground(Color.WHITE);

        initComponents();
        setupEventListeners();

        setSize(458, 325);
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    private void initComponents() {
        // Colores Xiaomi
        Color naranjaXiaomi = new Color(0xFF6900);
        Color grisOscuro = new Color(0x333333);

        // Título principal
        JLabel lblTitulo = new JLabel("Tienda Xiaomi 1.0");
        lblTitulo.setBounds(0, 30, ANCHO, 40);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setForeground(naranjaXiaomi);
        getContentPane().add(lblTitulo);

        // Línea separadora
        JSeparator separator = new JSeparator();
        separator.setBounds(50, 80, ANCHO - 100, 2);
        separator.setForeground(naranjaXiaomi);
        getContentPane().add(separator);

        // Sección Autores
        JLabel lblAutoresTitle = new JLabel("Autores");
        lblAutoresTitle.setBounds(0, 100, ANCHO, 25);
        lblAutoresTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutoresTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAutoresTitle.setForeground(grisOscuro);
        getContentPane().add(lblAutoresTitle);

        // Autor 1
        JLabel lblAutor1 = new JLabel(Constants.AUTOR_1);
        lblAutor1.setBounds(0, 135, ANCHO, 20);
        lblAutor1.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutor1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblAutor1.setForeground(Color.DARK_GRAY);
        getContentPane().add(lblAutor1);

        // Autor 2
        JLabel lblAutor2 = new JLabel(Constants.AUTOR_2);
        lblAutor2.setBounds(0, 155, ANCHO, 20);
        lblAutor2.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutor2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblAutor2.setForeground(Color.DARK_GRAY);
        getContentPane().add(lblAutor2);

        // Botón Cerrar (estilo Xiaomi)
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds((ANCHO - 100) / 2, 220, 100, 35);
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCerrar.setBackground(naranjaXiaomi);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setOpaque(true);
        getContentPane().add(btnCerrar);
    }

    private void setupEventListeners() {
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
