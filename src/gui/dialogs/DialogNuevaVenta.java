package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.text.DecimalFormat;
import utils.Constants;
import utils.Validator;

public class DialogNuevaVenta extends JDialog {
    public static final int ANCHO = 550;
    public static final int ALTO = 500;
    
    private JComboBox<String> cboModelo;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextArea areaBoleta;
    private JScrollPane scrollBoleta;
    private JButton btnVender;
    private JButton btnCerrar;
    
    private static int contadorVentas = 0;
    private static double importeTotalGeneral = 0.0;
    private static final double CUOTA_DIARIA = 5000.0;
    
    private DecimalFormat formatoMoneda = new DecimalFormat("0.00");

    public DialogNuevaVenta(JFrame parent) {
        super(parent, "Vender", true);
        setLayout(null);
        
        initComponents();
        setupEventListeners();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setBounds(30, 30, 80, 25);
        add(lblModelo);

        cboModelo = new JComboBox<>();
        // Agregamos los modelos individualmente sin usar arreglos
        cboModelo.addItem(Constants.obtenerModelo(0));
        cboModelo.addItem(Constants.obtenerModelo(1));
        cboModelo.addItem(Constants.obtenerModelo(2));
        cboModelo.addItem(Constants.obtenerModelo(3));
        cboModelo.setBounds(120, 30, 200, 25);
        add(cboModelo);

        JLabel lblPrecio = new JLabel("Precio(S/)");
        lblPrecio.setBounds(30, 70, 80, 25);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(120, 70, 200, 25);
        txtPrecio.setEditable(false);
        add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad");
        lblCantidad.setBounds(30, 110, 80, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 110, 200, 25);
        add(txtCantidad);

        btnVender = new JButton("Vender");
        btnVender.setBounds(350, 30, 80, 30);
        add(btnVender);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(350, 70, 80, 30);
        add(btnCerrar);

        JLabel lblBoleta = new JLabel("BOLETA DE VENTA");
        lblBoleta.setBounds(30, 150, 150, 25);
        lblBoleta.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(lblBoleta);

        areaBoleta = new JTextArea();
        areaBoleta.setEditable(false);
        areaBoleta.setFont(new Font("Courier New", Font.PLAIN, 11));
        areaBoleta.setText("Seleccione un modelo y cantidad para generar la boleta");
        
        scrollBoleta = new JScrollPane(areaBoleta);
        scrollBoleta.setBounds(30, 180, 480, 250);
        scrollBoleta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollBoleta);
        
        actualizarPrecio();
    }
    
    private void setupEventListeners() {
        cboModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarPrecio();
            }
        });

        btnVender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                procesarVenta();
            }
        });

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void actualizarPrecio() {
        int indice = cboModelo.getSelectedIndex();
        double precio = Constants.obtenerPrecio(indice);
        txtPrecio.setText(formatoMoneda.format(precio));
    }
    
    private void procesarVenta() {
        if (!validarDatos()) {
            return;
        }
        
        int indiceModelo = cboModelo.getSelectedIndex();
        int cantidad = Integer.parseInt(txtCantidad.getText().trim());
        
        String modelo = Constants.obtenerModelo(indiceModelo);
        double precioUnitario = Constants.obtenerPrecio(indiceModelo);
        
        double importeCompra = precioUnitario * cantidad;
        double porcentajeDescuento = Constants.obtenerDescuento(cantidad);
        double importeDescuento = importeCompra * (porcentajeDescuento / 100.0);
        double importeAPagar = importeCompra - importeDescuento;
        String obsequio = Constants.obtenerObsequio(cantidad);
        
        generarBoleta(modelo, precioUnitario, cantidad, importeCompra, 
                     porcentajeDescuento, importeDescuento, importeAPagar, obsequio);
        
        contadorVentas++;
        importeTotalGeneral += importeAPagar;
        
        if (contadorVentas % Constants.ALERTA_CADA_VENTAS == 0) {
            mostrarAlertaVentas();
        }
        
        txtCantidad.setText("");
    }
    
    private boolean validarDatos() {
        String cantidadStr = txtCantidad.getText().trim();
        
        if (!Validator.validarCampoNoVacio(cantidadStr, "Cantidad")) {
            return false;
        }
        
        int cantidad = Validator.validarCantidadString(cantidadStr);
        if (cantidad == -1) {
            return false;
        }
        
        return true;
    }
    
    private void generarBoleta(String modelo, double precioUnitario, int cantidad,
                              double importeCompra, double porcentajeDescuento,
                              double importeDescuento, double importeAPagar, String obsequio) {
        
        StringBuilder boleta = new StringBuilder();
        
        boleta.append("═══════════════════════════════════════════════════════\n");
        boleta.append("                    BOLETA DE VENTA\n");
        boleta.append("                TIENDA DISTRIBUIDORA XIAOMI\n");
        boleta.append("═══════════════════════════════════════════════════════\n\n");
        
        boleta.append("DATOS DE LA VENTA:\n");
        boleta.append("───────────────────────────────────────────────────────\n");
        boleta.append(String.format("Modelo                 : %s\n", modelo));
        boleta.append(String.format("Precio                 : %s %s\n", 
            Constants.MONEDA, formatoMoneda.format(precioUnitario)));
        boleta.append(String.format("Cantidad               : %d\n", cantidad));
        boleta.append(String.format("Importe Compra         : %s %s\n", 
            Constants.MONEDA, formatoMoneda.format(importeCompra)));
        
        boleta.append("\nDESCUENTOS Y BENEFICIOS:\n");
        boleta.append("───────────────────────────────────────────────────────\n");
        boleta.append(String.format("Descuento aplicado     : %.1f%%\n", porcentajeDescuento));
        boleta.append(String.format("Importe Descuento      : %s %s\n", 
            Constants.MONEDA, formatoMoneda.format(importeDescuento)));
        boleta.append(String.format("Importe a Pagar        : %s %s\n", 
            Constants.MONEDA, formatoMoneda.format(importeAPagar)));
        boleta.append(String.format("Obsequio               : %s\n", obsequio));
        
        boleta.append("\nRESUMEN DE DESCUENTOS:\n");
        boleta.append("───────────────────────────────────────────────────────\n");
        boleta.append("• 1 a 5 unidades       : " + Constants.DESCUENTO_1_A_5 + "%\n");
        boleta.append("• 6 a 10 unidades      : " + Constants.DESCUENTO_6_A_10 + "%\n");
        boleta.append("• 11 a 15 unidades     : " + Constants.DESCUENTO_11_A_15 + "%\n");
        boleta.append("• Más de 15 unidades   : " + Constants.DESCUENTO_MAS_15 + "%\n");
        
        boleta.append("\nOBSEQUIOS DISPONIBLES:\n");
        boleta.append("───────────────────────────────────────────────────────\n");
        boleta.append("• 1 unidad             : " + Constants.OBSEQUIO_1_UNIDAD + "\n");
        boleta.append("• 2 a 5 unidades       : " + Constants.OBSEQUIO_2_A_5 + "\n");
        boleta.append("• Más de 5 unidades    : " + Constants.OBSEQUIO_6_MAS + "\n");
        
        boleta.append("\n═══════════════════════════════════════════════════════\n");
        boleta.append("              ¡GRACIAS POR SU COMPRA!\n");
        boleta.append("═══════════════════════════════════════════════════════");
        
        areaBoleta.setText(boleta.toString());
        areaBoleta.setCaretPosition(0);
    }
    
    private void mostrarAlertaVentas() {
        double porcentajeCuota = (importeTotalGeneral / CUOTA_DIARIA) * 100.0;
        
        String mensaje = String.format(
            "Venta Nro. %d\n" +
            "Importe total general acumulado : %s %s\n" +
            "Porcentaje de la cuota diaria : %.2f%%",
            contadorVentas,
            Constants.MONEDA,
            formatoMoneda.format(importeTotalGeneral),
            porcentajeCuota
        );
        
        JOptionPane.showMessageDialog(
            this,
            mensaje,
            "Avance de ventas",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
