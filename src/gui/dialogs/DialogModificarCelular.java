package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import utils.Constants;
import utils.Validator;

public class DialogModificarCelular extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 350;
    
    private JComboBox<String> cboModelo;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtPrecio;
    private JTextField txtRAM;
    private JTextField txtAlmacenamiento;
    private JButton btnGuardar;
    private JButton btnCerrar;
    
    private int indiceActual;

    public DialogModificarCelular(JFrame parent) {
        super(parent, "Modificar Celular", true);
        setLayout(null);
        
        initComponents();
        setupEventListeners();
        cargarPrimerModelo();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblSeleccionar = new JLabel("Seleccionar Modelo:");
        lblSeleccionar.setBounds(30, 30, 120, 25);
        add(lblSeleccionar);

        cboModelo = new JComboBox<>(Constants.CELULARES_MODELOS);
        cboModelo.setBounds(160, 30, 200, 25);
        add(cboModelo);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 70, 80, 25);
        add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.setBounds(160, 70, 200, 25);
        txtMarca.setEditable(true);
        add(txtMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 100, 80, 25);
        add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(160, 100, 200, 25);
        txtModelo.setEditable(true);
        add(txtModelo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 130, 80, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(160, 130, 200, 25);
        txtPrecio.setEditable(true);
        add(txtPrecio);

        JLabel lblRAM = new JLabel("RAM (GB):");
        lblRAM.setBounds(30, 160, 80, 25);
        add(lblRAM);

        txtRAM = new JTextField();
        txtRAM.setBounds(160, 160, 200, 25);
        txtRAM.setEditable(true);
        add(txtRAM);

        JLabel lblAlmacenamiento = new JLabel("Almacenamiento:");
        lblAlmacenamiento.setBounds(30, 190, 120, 25);
        add(lblAlmacenamiento);

        txtAlmacenamiento = new JTextField();
        txtAlmacenamiento.setBounds(160, 190, 200, 25);
        txtAlmacenamiento.setEditable(true);
        add(txtAlmacenamiento);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 250, 100, 30);
        add(btnGuardar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(220, 250, 100, 30);
        add(btnCerrar);
    }
    
    private void setupEventListeners() {
        cboModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarDatos();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void cargarPrimerModelo() {
        cboModelo.setSelectedIndex(0);
        actualizarDatos();
    }
    
    private void actualizarDatos() {
        indiceActual = cboModelo.getSelectedIndex();
        
        txtMarca.setText(Constants.CELULARES_MARCAS[indiceActual]);
        txtModelo.setText(Constants.CELULARES_MODELOS[indiceActual]);
        txtPrecio.setText(String.valueOf(Constants.CELULARES_PRECIOS[indiceActual]));
        
        String ramStr = Constants.CELULARES_RAM[indiceActual];
        txtRAM.setText(ramStr.replace(" GB", ""));
        
        String almacenamientoStr = Constants.CELULARES_ALMACENAMIENTO[indiceActual];
        txtAlmacenamiento.setText(almacenamientoStr.replace(" GB", ""));
    }
    
    private void guardarCambios() {
        if (!validarDatos()) {
            return;
        }
        
        try {
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int ram = Integer.parseInt(txtRAM.getText().trim());
            int almacenamiento = Integer.parseInt(txtAlmacenamiento.getText().trim());
            
            actualizarConstantes(marca, modelo, precio, ram, almacenamiento);
            
            JOptionPane.showMessageDialog(this, 
                Constants.EXITO_GUARDAR, 
                "Información", 
                JOptionPane.INFORMATION_MESSAGE);
            
            dispose();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Error en el formato de los datos numéricos", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validarDatos() {
        String marca = txtMarca.getText().trim();
        if (!Validator.validarCampoNoVacio(marca, "Marca")) {
            return false;
        }
        
        String modelo = txtModelo.getText().trim();
        if (!Validator.validarModelo(modelo)) {
            return false;
        }
        
        String precioStr = txtPrecio.getText().trim();
        double precio = Validator.validarPrecioString(precioStr);
        if (precio == -1) {
            return false;
        }
        
        String ramStr = txtRAM.getText().trim();
        try {
            int ram = Integer.parseInt(ramStr);
            if (ram <= 0 || ram > 32) {
                JOptionPane.showMessageDialog(this, 
                    "La RAM debe estar entre 1 y 32 GB", 
                    "Error de Validación", 
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "La RAM debe ser un número entero válido", 
                "Error de Validación", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String almacenamientoStr = txtAlmacenamiento.getText().trim();
        try {
            int almacenamiento = Integer.parseInt(almacenamientoStr);
            if (almacenamiento <= 0 || almacenamiento > 1024) {
                JOptionPane.showMessageDialog(this, 
                    "El almacenamiento debe estar entre 1 y 1024 GB", 
                    "Error de Validación", 
                    JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "El almacenamiento debe ser un número entero válido", 
                "Error de Validación", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void actualizarConstantes(String marca, String modelo, double precio, int ram, int almacenamiento) {
        switch (indiceActual) {
            case 0:
                updateCelular1(marca, modelo, precio, ram, almacenamiento);
                break;
            case 1:
                updateCelular2(marca, modelo, precio, ram, almacenamiento);
                break;
            case 2:
                updateCelular3(marca, modelo, precio, ram, almacenamiento);
                break;
            case 3:
                updateCelular4(marca, modelo, precio, ram, almacenamiento);
                break;
        }
    }
    
    private void updateCelular1(String marca, String modelo, double precio, int ram, int almacenamiento) {
        Constants.CELULARES_MARCAS[0] = marca;
        Constants.CELULARES_MODELOS[0] = modelo;
        Constants.CELULARES_PRECIOS[0] = precio;
        Constants.CELULARES_RAM[0] = ram + " GB";
        Constants.CELULARES_ALMACENAMIENTO[0] = almacenamiento + " GB";
    }
    
    private void updateCelular2(String marca, String modelo, double precio, int ram, int almacenamiento) {
        Constants.CELULARES_MARCAS[1] = marca;
        Constants.CELULARES_MODELOS[1] = modelo;
        Constants.CELULARES_PRECIOS[1] = precio;
        Constants.CELULARES_RAM[1] = ram + " GB";
        Constants.CELULARES_ALMACENAMIENTO[1] = almacenamiento + " GB";
    }
    
    private void updateCelular3(String marca, String modelo, double precio, int ram, int almacenamiento) {
        Constants.CELULARES_MARCAS[2] = marca;
        Constants.CELULARES_MODELOS[2] = modelo;
        Constants.CELULARES_PRECIOS[2] = precio;
        Constants.CELULARES_RAM[2] = ram + " GB";
        Constants.CELULARES_ALMACENAMIENTO[2] = almacenamiento + " GB";
    }
    
    private void updateCelular4(String marca, String modelo, double precio, int ram, int almacenamiento) {
        Constants.CELULARES_MARCAS[3] = marca;
        Constants.CELULARES_MODELOS[3] = modelo;
        Constants.CELULARES_PRECIOS[3] = precio;
        Constants.CELULARES_RAM[3] = ram + " GB";
        Constants.CELULARES_ALMACENAMIENTO[3] = almacenamiento + " GB";
    }
}