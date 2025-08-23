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
    private JTextField txtStock;
    private JLabel lblStock;

    public DialogModificarCelular(JFrame parent) {
        super(parent, "Modificar Celular", true);
        getContentPane().setLayout(null);
        
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
        getContentPane().add(lblSeleccionar);

        cboModelo = new JComboBox<>();
        // Agregamos los modelos individualmente sin usar arreglos
        cboModelo.addItem(Constants.obtenerModelo(0));
        cboModelo.addItem(Constants.obtenerModelo(1));
        cboModelo.addItem(Constants.obtenerModelo(2));
        cboModelo.addItem(Constants.obtenerModelo(3));
        cboModelo.setBounds(160, 30, 200, 25);
        getContentPane().add(cboModelo);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 70, 80, 25);
        getContentPane().add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        txtMarca.setBounds(160, 70, 200, 25);
        txtMarca.setEditable(true);
        getContentPane().add(txtMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 100, 80, 25);
        getContentPane().add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(160, 100, 200, 25);
        txtModelo.setEditable(true);
        getContentPane().add(txtModelo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 130, 80, 25);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(160, 130, 200, 25);
        txtPrecio.setEditable(true);
        getContentPane().add(txtPrecio);

        JLabel lblRAM = new JLabel("RAM (GB):");
        lblRAM.setBounds(30, 160, 80, 25);
        getContentPane().add(lblRAM);

        txtRAM = new JTextField();
        txtRAM.setBounds(160, 160, 200, 25);
        txtRAM.setEditable(true);
        getContentPane().add(txtRAM);

        JLabel lblAlmacenamiento = new JLabel("Almacenamiento:");
        lblAlmacenamiento.setBounds(30, 190, 120, 25);
        getContentPane().add(lblAlmacenamiento);

        txtAlmacenamiento = new JTextField();
        txtAlmacenamiento.setBounds(160, 190, 200, 25);
        txtAlmacenamiento.setEditable(true);
        getContentPane().add(txtAlmacenamiento);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(87, 269, 100, 30);
        getContentPane().add(btnGuardar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(207, 269, 100, 30);
        getContentPane().add(btnCerrar);
        
        txtStock = new JTextField();
        txtStock.setText("");
        txtStock.setEditable(true);
        txtStock.setBounds(160, 226, 200, 25);
        getContentPane().add(txtStock);
        
        lblStock = new JLabel("Stock:");
        lblStock.setBounds(30, 226, 120, 25);
        getContentPane().add(lblStock);
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
        
        txtMarca.setText(Constants.obtenerMarca(indiceActual));
        txtModelo.setText(Constants.obtenerModelo(indiceActual));
        txtPrecio.setText(String.valueOf(Constants.obtenerPrecio(indiceActual)));
        
        String ramStr = Constants.obtenerRAM(indiceActual);
        txtRAM.setText(ramStr.replace(" GB", ""));
        
        String almacenamientoStr = Constants.obtenerAlmacenamiento(indiceActual);
        txtAlmacenamiento.setText(almacenamientoStr.replace(" GB", ""));
        String stockStr = String.valueOf(Constants.obtenerStock(indiceActual));
        txtStock.setText(stockStr.replace(" unidades", ""));
        
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
            int stock = Integer.parseInt(txtStock.getText());
            
            actualizarConstantes(marca, modelo, precio, ram, almacenamiento, stock);
            
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
    
    private void actualizarConstantes(String marca, String modelo, double precio, int ram, int almacenamiento, int stock) {
        String ramConGB = ram + " GB";
        String almacenamientoConGB = almacenamiento + " GB";
        
        Constants.actualizarCelular(indiceActual, marca, modelo, precio, ramConGB, almacenamientoConGB, stock);
    }
}