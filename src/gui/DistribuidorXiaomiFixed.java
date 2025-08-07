package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DistribuidorXiaomiFixed extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    // Campos del formulario - pestaña Consultar
    private JTextField txtPrecio;
    private JTextField txtPantalla;
    private JTextField txtRam;
    private JTextField txtRom;
    private JTextField txtCarga;
    
    // Campos del formulario - pestaña Modificar
    private JTextField txtPrecioModificar;
    private JTextField txtPantallaModificar;
    private JTextField txtRamModificar;
    private JTextField txtRomModificar;
    private JTextField txtCargaModificar;
    
    // Campos de ventas
    private JTextField txtPrecioVentas;
    
    // Campos de configuración - Descuentos
    private JTextField txtDescuento1a5;
    private JTextField txtDescuento6a10;
    private JTextField txtDescuento11a15;
    private JTextField txtDescuentoMas15;
    
    // Campos de configuración - Obsequios
    private JTextField txtObsequio1;
    private JTextField txtObsequio2a5;
    private JTextField txtObsequio6mas;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DistribuidorXiaomiFixed frame = new DistribuidorXiaomiFixed();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DistribuidorXiaomiFixed() {
        initializeComponents();
        setupEventHandlers();
    }
    
    private void initializeComponents() {
        setTitle("TIENDA DISTRIBUIDORA XIAOMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(36, 33, 550, 400);
        contentPane.add(tabbedPane);
        
        // Crear todas las pestañas
        createArchivoTab(tabbedPane);
        createMantenimientoTab(tabbedPane);
        createVentasTab(tabbedPane);
        createConfiguracionTab(tabbedPane);
        createAyudaTab(tabbedPane);
    }
    
    private void createArchivoTab(JTabbedPane tabbedPane) {
        JPanel panelArchivo = new JPanel();
        tabbedPane.addTab("Archivo", null, panelArchivo, null);
        panelArchivo.setLayout(null);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 150, 100, 30);
        panelArchivo.add(btnSalir);
    }
    
    private void createMantenimientoTab(JTabbedPane tabbedPane) {
        JPanel panelMantenimiento = new JPanel();
        tabbedPane.addTab("Mantenimiento", null, panelMantenimiento, null);
        panelMantenimiento.setLayout(null);
        
        JTabbedPane tabbedMantenimiento = new JTabbedPane(JTabbedPane.TOP);
        tabbedMantenimiento.setBounds(10, 11, 520, 350);
        panelMantenimiento.add(tabbedMantenimiento);
        
        // Sub-pestaña Consultar
        createConsultarTab(tabbedMantenimiento);
        
        // Sub-pestaña Modificar
        createModificarTab(tabbedMantenimiento);
        
        // Sub-pestaña Listar
        createListarTab(tabbedMantenimiento);
    }
    
    private void createConsultarTab(JTabbedPane tabbedMantenimiento) {
        JPanel panelConsultar = new JPanel();
        tabbedMantenimiento.addTab("Consultar", null, panelConsultar, null);
        panelConsultar.setLayout(null);
        
        // Modelo
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblModelo.setBounds(22, 22, 65, 14);
        panelConsultar.add(lblModelo);
        
        JComboBox<String> comboModelo = new JComboBox<>();
        comboModelo.setBounds(138, 19, 150, 22);
        panelConsultar.add(comboModelo);
        
        // Precio
        JLabel lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPrecio.setBounds(22, 55, 103, 14);
        panelConsultar.add(lblPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setBounds(138, 53, 150, 20);
        panelConsultar.add(txtPrecio);
        txtPrecio.setColumns(10);
        
        // Pantalla
        JLabel lblPantalla = new JLabel("Pantalla:");
        lblPantalla.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPantalla.setBounds(22, 88, 65, 14);
        panelConsultar.add(lblPantalla);
        
        txtPantalla = new JTextField();
        txtPantalla.setBounds(138, 86, 150, 20);
        panelConsultar.add(txtPantalla);
        txtPantalla.setColumns(10);
        
        // RAM
        JLabel lblRam = new JLabel("RAM:");
        lblRam.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblRam.setBounds(22, 121, 101, 14);
        panelConsultar.add(lblRam);
        
        txtRam = new JTextField();
        txtRam.setBounds(138, 119, 150, 20);
        panelConsultar.add(txtRam);
        txtRam.setColumns(10);
        
        // ROM
        JLabel lblRom = new JLabel("ROM:");
        lblRom.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblRom.setBounds(22, 154, 101, 14);
        panelConsultar.add(lblRom);
        
        txtRom = new JTextField();
        txtRom.setBounds(138, 152, 150, 20);
        panelConsultar.add(txtRom);
        txtRom.setColumns(10);
        
        // Carga rápida
        JLabel lblCarga = new JLabel("Carga rápida:");
        lblCarga.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCarga.setBounds(22, 187, 101, 14);
        panelConsultar.add(lblCarga);
        
        txtCarga = new JTextField();
        txtCarga.setBounds(138, 185, 150, 20);
        panelConsultar.add(txtCarga);
        txtCarga.setColumns(10);
        
        // Botones
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(320, 19, 100, 25);
        panelConsultar.add(btnCerrar);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(320, 52, 100, 25);
        panelConsultar.add(btnGuardar);
    }
    
    private void createModificarTab(JTabbedPane tabbedMantenimiento) {
        JPanel panelModificar = new JPanel();
        tabbedMantenimiento.addTab("Modificar", null, panelModificar, null);
        panelModificar.setLayout(null);
        
        // Similar estructura que Consultar pero con campos diferentes
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblModelo.setBounds(22, 22, 65, 14);
        panelModificar.add(lblModelo);
        
        JComboBox<String> comboModelo = new JComboBox<>();
        comboModelo.setBounds(138, 19, 150, 22);
        panelModificar.add(comboModelo);
        
        // Resto de campos similares...
        // (Por brevedad, no repito todo el código)
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(320, 19, 100, 25);
        panelModificar.add(btnCerrar);
        
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(320, 52, 100, 25);
        panelModificar.add(btnGuardar);
    }
    
    private void createListarTab(JTabbedPane tabbedMantenimiento) {
        JPanel panelListar = new JPanel();
        tabbedMantenimiento.addTab("Listar", null, panelListar, null);
        panelListar.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 480, 250);
        panelListar.add(scrollPane);
        
        JTextArea txtAreaListar = new JTextArea();
        scrollPane.setViewportView(txtAreaListar);
        
        JButton btnListar = new JButton("Listar");
        btnListar.setBounds(200, 275, 100, 25);
        panelListar.add(btnListar);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(320, 275, 100, 25);
        panelListar.add(btnCerrar);
    }
    
    private void createVentasTab(JTabbedPane tabbedPane) {
        JPanel panelVentas = new JPanel();
        tabbedPane.addTab("Ventas", null, panelVentas, null);
        panelVentas.setLayout(null);
        
        // Modelo
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblModelo.setBounds(32, 25, 65, 14);
        panelVentas.add(lblModelo);
        
        JComboBox<String> comboModelo = new JComboBox<>();
        comboModelo.setBounds(148, 22, 150, 22);
        panelVentas.add(comboModelo);
        
        // Precio
        JLabel lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblPrecio.setBounds(32, 58, 103, 14);
        panelVentas.add(lblPrecio);
        
        txtPrecioVentas = new JTextField();
        txtPrecioVentas.setBounds(148, 56, 150, 20);
        panelVentas.add(txtPrecioVentas);
        txtPrecioVentas.setColumns(10);
        
        // Cantidad
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblCantidad.setBounds(32, 91, 103, 14);
        panelVentas.add(lblCantidad);
        
        JSpinner spinnerCantidad = new JSpinner();
        spinnerCantidad.setBounds(148, 89, 150, 20);
        panelVentas.add(spinnerCantidad);
        
        // Botones
        JButton btnVender = new JButton("Vender");
        btnVender.setBounds(330, 22, 100, 25);
        panelVentas.add(btnVender);
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(330, 55, 100, 25);
        panelVentas.add(btnCerrar);
        
        // Área de texto para mostrar ventas
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 130, 500, 220);
        panelVentas.add(scrollPane);
        
        JTextArea txtAreaVentas = new JTextArea();
        scrollPane.setViewportView(txtAreaVentas);
    }
    
    private void createConfiguracionTab(JTabbedPane tabbedPane) {
        JPanel panelConfiguracion = new JPanel();
        tabbedPane.addTab("Configuración", null, panelConfiguracion, null);
        panelConfiguracion.setLayout(null);
        
        JTabbedPane tabbedConfiguracion = new JTabbedPane(JTabbedPane.TOP);
        tabbedConfiguracion.setBounds(10, 11, 520, 350);
        panelConfiguracion.add(tabbedConfiguracion);
        
        // Sub-pestaña Descuentos
        createDescuentosTab(tabbedConfiguracion);
        
        // Sub-pestaña Obsequios
        createObsequiosTab(tabbedConfiguracion);
    }
    
    private void createDescuentosTab(JTabbedPane tabbedConfiguracion) {
        JPanel panelDescuentos = new JPanel();
        tabbedConfiguracion.addTab("Descuentos", null, panelDescuentos, null);
        panelDescuentos.setLayout(null);
        
        // 1 a 5 unidades
        JLabel lbl1a5 = new JLabel("1 a 5 unidades:");
        lbl1a5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl1a5.setBounds(20, 40, 120, 14);
        panelDescuentos.add(lbl1a5);
        
        txtDescuento1a5 = new JTextField();
        txtDescuento1a5.setBounds(150, 38, 100, 20);
        panelDescuentos.add(txtDescuento1a5);
        
        JLabel lblPorcentaje1 = new JLabel("%");
        lblPorcentaje1.setBounds(260, 40, 20, 14);
        panelDescuentos.add(lblPorcentaje1);
        
        // 6 a 10 unidades
        JLabel lbl6a10 = new JLabel("6 a 10 unidades:");
        lbl6a10.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl6a10.setBounds(20, 75, 120, 14);
        panelDescuentos.add(lbl6a10);
        
        txtDescuento6a10 = new JTextField();
        txtDescuento6a10.setBounds(150, 73, 100, 20);
        panelDescuentos.add(txtDescuento6a10);
        
        JLabel lblPorcentaje2 = new JLabel("%");
        lblPorcentaje2.setBounds(260, 75, 20, 14);
        panelDescuentos.add(lblPorcentaje2);
        
        // 11 a 15 unidades
        JLabel lbl11a15 = new JLabel("11 a 15 unidades:");
        lbl11a15.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl11a15.setBounds(20, 110, 120, 14);
        panelDescuentos.add(lbl11a15);
        
        txtDescuento11a15 = new JTextField();
        txtDescuento11a15.setBounds(150, 108, 100, 20);
        panelDescuentos.add(txtDescuento11a15);
        
        JLabel lblPorcentaje3 = new JLabel("%");
        lblPorcentaje3.setBounds(260, 110, 20, 14);
        panelDescuentos.add(lblPorcentaje3);
        
        // Más de 15 unidades
        JLabel lblMas15 = new JLabel("Más de 15 unidades:");
        lblMas15.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblMas15.setBounds(20, 145, 120, 14);
        panelDescuentos.add(lblMas15);
        
        txtDescuentoMas15 = new JTextField();
        txtDescuentoMas15.setBounds(150, 143, 100, 20);
        panelDescuentos.add(txtDescuentoMas15);
        
        JLabel lblPorcentaje4 = new JLabel("%");
        lblPorcentaje4.setBounds(260, 145, 20, 14);
        panelDescuentos.add(lblPorcentaje4);
        
        // Botones
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(350, 38, 100, 25);
        panelDescuentos.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(350, 73, 100, 25);
        panelDescuentos.add(btnCancelar);
    }
    
    private void createObsequiosTab(JTabbedPane tabbedConfiguracion) {
        JPanel panelObsequios = new JPanel();
        tabbedConfiguracion.addTab("Obsequios", null, panelObsequios, null);
        panelObsequios.setLayout(null);
        
        // 1 unidad
        JLabel lbl1Unidad = new JLabel("1 unidad:");
        lbl1Unidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl1Unidad.setBounds(20, 40, 100, 14);
        panelObsequios.add(lbl1Unidad);
        
        txtObsequio1 = new JTextField();
        txtObsequio1.setBounds(130, 38, 150, 20);
        panelObsequios.add(txtObsequio1);
        
        // 2 a 5 unidades
        JLabel lbl2a5 = new JLabel("2 a 5 unidades:");
        lbl2a5.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl2a5.setBounds(20, 75, 100, 14);
        panelObsequios.add(lbl2a5);
        
        txtObsequio2a5 = new JTextField();
        txtObsequio2a5.setBounds(130, 73, 150, 20);
        panelObsequios.add(txtObsequio2a5);
        
        // 6 o más unidades
        JLabel lbl6Mas = new JLabel("6 o más unidades:");
        lbl6Mas.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl6Mas.setBounds(20, 110, 100, 14);
        panelObsequios.add(lbl6Mas);
        
        txtObsequio6mas = new JTextField();
        txtObsequio6mas.setBounds(130, 108, 150, 20);
        panelObsequios.add(txtObsequio6mas);
        
        // Botones
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(350, 38, 100, 25);
        panelObsequios.add(btnAceptar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(350, 73, 100, 25);
        panelObsequios.add(btnCancelar);
    }
    
    private void createAyudaTab(JTabbedPane tabbedPane) {
        JPanel panelAyuda = new JPanel();
        tabbedPane.addTab("Ayuda", null, panelAyuda, null);
        panelAyuda.setLayout(null);
        
        JLabel lblTitulo1 = new JLabel("Tienda distribuidora");
        lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
        lblTitulo1.setBounds(100, 30, 300, 31);
        panelAyuda.add(lblTitulo1);
        
        JLabel lblTitulo2 = new JLabel("XIAOMI");
        lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo2.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitulo2.setBounds(100, 70, 300, 31);
        panelAyuda.add(lblTitulo2);
        
        JLabel lblAutores = new JLabel("Autores");
        lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
        lblAutores.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblAutores.setBounds(200, 130, 100, 14);
        panelAyuda.add(lblAutores);
        
        String[] autores = {"Alfredo Condori", "Ever García", "Fiorela Quispe", "Jorge Bastidas"};
        int y = 160;
        for (String autor : autores) {
            JLabel lblAutor = new JLabel(autor);
            lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
            lblAutor.setFont(new Font("Times New Roman", Font.ITALIC, 16));
            lblAutor.setBounds(150, y, 200, 14);
            panelAyuda.add(lblAutor);
            y += 25;
        }
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(200, 280, 100, 25);
        panelAyuda.add(btnCerrar);
    }
    
    private void setupEventHandlers() {
        // Aquí puedes agregar los ActionListeners para los botones
        // Por ejemplo:
        // btnSalir.addActionListener(e -> System.exit(0));
    }
}