package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import utils.Constants;

public class DialogListarProductos extends JDialog {
    public static final int ANCHO = 700;
    public static final int ALTO = 450;
    
    private JTextArea areaReporte;
    private JScrollPane scrollPane;
    private JButton btnListar;
    private JButton btnCerrar;

    // Colores Xiaomi
    private final Color COLOR_PRIMARIO = new Color(255, 87, 34);   // Naranja fuerte
    private final Color COLOR_SECUNDARIO = new Color(33, 33, 33);  // Gris oscuro
    private final Color COLOR_FONDO = Color.WHITE;

    public DialogListarProductos(JFrame parent) {
        super(parent, "Listar Celulares", true);
        setLayout(null);
        getContentPane().setBackground(COLOR_FONDO);
        
        initComponents();
        setupEventListeners();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblTitulo = new JLabel("CATÁLOGO DE CELULARES XIAOMI - GAMA MEDIA-BAJA", SwingConstants.CENTER);
        lblTitulo.setBounds(30, 20, 620, 30);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setForeground(COLOR_PRIMARIO);
        add(lblTitulo);
        
        areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        areaReporte.setFont(new Font("Courier New", Font.PLAIN, 12));
        areaReporte.setForeground(COLOR_SECUNDARIO);
        areaReporte.setBackground(new Color(250, 250, 250));
        areaReporte.setBorder(BorderFactory.createLineBorder(COLOR_PRIMARIO, 1));
        areaReporte.setText("Presione el botón 'Listar' para generar el catálogo completo de celulares.");
        
        scrollPane = new JScrollPane(areaReporte);
        scrollPane.setBounds(30, 60, 620, 280);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        btnListar = new JButton("Listar");
        btnListar.setBounds(200, 360, 120, 35);
        btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnListar.setBackground(COLOR_PRIMARIO);
        btnListar.setForeground(Color.WHITE);
        btnListar.setFocusPainted(false);
        btnListar.setBorderPainted(false);
        add(btnListar);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(350, 360, 120, 35);
        btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCerrar.setBackground(COLOR_SECUNDARIO);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorderPainted(false);
        add(btnCerrar);
    }
    
    private void setupEventListeners() {
        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });
        
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Hover effect para botones
        btnListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnListar.setBackground(COLOR_SECUNDARIO);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListar.setBackground(COLOR_PRIMARIO);
            }
        });

        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrar.setBackground(COLOR_PRIMARIO);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrar.setBackground(COLOR_SECUNDARIO);
            }
        });
    }
    
    private void generarReporte() {
        StringBuilder reporte = new StringBuilder();
        
        reporte.append("═══════════════════════════════════════════════════════════════════════════════\n");
        reporte.append("                     CATÁLOGO DE CELULARES XIAOMI\n");
        reporte.append("                        GAMA MEDIA-BAJA\n");
        reporte.append("═══════════════════════════════════════════════════════════════════════════════\n\n");
        
        reporte.append(String.format("%-4s %-10s %-15s %-12s %-8s %-15s %-8s\n", 
            "Nº", "MARCA", "MODELO", "PRECIO", "RAM", "ALMACENAMIENTO", "STOCK"));
        reporte.append("───────────────────────────────────────────────────────────────────────────────\n");
        
        for (int i = 0; i < Constants.TOTAL_MODELOS; i++) {
            String numero = String.valueOf(i + 1);
            String marca = Constants.obtenerMarca(i);
            String modelo = Constants.obtenerModelo(i);
            String precio = Constants.MONEDA + " " + String.format("%.2f", Constants.obtenerPrecio(i));
            String ram = Constants.obtenerRAM(i);
            String almacenamiento = Constants.obtenerAlmacenamiento(i);
            String stock = String.valueOf(Constants.obtenerStock(i));
            
            reporte.append(String.format("%-4s %-10s %-15s %-12s %-8s %-15s %-8s\n",
                numero, marca, modelo, precio, ram, almacenamiento, stock));
        }
        
        reporte.append("───────────────────────────────────────────────────────────────────────────────\n\n");
        
        reporte.append("INFORMACIÓN ADICIONAL:\n");
        reporte.append("• Todos los celulares incluyen garantía de 1 año\n");
        reporte.append("• Precios sujetos a stock disponible\n");
        reporte.append("• Descuentos disponibles por volumen de compra\n");
        reporte.append("• Obsequios incluidos según cantidad adquirida\n\n");
        
        double precioMinimo = Constants.obtenerPrecio(0);
        double precioMaximo = Constants.obtenerPrecio(0);
        String modeloMasBarato = Constants.obtenerModelo(0);
        String modeloMasCaro = Constants.obtenerModelo(0);
        
        for (int i = 1; i < Constants.TOTAL_MODELOS; i++) {
            double precioActual = Constants.obtenerPrecio(i);
            String modeloActual = Constants.obtenerModelo(i);
            
            if (precioActual < precioMinimo) {
                precioMinimo = precioActual;
                modeloMasBarato = modeloActual;
            }
            if (precioActual > precioMaximo) {
                precioMaximo = precioActual;
                modeloMasCaro = modeloActual;
            }
        }
        
        reporte.append("ANÁLISIS DE PRECIOS:\n");
        reporte.append(String.format("• Modelo más económico: %s (%s %.2f)\n", 
            modeloMasBarato, Constants.MONEDA, precioMinimo));
        reporte.append(String.format("• Modelo más caro: %s (%s %.2f)\n", 
            modeloMasCaro, Constants.MONEDA, precioMaximo));
        reporte.append(String.format("• Diferencia de precio: %s %.2f\n\n", 
            Constants.MONEDA, (precioMaximo - precioMinimo)));
        
        reporte.append("═══════════════════════════════════════════════════════════════════════════════\n");
        reporte.append("Total de modelos disponibles: " + Constants.TOTAL_MODELOS + "\n");
        reporte.append("Fecha de generación: " + java.time.LocalDateTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
        reporte.append("═══════════════════════════════════════════════════════════════════════════════");
        
        areaReporte.setText(reporte.toString());
        areaReporte.setCaretPosition(0);
    }
}
