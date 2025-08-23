package gui.dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import utils.Constants;

public class DialogListarProductos extends JDialog {
    public static final int ANCHO = 700;
    public static final int ALTO = 450;
    
    private JTextArea areaReporte;
    private JScrollPane scrollPane;
    private JButton btnListar;
    private JButton btnCerrar;

    public DialogListarProductos(JFrame parent) {
        super(parent, "Listar Celulares", true);
        setLayout(null);
        
        initComponents();
        setupEventListeners();
        
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    private void initComponents() {
        JLabel lblTitulo = new JLabel("CATÁLOGO DE CELULARES XIAOMI - GAMA MEDIA-BAJA");
        lblTitulo.setBounds(30, 20, 600, 25);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblTitulo);
        
        areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        areaReporte.setFont(new Font("Courier New", Font.PLAIN, 12));
        areaReporte.setText("Presione el botón 'Listar' para generar el catálogo completo de celulares.");
        
        scrollPane = new JScrollPane(areaReporte);
        scrollPane.setBounds(30, 60, 620, 280);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        
        btnListar = new JButton("Listar");
        btnListar.setBounds(200, 360, 120, 35);
        btnListar.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(btnListar);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(350, 360, 120, 35);
        btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 12));
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
    }
    
    private void generarReporte() {
        StringBuilder reporte = new StringBuilder();
        
        reporte.append("═══════════════════════════════════════════════════════════════════════════════\n");
        reporte.append("                     CATÁLOGO DE CELULARES XIAOMI\n");
        reporte.append("                        GAMA MEDIA-BAJA\n");
        reporte.append("═══════════════════════════════════════════════════════════════════════════════\n\n");
        
        reporte.append(String.format("%-4s %-10s %-15s %-12s %-8s %-15s\n", 
            "Nº", "MARCA", "MODELO", "PRECIO", "RAM", "ALMACENAMIENTO"));
        reporte.append("───────────────────────────────────────────────────────────────────────────────\n");
        
        for (int i = 0; i < Constants.CELULARES_MODELOS.length; i++) {
            String numero = String.valueOf(i + 1);
            String marca = Constants.CELULARES_MARCAS[i];
            String modelo = Constants.CELULARES_MODELOS[i];
            String precio = Constants.MONEDA + " " + String.format("%.2f", Constants.CELULARES_PRECIOS[i]);
            String ram = Constants.CELULARES_RAM[i];
            String almacenamiento = Constants.CELULARES_ALMACENAMIENTO[i];
            
            reporte.append(String.format("%-4s %-10s %-15s %-12s %-8s %-15s\n",
                numero, marca, modelo, precio, ram, almacenamiento));
        }
        
        reporte.append("───────────────────────────────────────────────────────────────────────────────\n\n");
        
        reporte.append("INFORMACIÓN ADICIONAL:\n");
        reporte.append("• Todos los celulares incluyen garantía de 1 año\n");
        reporte.append("• Precios sujetos a stock disponible\n");
        reporte.append("• Descuentos disponibles por volumen de compra\n");
        reporte.append("• Obsequios incluidos según cantidad adquirida\n\n");
        
        double precioMinimo = Constants.CELULARES_PRECIOS[0];
        double precioMaximo = Constants.CELULARES_PRECIOS[0];
        String modeloMasBarato = Constants.CELULARES_MODELOS[0];
        String modeloMasCaro = Constants.CELULARES_MODELOS[0];
        
        for (int i = 1; i < Constants.CELULARES_PRECIOS.length; i++) {
            if (Constants.CELULARES_PRECIOS[i] < precioMinimo) {
                precioMinimo = Constants.CELULARES_PRECIOS[i];
                modeloMasBarato = Constants.CELULARES_MODELOS[i];
            }
            if (Constants.CELULARES_PRECIOS[i] > precioMaximo) {
                precioMaximo = Constants.CELULARES_PRECIOS[i];
                modeloMasCaro = Constants.CELULARES_MODELOS[i];
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
        reporte.append("Total de modelos disponibles: " + Constants.CELULARES_MODELOS.length + "\n");
        reporte.append("Fecha de generación: " + java.time.LocalDateTime.now().format(
            java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
        reporte.append("═══════════════════════════════════════════════════════════════════════════════");
        
        areaReporte.setText(reporte.toString());
        areaReporte.setCaretPosition(0);
    }
}
