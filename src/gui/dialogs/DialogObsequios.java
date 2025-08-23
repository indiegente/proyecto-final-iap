package gui.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.Constants;
import utils.Validator;

public class DialogObsequios extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 260;
    
    private JTextField txt1Unidad;
    private JTextField txt2a5Unidades;
    private JTextField txt6MasUnidades;
    private JButton btnAceptar;
    private JButton btnCancelar;

    private static final Color COLOR_NARANJA = new Color(255, 87, 34); // Xiaomi Orange
    private static final Color COLOR_GRIS_OSCURO = new Color(66, 66, 66);
    private static final Color COLOR_FONDO = Color.WHITE;

    public DialogObsequios(JFrame parent) {
        super(parent, "⚙️ Configurar Obsequios", true);
        getContentPane().setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);
        
        initComponents();
        setupEventListeners();
        cargarValoresActuales();
        
        setSize(400, 269);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblTitulo = new JLabel("Configuración de Obsequios");
        lblTitulo.setBounds(0, 10, ANCHO, 30);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setForeground(COLOR_NARANJA);
        getContentPane().add(lblTitulo);

        JLabel lbl1Unidad = new JLabel("1 unidad");
        lbl1Unidad.setBounds(30, 60, 120, 25);
        lbl1Unidad.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl1Unidad.setForeground(COLOR_GRIS_OSCURO);
        getContentPane().add(lbl1Unidad);

        txt1Unidad = new JTextField();
        txt1Unidad.setBounds(180, 60, 180, 25);
        txt1Unidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        getContentPane().add(txt1Unidad);

        JLabel lbl2a5Unidades = new JLabel("2 a 5 unidades");
        lbl2a5Unidades.setBounds(30, 100, 120, 25);
        lbl2a5Unidades.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl2a5Unidades.setForeground(COLOR_GRIS_OSCURO);
        getContentPane().add(lbl2a5Unidades);

        txt2a5Unidades = new JTextField();
        txt2a5Unidades.setBounds(180, 100, 180, 25);
        txt2a5Unidades.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        getContentPane().add(txt2a5Unidades);

        JLabel lbl6MasUnidades = new JLabel("6 a más unidades");
        lbl6MasUnidades.setBounds(30, 140, 140, 25);
        lbl6MasUnidades.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl6MasUnidades.setForeground(COLOR_GRIS_OSCURO);
        getContentPane().add(lbl6MasUnidades);

        txt6MasUnidades = new JTextField();
        txt6MasUnidades.setBounds(180, 140, 180, 25);
        txt6MasUnidades.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        getContentPane().add(txt6MasUnidades);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 190, 100, 32);
        btnAceptar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAceptar.setBackground(COLOR_NARANJA);
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        btnAceptar.setBorderPainted(false);
        getContentPane().add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(210, 190, 100, 32);
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCancelar.setBackground(new Color(189, 189, 189));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorderPainted(false);
        getContentPane().add(btnCancelar);
    }
    
    private void setupEventListeners() {
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarObsequios();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void cargarValoresActuales() {
        txt1Unidad.setText(Constants.OBSEQUIO_1_UNIDAD);
        txt2a5Unidades.setText(Constants.OBSEQUIO_2_A_5);
        txt6MasUnidades.setText(Constants.OBSEQUIO_6_MAS);
    }
    
    private void guardarObsequios() {
        if (!validarDatos()) {
            return;
        }
        
        String obsequio1 = txt1Unidad.getText().trim();
        String obsequio2a5 = txt2a5Unidades.getText().trim();
        String obsequio6Mas = txt6MasUnidades.getText().trim();
        
        Constants.actualizarObsequios(obsequio1, obsequio2a5, obsequio6Mas);
        
        JOptionPane.showMessageDialog(this, 
            "✅ Los obsequios han sido actualizados exitosamente.", 
            "Configuración Guardada", 
            JOptionPane.INFORMATION_MESSAGE);
        
        dispose();
    }
    
    private boolean validarDatos() {
        String obsequio1 = txt1Unidad.getText().trim();
        if (!Validator.validarObsequio(obsequio1)) {
            return false;
        }
        
        String obsequio2a5 = txt2a5Unidades.getText().trim();
        if (!Validator.validarObsequio(obsequio2a5)) {
            return false;
        }
        
        String obsequio6Mas = txt6MasUnidades.getText().trim();
        if (!Validator.validarObsequio(obsequio6Mas)) {
            return false;
        }
        
        if (!validarObsequiosRelevantes(obsequio1, obsequio2a5, obsequio6Mas)) {
            return false;
        }
        
        return true;
    }
    
    private boolean validarObsequiosRelevantes(String obsequio1, String obsequio2a5, String obsequio6Mas) {
        String[] obsequiosSugeridos = {
            "Funda", "Funda protectora", "Protector de pantalla", "Audífonos", 
            "Cargador", "Cable USB", "Soporte para celular", "PowerBank", 
            "Limpiador de pantalla", "Auriculares", "Memoria microSD", 
            "Adaptador", "Estuche", "Vidrio templado", "Holder vehicular"
        };
        
        boolean advertencia = false;
        String mensaje = "⚠️ Se recomienda usar obsequios relacionados con celulares:\n\n";
        
        if (!esObsequioRelevante(obsequio1, obsequiosSugeridos)) {
            mensaje += "• Para 1 unidad: " + obsequio1 + " (ej: Funda, Protector pantalla)\n";
            advertencia = true;
        }
        
        if (!esObsequioRelevante(obsequio2a5, obsequiosSugeridos)) {
            mensaje += "• Para 2-5 unidades: " + obsequio2a5 + " (ej: Audífonos, Cargador)\n";
            advertencia = true;
        }
        
        if (!esObsequioRelevante(obsequio6Mas, obsequiosSugeridos)) {
            mensaje += "• Para 6+ unidades: " + obsequio6Mas + " (ej: PowerBank, Kit completo)\n";
            advertencia = true;
        }
        
        if (advertencia) {
            mensaje += "\n¿Desea continuar con estos obsequios?";
            int respuesta = JOptionPane.showConfirmDialog(this, 
                mensaje, 
                "Advertencia: Obsequios no relacionados", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            return respuesta == JOptionPane.YES_OPTION;
        }
        
        return true;
    }
    
    private boolean esObsequioRelevante(String obsequio, String[] obsequiosSugeridos) {
        String obsequioLower = obsequio.toLowerCase();
        
        for (String sugerido : obsequiosSugeridos) {
            if (obsequioLower.contains(sugerido.toLowerCase()) || 
                sugerido.toLowerCase().contains(obsequioLower)) {
                return true;
            }
        }
        
        String[] palabrasClave = {"celular", "phone", "móvil", "movil", "pantalla", "carga", "audio", "usb"};
        for (String palabra : palabrasClave) {
            if (obsequioLower.contains(palabra)) {
                return true;
            }
        }
        
        return false;
    }
}
