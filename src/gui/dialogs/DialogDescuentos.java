package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import utils.Constants;
import utils.Validator;

public class DialogDescuentos extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 280;
    
    private JTextField txt1a5;
    private JTextField txt6a10;
    private JTextField txt11a15;
    private JTextField txtMas15;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public DialogDescuentos(JFrame parent) {
        super(parent, "Configurar porcentajes de descuento", true);
        setLayout(null);
        
        initComponents();
        setupEventListeners();
        cargarValoresActuales();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lbl1a5 = new JLabel("1 a 5 unidades");
        lbl1a5.setBounds(30, 40, 120, 25);
        lbl1a5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbl1a5);

        txt1a5 = new JTextField();
        txt1a5.setBounds(200, 40, 80, 25);
        txt1a5.setHorizontalAlignment(JTextField.RIGHT);
        add(txt1a5);
        
        JLabel lblPorciento1 = new JLabel("%");
        lblPorciento1.setBounds(290, 40, 20, 25);
        add(lblPorciento1);

        JLabel lbl6a10 = new JLabel("6 a 10 unidades");
        lbl6a10.setBounds(30, 80, 120, 25);
        lbl6a10.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbl6a10);

        txt6a10 = new JTextField();
        txt6a10.setBounds(200, 80, 80, 25);
        txt6a10.setHorizontalAlignment(JTextField.RIGHT);
        add(txt6a10);
        
        JLabel lblPorciento2 = new JLabel("%");
        lblPorciento2.setBounds(290, 80, 20, 25);
        add(lblPorciento2);

        JLabel lbl11a15 = new JLabel("11 a 15 unidades");
        lbl11a15.setBounds(30, 120, 120, 25);
        lbl11a15.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbl11a15);

        txt11a15 = new JTextField();
        txt11a15.setBounds(200, 120, 80, 25);
        txt11a15.setHorizontalAlignment(JTextField.RIGHT);
        add(txt11a15);
        
        JLabel lblPorciento3 = new JLabel("%");
        lblPorciento3.setBounds(290, 120, 20, 25);
        add(lblPorciento3);

        JLabel lblMas15 = new JLabel("Más de 15 unidades");
        lblMas15.setBounds(30, 160, 120, 25);
        lblMas15.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lblMas15);

        txtMas15 = new JTextField();
        txtMas15.setBounds(200, 160, 80, 25);
        txtMas15.setHorizontalAlignment(JTextField.RIGHT);
        add(txtMas15);
        
        JLabel lblPorciento4 = new JLabel("%");
        lblPorciento4.setBounds(290, 160, 20, 25);
        add(lblPorciento4);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 210, 100, 30);
        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 210, 100, 30);
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(btnCancelar);
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
