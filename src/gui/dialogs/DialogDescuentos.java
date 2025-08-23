package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import utils.Constants;
import utils.Validator;

public class DialogDescuentos extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 300;

    private JTextField txt1a5;
    private JTextField txt6a10;
    private JTextField txt11a15;
    private JTextField txtMas15;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public DialogDescuentos(JFrame parent) {
        super(parent, "Configurar Descuentos", true);
        getContentPane().setLayout(null);

        // 🎨 Colores Xiaomi
        Color naranjaXiaomi = new Color(0xFF6900);
        Color grisOscuro = new Color(0x333333);
        Color grisClaro = new Color(0xF5F5F5);

        // Fondo blanco
        getContentPane().setBackground(Color.WHITE);

        // Header naranja
        JPanel header = new JPanel();
        header.setBounds(0, 0, ANCHO, 50);
        header.setBackground(naranjaXiaomi);
        header.setLayout(null);

        JLabel lblTitulo = new JLabel("Configurar porcentajes de descuento", SwingConstants.CENTER);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblTitulo.setBounds(0, 0, ANCHO, 50);
        header.add(lblTitulo);

        getContentPane().add(header);

        // Campos con helper
        txt1a5 = crearCampo("1 a 5 unidades", 70, grisOscuro, grisClaro);
        txt6a10 = crearCampo("6 a 10 unidades", 110, grisOscuro, grisClaro);
        txt11a15 = crearCampo("11 a 15 unidades", 150, grisOscuro, grisClaro);
        txtMas15 = crearCampo("Más de 15 unidades", 190, grisOscuro, grisClaro);

        // Botón aceptar
        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 240, 100, 35);
        btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAceptar.setBackground(naranjaXiaomi);
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setBorderPainted(false);
        btnAceptar.setOpaque(true);
        getContentPane().add(btnAceptar);

        // Botón cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(220, 240, 100, 35);
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCancelar.setBackground(new Color(0xDDDDDD));
        btnCancelar.setForeground(Color.BLACK);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        btnCancelar.setOpaque(true);
        getContentPane().add(btnCancelar);

        setupEventListeners();
        cargarValoresActuales();

        setSize(407, 319);
        setLocationRelativeTo(parent);
        setResizable(false);
    }

    private JTextField crearCampo(String etiqueta, int y, Color colorTexto, Color fondoCampo) {
        JLabel lbl = new JLabel(etiqueta);
        lbl.setBounds(30, y, 150, 25);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lbl.setForeground(colorTexto);
        getContentPane().add(lbl);

        JTextField txt = new JTextField();
        txt.setBounds(200, y, 80, 25);
        txt.setHorizontalAlignment(JTextField.RIGHT);
        txt.setBackground(fondoCampo);
        txt.setForeground(Color.BLACK);
        txt.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txt.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        getContentPane().add(txt);

        JLabel lblPorciento = new JLabel("%");
        lblPorciento.setBounds(290, y, 20, 25);
        lblPorciento.setForeground(colorTexto);
        getContentPane().add(lblPorciento);

        return txt;
    }

    private void setupEventListeners() {
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDescuentos();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void cargarValoresActuales() {
        txt1a5.setText(String.valueOf(Constants.DESCUENTO_1_A_5));
        txt6a10.setText(String.valueOf(Constants.DESCUENTO_6_A_10));
        txt11a15.setText(String.valueOf(Constants.DESCUENTO_11_A_15));
        txtMas15.setText(String.valueOf(Constants.DESCUENTO_MAS_15));
    }

    private void guardarDescuentos() {
        if (!validarDatos()) {
            return;
        }

        try {
            double porcentaje1 = Double.parseDouble(txt1a5.getText().trim());
            double porcentaje2 = Double.parseDouble(txt6a10.getText().trim());
            double porcentaje3 = Double.parseDouble(txt11a15.getText().trim());
            double porcentaje4 = Double.parseDouble(txtMas15.getText().trim());

            if (!validarRangosPorcentajes(porcentaje1, porcentaje2, porcentaje3, porcentaje4)) {
                return;
            }

            actualizarConstantesDescuentos(porcentaje1, porcentaje2, porcentaje3, porcentaje4);

            JOptionPane.showMessageDialog(this,
                    "Los porcentajes de descuento han sido actualizados exitosamente.",
                    "Configuración Guardada",
                    JOptionPane.INFORMATION_MESSAGE);

            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Error: Todos los campos deben contener valores numéricos válidos.",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarDatos() {
        String[] campos = {
                txt1a5.getText().trim(),
                txt6a10.getText().trim(),
                txt11a15.getText().trim(),
                txtMas15.getText().trim()
        };

        String[] nombres = {
                "1 a 5 unidades",
                "6 a 10 unidades",
                "11 a 15 unidades",
                "Más de 15 unidades"
        };

        for (int i = 0; i < campos.length; i++) {
            if (!Validator.validarCampoNoVacio(campos[i], nombres[i])) {
                return false;
            }

            double porcentaje = Validator.validarPorcentajeDescuento(campos[i]);
            if (porcentaje == -1) {
                return false;
            }
        }

        return true;
    }

    private boolean validarRangosPorcentajes(double p1, double p2, double p3, double p4) {
        if (p1 < 0 || p1 > 50) {
            mostrarErrorRango("1 a 5 unidades", 0, 50);
            return false;
        }

        if (p2 < 0 || p2 > 50) {
            mostrarErrorRango("6 a 10 unidades", 0, 50);
            return false;
        }

        if (p3 < 0 || p3 > 50) {
            mostrarErrorRango("11 a 15 unidades", 0, 50);
            return false;
        }

        if (p4 < 0 || p4 > 50) {
            mostrarErrorRango("Más de 15 unidades", 0, 50);
            return false;
        }

        if (!(p1 <= p2 && p2 <= p3 && p3 <= p4)) {
            JOptionPane.showMessageDialog(this,
                    "Los porcentajes de descuento deben ser progresivos:\n" +
                            "1-5 unidades ≤ 6-10 unidades ≤ 11-15 unidades ≤ Más de 15 unidades",
                    "Error de Validación",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void mostrarErrorRango(String campo, double min, double max) {
        JOptionPane.showMessageDialog(this,
                String.format("El porcentaje para '%s' debe estar entre %.1f%% y %.1f%%",
                        campo, min, max),
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
    }

    private void actualizarConstantesDescuentos(double p1, double p2, double p3, double p4) {
        Constants.actualizarDescuentos(p1, p2, p3, p4);
    }
}
