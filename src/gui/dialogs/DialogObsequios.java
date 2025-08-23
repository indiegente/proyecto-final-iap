package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import utils.Constants;
import utils.Validator;

public class DialogObsequios extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 220;
    
    private JTextField txt1Unidad;
    private JTextField txt2a5Unidades;
    private JTextField txt6MasUnidades;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public DialogObsequios(JFrame parent) {
        super(parent, "Configurar obsequios", true);
        setLayout(null);
        
        initComponents();
        setupEventListeners();
        cargarValoresActuales();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lbl1Unidad = new JLabel("1 unidad");
        lbl1Unidad.setBounds(30, 40, 120, 25);
        lbl1Unidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbl1Unidad);

        txt1Unidad = new JTextField();
        txt1Unidad.setBounds(180, 40, 150, 25);
        add(txt1Unidad);

        JLabel lbl2a5Unidades = new JLabel("2 a 5 unidades");
        lbl2a5Unidades.setBounds(30, 80, 120, 25);
        lbl2a5Unidades.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbl2a5Unidades);

        txt2a5Unidades = new JTextField();
        txt2a5Unidades.setBounds(180, 80, 150, 25);
        add(txt2a5Unidades);

        JLabel lbl6MasUnidades = new JLabel("6 a más unidades");
        lbl6MasUnidades.setBounds(30, 120, 120, 25);
        lbl6MasUnidades.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(lbl6MasUnidades);

        txt6MasUnidades = new JTextField();
        txt6MasUnidades.setBounds(180, 120, 150, 25);
        add(txt6MasUnidades);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 160, 100, 30);
        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 160, 100, 30);
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(btnCancelar);
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
            "Los obsequios han sido actualizados exitosamente.", 
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
        String mensaje = "Se recomienda usar obsequios relacionados con celulares:\n\n";
        
        if (!esObsequioRelevante(obsequio1, obsequiosSugeridos)) {
            mensaje += "• Para 1 unidad: " + obsequio1 + " (considere: Funda, Protector pantalla)\n";
            advertencia = true;
        }
        
        if (!esObsequioRelevante(obsequio2a5, obsequiosSugeridos)) {
            mensaje += "• Para 2-5 unidades: " + obsequio2a5 + " (considere: Audífonos, Cargador)\n";
            advertencia = true;
        }
        
        if (!esObsequioRelevante(obsequio6Mas, obsequiosSugeridos)) {
            mensaje += "• Para 6+ unidades: " + obsequio6Mas + " (considere: PowerBank, Kit completo)\n";
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
