package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import utils.Constants;
import utils.Validator;

public class DialogStocks extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 280;
    
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
        
        initComponents();
        setupEventListeners();
        cargarValoresActuales();
        
        setSize(400, 303);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblModelo1 = new JLabel("Redmi A3");
        lblModelo1.setBounds(30, 48, 120, 25);
        lblModelo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(lblModelo1);

        txtModelo1 = new JTextField();
        txtModelo1.setBounds(200, 48, 80, 25);
        txtModelo1.setHorizontalAlignment(JTextField.RIGHT);
        getContentPane().add(txtModelo1);
        
        JLabel lblPorciento1 = new JLabel("unidades");
        lblPorciento1.setBounds(290, 48, 96, 25);
        getContentPane().add(lblPorciento1);

        JLabel lblModelo2 = new JLabel("Redmi 12C ");
        lblModelo2.setBounds(30, 88, 120, 25);
        lblModelo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(lblModelo2);

        txtModelo2 = new JTextField();
        txtModelo2.setBounds(200, 88, 80, 25);
        txtModelo2.setHorizontalAlignment(JTextField.RIGHT);
        getContentPane().add(txtModelo2);

        JLabel lblModelo3 = new JLabel("Redmi Note 12");
        lblModelo3.setBounds(30, 128, 120, 25);
        lblModelo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(lblModelo3);

        txtModelo3 = new JTextField();
        txtModelo3.setBounds(200, 128, 80, 25);
        txtModelo3.setHorizontalAlignment(JTextField.RIGHT);
        getContentPane().add(txtModelo3);

        JLabel lblModelo4 = new JLabel("Redmi Note 13");
        lblModelo4.setBounds(30, 168, 120, 25);
        lblModelo4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(lblModelo4);

        txtModelo4 = new JTextField();
        txtModelo4.setBounds(200, 168, 80, 25);
        txtModelo4.setHorizontalAlignment(JTextField.RIGHT);
        getContentPane().add(txtModelo4);

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(80, 218, 100, 30);
        btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(btnAceptar);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(200, 218, 100, 30);
        btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
        getContentPane().add(btnCancelar);
        
        JLabel lblXiaomi = new JLabel("Xiaomi");
        lblXiaomi.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblXiaomi.setBounds(30, 11, 120, 25);
        getContentPane().add(lblXiaomi);
        
        JLabel lblPorciento1_1 = new JLabel("unidades");
        lblPorciento1_1.setBounds(290, 88, 96, 25);
        getContentPane().add(lblPorciento1_1);
        
        JLabel lblPorciento1_1_1 = new JLabel("unidades");
        lblPorciento1_1_1.setBounds(290, 128, 96, 25);
        getContentPane().add(lblPorciento1_1_1);
        
        JLabel lblPorciento1_1_2 = new JLabel("unidades");
        lblPorciento1_1_2.setBounds(290, 168, 96, 25);
        getContentPane().add(lblPorciento1_1_2);
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
                "Los stocks se han sido actualizados exitosamente.", 
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
    
    private void mostrarErrorRango(String campo, double min, double max) {
        JOptionPane.showMessageDialog(this, 
            String.format("El porcentaje para '%s' debe estar entre %.1f%% y %.1f%%", 
                campo, min, max), 
            "Error de Validación", 
            JOptionPane.ERROR_MESSAGE);
    }
    
    private void actualizarStocks(int s1, int s2, int s3, int s4) {
        Constants.actualizarStocks(s1, s2, s3, s4);
    }
}
