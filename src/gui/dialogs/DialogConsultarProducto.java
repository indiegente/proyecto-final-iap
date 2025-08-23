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

    public DialogConsultarProducto(JFrame parent) {
        super(parent, "Consultar Celular", true);
        setLayout(null);
        
        JLabel lblSeleccionar = new JLabel("Seleccionar Modelo:");
        lblSeleccionar.setBounds(30, 30, 120, 25);
        add(lblSeleccionar);

        cboModelo = new JComboBox<>();
        // Agregamos los modelos individualmente sin usar arreglos
        cboModelo.addItem(Constants.obtenerModelo(0));
        cboModelo.addItem(Constants.obtenerModelo(1));
        cboModelo.addItem(Constants.obtenerModelo(2));
        cboModelo.addItem(Constants.obtenerModelo(3));
        cboModelo.setBounds(160, 30, 200, 25);
        add(cboModelo);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(30, 70, 80, 25);
        add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.setBounds(160, 70, 200, 25);
        txtMarca.setEditable(false);
        add(txtMarca);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(30, 100, 80, 25);
        add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setBounds(160, 100, 200, 25);
        txtModelo.setEditable(false);
        add(txtModelo);

        JLabel lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setBounds(30, 130, 80, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(160, 130, 200, 25);
        txtPrecio.setEditable(false);
        add(txtPrecio);

        JLabel lblRAM = new JLabel("RAM (GB):");
        lblRAM.setBounds(30, 160, 80, 25);
        add(lblRAM);

        txtRAM = new JTextField();
        txtRAM.setBounds(160, 160, 200, 25);
        txtRAM.setEditable(false);
        add(txtRAM);

        JLabel lblAlmacenamiento = new JLabel("Almacenamiento (GB):");
        lblAlmacenamiento.setBounds(30, 190, 130, 25);
        add(lblAlmacenamiento);

        txtAlmacenamiento = new JTextField();
        txtAlmacenamiento.setBounds(160, 190, 200, 25);
        txtAlmacenamiento.setEditable(false);
        add(txtAlmacenamiento);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(160, 230, 100, 30);
        add(btnCerrar);

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

        setSize(ANCHO, ALTO);
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
    }
}
