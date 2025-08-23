package gui.dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import utils.Constants;
import utils.Validator;

public class DialogStocks extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 300;
    
    private JTextField txtModelo1;
    private JTextField txtModelo2;
    private JTextField txtModelo3;
    private JTextField txtModelo4;
    private JButton btnAceptar;
    private JButton btnCancelar;

    public DialogStocks(JFrame parent) {
        super(parent, "Configurar stocks", true);
        setTitle("Configurar stocks");
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo suave gris claro
        
        initComponents();
        setupEventListeners();
        cargarValoresActuales();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblXiaomi = new JLabel("📦 Configuración de Stocks Xiaomi");
        lblXiaomi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblXiaomi.setForeground(new Color(255, 87, 34)); // Naranja Xiaomi
        lblXiaomi.setBounds(50, 10, 300, 25);
        getContentPane().add(lblXiaomi);

        JLabel lblModelo1 = new JLabel("Redmi A3:");
        lblModelo1.setBounds(30, 50, 120, 25);
        lblModelo1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        getContentPane().add(lblModelo1);

        txtModelo1 = crearCampoTexto(200, 50);
        getContentPane().add(txtModelo1);

        JLabel lblPorciento1 = crearLabelUnidades(290, 50);
        getContentPane().add(lblPorciento1);

        JLabel lblModelo2 = new JLabel("Redmi 12C:");
        lblModelo2.setBounds(30, 90, 120, 25);
        lblModelo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        getContentPane().add(lblModelo2);

        txtModelo2 = crearCampoTexto(200, 90);
        getContentPane().add(txtModelo2);

        JLabel lblPorciento2 = crearLabelUnidades(290, 90);
        getContentPane().add(lblPorciento2);

        JLabel lblModelo3 = new JLabel("Redmi Note 12:");
        lblModelo3.setBounds(30, 130, 120, 25);
        lblModelo3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        getContentPane().add(lblModelo3);

        txtModelo3 = crearCampoTexto(200, 130);
        getContentPane().add(txtModelo3);

        JLabel lblPorciento3 = crearLabelUnidades(290, 130);
        getContentPane().add(lblPorciento3);

        JLabel lblModelo4 = new JLabel("Redmi Note 13:");
        lblModelo4.setBounds(30, 170, 120, 25);
        lblModelo4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        getContentPane().add(lblModelo4);

        txtModelo4 = crearCampoTexto(200, 170);
        getContentPane().add(txtModelo4);

        JLabel lblPorciento4 = crearLabelUnidades(290, 170);
        getContentPane().add(lblPorciento4);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 220, 100, 35);
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAceptar.setBackground(new Color(76, 175, 80)); // Verde
        btnAceptar.setForeground(Color.WHITE);
        btnAceptar.setFocusPainted(false);
        getContentPane().add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 220, 100, 35);
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCancelar.setBackground(new Color(244, 67, 54)); // Rojo
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        getContentPane().add(btnCancelar);
    }

    // Método para crear campos de texto con estilo uniforme
    private JTextField crearCampoTexto(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 80, 25);
        txt.setHorizontalAlignment(JTextField.RIGHT);
        txt.setFont(new Font("Courier New", Font.PLAIN, 13));
        txt.setBackground(new Color(255, 255, 255));
        txt.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        return txt;
    }

    // Método para etiquetas "unidades"
    private JLabel crearLabelUnidades(int x, int y) {
        JLabel lbl = new JLabel("unidades");
        lbl.setBounds(x, y, 80, 25);
        lbl.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lbl.setForeground(new Color(100, 100, 100));
        return lbl;
    }
    
    private void setupEventListeners() {
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarStocks();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void cargarValoresActuales() {
        txtModelo1.setText(String.valueOf(Constants.CELULAR_1_STOCK));
        txtModelo2.setText(String.valueOf(Constants.CELULAR_2_STOCK));
        txtModelo3.setText(String.valueOf(Constants.CELULAR_3_STOCK));
        txtModelo4.setText(String.valueOf(Constants.CELULAR_4_STOCK));
    }
    
    private void guardarStocks() {
        if (!validarDatos()) {
            return;
        }
        
        try {
            int stock1 = Integer.parseInt(txtModelo1.getText());
            int stock2 = Integer.parseInt(txtModelo2.getText());
            int stock3 = Integer.parseInt(txtModelo3.getText());
            int stock4 = Integer.parseInt(txtModelo4.getText());
            
            if (!validarStocks(stock1, stock2, stock3, stock4)) {
                return;
            }
            
            actualizarStocks(stock1, stock2, stock3, stock4);
            
            JOptionPane.showMessageDialog(this, 
                "✅ Los stocks han sido actualizados exitosamente.", 
                "Configuración Guardada", 
                JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "❌ Error: Todos los campos deben contener valores numéricos válidos.", 
                "Error de Formato", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validarDatos() {
        int[] campos = {
            Integer.parseInt(txtModelo1.getText().trim()),
            Integer.parseInt(txtModelo2.getText().trim()),
            Integer.parseInt(txtModelo3.getText().trim()),
            Integer.parseInt(txtModelo4.getText().trim())
        };
        
        String[] nombres = {
            "Modelo 1",
            "Modelo 2", 
            "Modelo 3",
            "Modelo 4"
        };
        
        for (int i = 0; i < campos.length; i++) {
            if (!Validator.validarCampoNoVacio(String.valueOf(campos[i]), nombres[i])) {
                return false;
            }
            
            double porcentaje = Validator.validarStock(campos[i]);
            if (porcentaje == -1) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean validarStocks(int s1, int s2, int s3, int s4) {
        Validator.validarStock(s1);
        Validator.validarStock(s2);
        Validator.validarStock(s3);
        Validator.validarStock(s4);
        return true;
    }
    
    private void actualizarStocks(int s1, int s2, int s3, int s4) {
        Constants.actualizarStocks(s1, s2, s3, s4);
    }
}
