package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import utils.Constants;

public class DialogConsultarProducto extends JDialog {
    public static final int ANCHO = 426;
    public static final int ALTO = 345;

    private JComboBox<String> cboModelo;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtPrecio;
    private JTextField txtRAM;
    private JTextField txtAlmacenamiento;
    private JTextField txtStock;
    private JButton btnCerrar;

    public DialogConsultarProducto(JFrame parent) {
        super(parent, "Consultar Celular", true);
        getContentPane().setLayout(null);

        // 🎨 Colores Xiaomi
        Color naranjaXiaomi = new Color(0xFF6900);
        Color grisOscuro = new Color(0x333333);
        Color grisClaro = new Color(0xEEEEEE);

        // Fondo blanco
        getContentPane().setBackground(Color.WHITE);

        // Etiqueta seleccionar modelo
        JLabel lblSeleccionar = new JLabel("Seleccionar Modelo:");
        lblSeleccionar.setBounds(30, 30, 150, 25);
        lblSeleccionar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblSeleccionar.setForeground(grisOscuro);
        getContentPane().add(lblSeleccionar);

        cboModelo = new JComboBox<>();
        cboModelo.addItem(Constants.obtenerModelo(0));
        cboModelo.addItem(Constants.obtenerModelo(1));
        cboModelo.addItem(Constants.obtenerModelo(2));
        cboModelo.addItem(Constants.obtenerModelo(3));
        cboModelo.setBounds(187, 30, 200, 25);
        cboModelo.setBackground(Color.WHITE);
        cboModelo.setForeground(grisOscuro);
        cboModelo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        getContentPane().add(cboModelo);

        // Campos de información
        txtMarca = crearCampo("Marca:", 70, grisOscuro, grisClaro);
        txtModelo = crearCampo("Modelo:", 100, grisOscuro, grisClaro);
        txtPrecio = crearCampo("Precio (S/):", 130, grisOscuro, grisClaro);
        txtRAM = crearCampo("RAM (GB):", 160, grisOscuro, grisClaro);
        txtAlmacenamiento = crearCampo("Almacenamiento (GB):", 190, grisOscuro, grisClaro);
        txtStock = crearCampo("Stock:", 226, grisOscuro, grisClaro);

        // Botón cerrar con estilo Xiaomi
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds((ANCHO - 100) / 2, 270, 100, 30);
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCerrar.setBackground(naranjaXiaomi);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setOpaque(true);
        getContentPane().add(btnCerrar);

        // Listeners
        cboModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarDatos();
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        actualizarDatos();

        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    // Método auxiliar para crear campos con etiquetas
    private JTextField crearCampo(String etiqueta, int y, Color colorTexto, Color fondoCampo) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setBounds(30, y, 150, 25);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(colorTexto);
        getContentPane().add(lbl);

        JTextField txt = new JTextField();
        txt.setBounds(187, y, 200, 25);
        txt.setEditable(false);
        txt.setBackground(fondoCampo);
        txt.setForeground(Color.BLACK);
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txt.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        getContentPane().add(txt);

        return txt;
    }

    private void actualizarDatos() {
        int indice = cboModelo.getSelectedIndex();
        txtMarca.setText(Constants.obtenerMarca(indice));
        txtModelo.setText(Constants.obtenerModelo(indice));
        txtPrecio.setText(Constants.MONEDA + " " + Constants.obtenerPrecio(indice));
        txtRAM.setText(Constants.obtenerRAM(indice));
        txtAlmacenamiento.setText(Constants.obtenerAlmacenamiento(indice));
        txtStock.setText(String.valueOf(Constants.obtenerStock(indice)));
    }
}
