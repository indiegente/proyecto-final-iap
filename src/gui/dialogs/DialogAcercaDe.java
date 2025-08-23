package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import utils.Constants;

public class DialogAcercaDe extends JDialog {
    public static final int ANCHO = 450;
    public static final int ALTO = 300;

    public DialogAcercaDe(JFrame parent) {
        super(parent, "Acerca de Tienda", true);
        setLayout(null);
        
        initComponents();
        setupEventListeners();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        // Título principal
        JLabel lblTitulo = new JLabel("Tienda 1.0");
        lblTitulo.setBounds(0, 30, ANCHO, 40);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(lblTitulo);
        
        // Línea separadora
        JSeparator separator = new JSeparator();
        separator.setBounds(50, 80, ANCHO - 100, 2);
        separator.setForeground(Color.GRAY);
        add(separator);
        
        // Sección Autores
        JLabel lblAutoresTitle = new JLabel("Autores");
        lblAutoresTitle.setBounds(0, 100, ANCHO, 25);
        lblAutoresTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutoresTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblAutoresTitle);
        
        // Autor 1
        JLabel lblAutor1 = new JLabel(Constants.AUTOR_1);
        lblAutor1.setBounds(0, 135, ANCHO, 20);
        lblAutor1.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutor1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lblAutor1);
        
        // Autor 2
        JLabel lblAutor2 = new JLabel(Constants.AUTOR_2);
        lblAutor2.setBounds(0, 155, ANCHO, 20);
        lblAutor2.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutor2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lblAutor2);
        
        // Autor 3
        JLabel lblAutor3 = new JLabel(Constants.AUTOR_3);
        lblAutor3.setBounds(0, 175, ANCHO, 20);
        lblAutor3.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutor3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lblAutor3);
        
        // Botón Cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds((ANCHO - 100) / 2, 240, 100, 30);
        btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(btnCerrar);
        
        // Referencia al evento
        this.btnCerrar = btnCerrar;
    }
    
    private JButton btnCerrar;
    
    private void setupEventListeners() {
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
