package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import utils.Constants;

public class DialogConsultarProducto extends JDialog {
    public static final int ANCHO = 400;
    public static final int ALTO = 300;
    
    private JComboBox<String> cboModelo;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtPrecio;
    private JTextField txtRAM;
    private JTextField txtAlmacenamiento;
    private JTextField txtStock;

    public DialogConsultarProducto(JFrame parent) {
        super(parent, "Consultar Celular", true);
        getContentPane().setLayout(null);
        
        JLabel lblSeleccionar = new JLabel("Seleccionar Modelo:");
        lblSeleccionar.setBounds(30, 30, 120, 25);
        getContentPane().add(lblSeleccionar);

        cboModelo = new JComboBox<>();
        // Agregamos los modelos individualmente sin usar arreglos
        cboModelo.addItem(Constants.obtenerModelo(0));
        cboModelo.addItem(Constants.obtenerModelo(1));
        cboModelo.addItem(Constants.obtenerModelo(2));
        cboModelo.addItem(Constants.obtenerModelo(3));
        cboModelo.setBounds(187, 30, 200, 25);
        getContentPane().add(cboModelo);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 70, 80, 25);
        getContentPane().add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.setBounds(187, 70, 200, 25);
        txtMarca.setEditable(false);
        getContentPane().add(txtMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 100, 80, 25);
        getContentPane().add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(187, 100, 200, 25);
        txtModelo.setEditable(false);
        getContentPane().add(txtModelo);

        JLabel lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setBounds(30, 130, 80, 25);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(187, 130, 200, 25);
        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio);

        JLabel lblRAM = new JLabel("RAM (GB):");
        lblRAM.setBounds(30, 160, 80, 25);
        getContentPane().add(lblRAM);

        txtRAM = new JTextField();
        txtRAM.setBounds(187, 160, 200, 25);
        txtRAM.setEditable(false);
        getContentPane().add(txtRAM);

        JLabel lblAlmacenamiento = new JLabel("Almacenamiento (GB):");
        lblAlmacenamiento.setBounds(30, 190, 147, 25);
        getContentPane().add(lblAlmacenamiento);

        txtAlmacenamiento = new JTextField();
        txtAlmacenamiento.setBounds(187, 190, 200, 25);
        txtAlmacenamiento.setEditable(false);
        getContentPane().add(txtAlmacenamiento);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(158, 262, 100, 30);
        getContentPane().add(btnCerrar);
        
        JLabel lblStock = new JLabel("Stock:");
        lblStock.setBounds(30, 226, 147, 25);
        getContentPane().add(lblStock);
        
        txtStock = new JTextField();
        txtStock.setText("");
        txtStock.setEditable(false);
        txtStock.setBounds(187, 226, 200, 25);
        getContentPane().add(txtStock);

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

        setSize(426, 345);
        setLocationRelativeTo(parent);
        setResizable(false);
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
