package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
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

    // 🎨 Colores Xiaomi
    private final Color COLOR_PRIMARIO = new Color(255, 87, 34);   // Naranja fuerte
    private final Color COLOR_SECUNDARIO = new Color(33, 33, 33);  // Gris oscuro
    private final Color COLOR_FONDO = Color.WHITE;

    public DialogModificarCelular(JFrame parent) {
        super(parent, "Modificar Celular", true);
        getContentPane().setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);
        
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
        lblSeleccionar.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblSeleccionar);

        cboModelo = new JComboBox<>();
        cboModelo.addItem(Constants.obtenerModelo(0));
        cboModelo.addItem(Constants.obtenerModelo(1));
        cboModelo.addItem(Constants.obtenerModelo(2));
        cboModelo.addItem(Constants.obtenerModelo(3));
        cboModelo.setBounds(160, 30, 200, 25);
        cboModelo.setBackground(Color.WHITE);
        cboModelo.setForeground(COLOR_SECUNDARIO);
        cboModelo.setBorder(BorderFactory.createLineBorder(COLOR_PRIMARIO, 1));
        getContentPane().add(cboModelo);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 70, 80, 25);
        lblMarca.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblMarca);

        txtMarca = crearCampoTexto(160, 70);
        getContentPane().add(txtMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 100, 80, 25);
        lblModelo.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblModelo);

        txtModelo = crearCampoTexto(160, 100);
        getContentPane().add(txtModelo);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(30, 130, 80, 25);
        lblPrecio.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblPrecio);

        txtPrecio = crearCampoTexto(160, 130);
        getContentPane().add(txtPrecio);

        JLabel lblRAM = new JLabel("RAM (GB):");
        lblRAM.setBounds(30, 160, 80, 25);
        lblRAM.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblRAM);

        txtRAM = crearCampoTexto(160, 160);
        getContentPane().add(txtRAM);

        JLabel lblAlmacenamiento = new JLabel("Almacenamiento:");
        lblAlmacenamiento.setBounds(30, 190, 120, 25);
        lblAlmacenamiento.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblAlmacenamiento);

        txtAlmacenamiento = crearCampoTexto(160, 190);
        getContentPane().add(txtAlmacenamiento);

        lblStock = new JLabel("Stock:");
        lblStock.setBounds(30, 226, 120, 25);
        lblStock.setForeground(COLOR_SECUNDARIO);
        getContentPane().add(lblStock);

        txtStock = crearCampoTexto(160, 226);
        getContentPane().add(txtStock);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(87, 269, 100, 30);
        estilizarBoton(btnGuardar, COLOR_PRIMARIO);
        getContentPane().add(btnGuardar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(207, 269, 100, 30);
        estilizarBoton(btnCerrar, COLOR_SECUNDARIO);
        getContentPane().add(btnCerrar);
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

        // 🌟 Hover para botones
        agregarHover(btnGuardar, COLOR_PRIMARIO, COLOR_SECUNDARIO);
        agregarHover(btnCerrar, COLOR_SECUNDARIO, COLOR_PRIMARIO);
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

    // 🔧 Métodos utilitarios para estilos
    private JTextField crearCampoTexto(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 200, 25);
        txt.setBackground(Color.WHITE);
        txt.setForeground(COLOR_SECUNDARIO);
        txt.setBorder(BorderFactory.createLineBorder(COLOR_PRIMARIO, 1));
        return txt;
    }

    private void estilizarBoton(JButton boton, Color colorFondo) {
        boton.setBackground(colorFondo);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setFont(new Font("Tahoma", Font.BOLD, 12));
    }

    private void agregarHover(JButton boton, Color normal, Color hover) {
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBackground(hover);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBackground(normal);
            }
        });
    }
}
